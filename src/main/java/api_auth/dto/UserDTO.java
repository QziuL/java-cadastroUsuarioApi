package api_auth.dto;

import api_auth.model.User;
import lombok.Data;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;

    public User convertToUser() {
        return new User(this.username, this.email, this.password, this.confirmPassword);
    }

    public UserDTO getSelf() {
        return this;
    }
}
