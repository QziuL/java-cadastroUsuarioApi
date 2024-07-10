package api_auth.dto;

import api_auth.model.Role;
import api_auth.model.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    private String confirmPassword;
    private List<String> roles;

    public User convertToUser() {
        return new User(this.username, this.email, this.password, this.roles);
    }
}
