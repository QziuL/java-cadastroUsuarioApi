package api_auth.dto;

import api_auth.enums.RolesEnum;
import api_auth.model.Role;
import lombok.Data;

@Data
public class RoleDTO {
    private RolesEnum roleName;

    public Role convertToRole() {
        return new Role(this.roleName);
    }
}
