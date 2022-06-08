package com.example.t2009m1java.entity;

import com.example.t2009m1java.entity.base.BaseEntity;
import com.example.t2009m1java.entity.myenum.AccountStatus;
import com.example.t2009m1java.entity.myenum.ProductStatus;
import com.example.t2009m1java.service.StringValidationHelper;

import java.time.LocalDateTime;
import java.util.HashMap;

public class Account extends BaseEntity {
    private int id;
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
    private int roleId;
    private AccountStatus status; // 1. active, -1. deleted, 0. deactive

    public Account() {
        this.email = "";
        this.username = "";
        this.fullName = "";
        this.setCreatedAt(LocalDateTime.now());
        this.setUpdatedAt(LocalDateTime.now());
        this.setCreatedBy(0);
        this.setUpdatedBy(0);
        this.status = AccountStatus.ACTIVE;
    }

    public Account(int id, String username, String password, String fullName, AccountStatus status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", status=" + status + '\'' +
                ", createdAt=" + getCreatedAt() + '\'' +
                ", updatedAt=" + getUpdatedAt() + '\'' +
                ", createdBy=" + getCreatedBy() + '\'' +
                ", updatedBy=" + getUpdatedBy() + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
        this.status = status;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }

    private void checkValid() {
        if (username == null || username.length() == 0) {
            errors.put("username", "Please enter username.");
        }
        if (password == null || password.length() == 0) {
            errors.put("password", "Please enter password.");
        }
        if (password != null && password.length() > 0
                && !password.equals(confirmPassword)) {
            errors.put("confirmPassword", "Confirm password is not match.");
        }
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter full name.");
        }
        if (email == null || email.length() == 0) {
            errors.put("email", "Please enter email.");
        }
        if(email != null && email.length() > 0 && !StringValidationHelper.checkValidEmail(email)){
            errors.put("email", "Invalid email.");
        }
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }


    public static final class AccountBuilder {
        private int id;
        private String username;
        private String email;
        private String password;
        private String confirmPassword;
        private String fullName;
        private int roleId;
        private AccountStatus status; // 1. active, -1. deleted, 0. deactive
        private HashMap<String, String> errors = new HashMap<>();
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        private LocalDateTime deletedAt;
        private int createdBy;
        private int updatedBy;
        private int deletedBy;

        private AccountBuilder() {
            this.username = ("");
            this.email = ("");
            this.password = ("");
            this.confirmPassword = ("");
            this.fullName = ("");
            this.roleId = 1;
            this.createdAt = (LocalDateTime.now());
            this.updatedAt = (LocalDateTime.now());
            this.createdBy = (0);
            this.updatedBy = (0);
            this.status = (AccountStatus.ACTIVE);
        }

        public static AccountBuilder anAccount() {
            return new AccountBuilder();
        }

        public AccountBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public AccountBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public AccountBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AccountBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AccountBuilder withConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public AccountBuilder withFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public AccountBuilder withRoleId(int roleId) {
            this.roleId = roleId;
            return this;
        }

        public AccountBuilder withStatus(AccountStatus status) {
            this.status = status;
            return this;
        }

        public AccountBuilder withErrors(HashMap<String, String> errors) {
            this.errors = errors;
            return this;
        }

        public AccountBuilder withCreatedAt(LocalDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public AccountBuilder withUpdatedAt(LocalDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public AccountBuilder withDeletedAt(LocalDateTime deletedAt) {
            this.deletedAt = deletedAt;
            return this;
        }

        public AccountBuilder withCreatedBy(int createdBy) {
            this.createdBy = createdBy;
            return this;
        }

        public AccountBuilder withUpdatedBy(int updatedBy) {
            this.updatedBy = updatedBy;
            return this;
        }

        public AccountBuilder withDeletedBy(int deletedBy) {
            this.deletedBy = deletedBy;
            return this;
        }

        public Account build() {
            Account account = new Account();
            account.setId(id);
            account.setUsername(username);
            account.setEmail(email);
            account.setPassword(password);
            account.setConfirmPassword(confirmPassword);
            account.setFullName(fullName);
            account.setRoleId(roleId);
            account.setStatus(status);
            account.setErrors(errors);
            account.setCreatedAt(createdAt);
            account.setUpdatedAt(updatedAt);
            account.setDeletedAt(deletedAt);
            account.setCreatedBy(createdBy);
            account.setUpdatedBy(updatedBy);
            account.setDeletedBy(deletedBy);
            return account;
        }
    }
}
