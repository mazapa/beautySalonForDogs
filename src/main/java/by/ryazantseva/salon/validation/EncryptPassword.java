package by.ryazantseva.salon.validation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptPassword {
    private static Logger logger = LogManager.getLogger();

    public static String sha1(String input) {
        String sha1 = null;
        try {
            MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
            msdDigest.update(input.getBytes("UTF-8"), 0, input.length());
            sha1 = DatatypeConverter.printHexBinary(msdDigest.digest()).toLowerCase();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            logger.log(org.apache.logging.log4j.Level.ERROR, "encryption mistake!!");

        }
        return sha1;
    }
}
