package by.it_academy.jd2.core.dto;

public class AuthUser {
    private final String username;
    private final ERole role;

    private AuthUser(String username,ERole role){
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public ERole getRole() {
        return role;
    }
    public static Builder builder(){
        return new Builder();
    }
    public static class Builder{
        private String username;
        private ERole role;

        public Builder username(String username) {
            this.username = username;
            return this;
        }

        public Builder role(ERole role) {
            this.role = role;
            return this;
        }

        public AuthUser build() {
            return new AuthUser(username,role);
        }
    }
}
