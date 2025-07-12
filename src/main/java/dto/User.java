package dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User {
    private final String username;
    private final String password;
    private final String fullName;
    private final LocalDate birthDate;
    private final LocalDateTime registrationDateTime;
    private final ERole role;

    private User(String username, String password, String fullName, LocalDate birthDate, LocalDateTime registrationDateTime, ERole role) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.registrationDateTime = registrationDateTime;
        this.role = role;
    }

    public static Builder builder() {
        return new Builder();
    }
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDateTime getRegistrationDateTime() {
        return registrationDateTime;
    }

    public ERole getRole() {
        return role;
    }

    public static class Builder {
        private String username;
        private String password;
        private String fullName;
        private LocalDate birthDate;
        private LocalDateTime registrationDateTime = LocalDateTime.now();
        private ERole role = ERole.USER;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder fullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Builder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public Builder registrationDate(LocalDateTime registrationDateTime) {
            this.registrationDateTime = registrationDateTime;
            return this;
        }
        public Builder role(ERole role) {
            this.role = role;
            return this;
        }
        public User build() {
            return new User(username, password, fullName, birthDate, registrationDateTime, role);
        }
    }
}
