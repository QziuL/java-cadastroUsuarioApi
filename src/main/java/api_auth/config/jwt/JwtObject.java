package api_auth.config.jwt;

import lombok.Data;

import java.util.*;

@Data
public class JwtObject {
    private String subject;
    private Date issuedAt;
    private Date expiresAt;
    private List<String> roles;

    public void setRoles(String... roles) {
        this.roles = Arrays.asList(roles);
    }
}
