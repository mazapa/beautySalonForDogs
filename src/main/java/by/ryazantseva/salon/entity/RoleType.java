package by.ryazantseva.salon.entity;

public enum RoleType {
    GUEST {
        {
            this.role = "guest";
        }
    },
    ADMIN {
        {
            this.role = "admin";
        }
    },
    USER {
        {
            this.role = "user";
        }
    };

    String role;

    public String getRole() {
        return role;
    }

}
