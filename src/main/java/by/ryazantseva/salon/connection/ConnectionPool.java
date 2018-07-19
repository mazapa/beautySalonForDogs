package by.ryazantseva.salon.connection;

import by.ryazantseva.salon.exception.ConnectionException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool {
    public static final int MIN_CONNECTION_SIZE = 1;
    private static Logger logger = LogManager.getLogger();
    private static final String PROPERTIES_POOL_SIZE = "poolSize";
    private static final String PROPERTIES_FILE_PATH = "properties/poolConfig.properties";
    private static final String PROPERTIES_URL = "url";
    private BlockingQueue<ProxyConnection> connections;
    private static AtomicBoolean created = new AtomicBoolean(false);
    private static ReentrantLock lock = new ReentrantLock();
    private static ConnectionPool connectionPool;
    private Properties properties;


    private ConnectionPool() {
        init();
    }

    public static ConnectionPool getInstance() {
        if (!created.get()) {
            lock.lock();
            try {
                if (connectionPool == null) {
                    connectionPool = new ConnectionPool();
                    created.set(true);
                }
            } finally {
                lock.unlock();
            }
        }
        return connectionPool;
    }

    private void init() {
        properties = new Properties();
        try {
            properties.load(this.getClass().getClassLoader().getResourceAsStream(PROPERTIES_FILE_PATH));
        } catch (IOException e) {
            throw new RuntimeException("Can`t load properties file!", e);
        }
        int poolSize = Integer.parseInt(properties.getProperty(PROPERTIES_POOL_SIZE));
        String url = properties.getProperty(PROPERTIES_URL);
        connections = new ArrayBlockingQueue<>(poolSize);

        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        } catch (SQLException e) {
            throw new RuntimeException("Can`t register driver!",e);
        }

        while (connections.size() < poolSize) {
            Connection connection = null;
            try {
                connection = DriverManager.getConnection(url, properties);
            } catch (SQLException e) {
                logger.log(Level.ERROR, "Can`t create connection!");///logger?????????
            }
            connections.offer(new ProxyConnection(connection));
        }
        if(connections.size()< MIN_CONNECTION_SIZE){
            throw new RuntimeException("There is not enough connections!");
        }
    }


    public ProxyConnection getConnection() {
        ProxyConnection connection = null;
        try {
            connection = connections.take();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return connection;
    }

    public void releaseConnection(ProxyConnection connection) {
        try {
            if(!connection.getAutoCommit()){
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Problems with connection.");
        }
        try {
            connections.put(connection);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public void destroyConnections() {
        while (connections.size() < Integer.parseInt(properties.getProperty(PROPERTIES_POOL_SIZE))) {
            try {
                ProxyConnection connection = connections.take();
                try {
                    connection.closeConnection();
                    Enumeration<Driver> drivers = DriverManager.getDrivers();
                    while (drivers.hasMoreElements()) {
                        Driver driver = drivers.nextElement();
                        DriverManager.deregisterDriver(driver);
                    }

                } catch (SQLException e) {
                    logger.log(Level.ERROR, "Problems with destroy connection or driver!");
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        }
    }

}
