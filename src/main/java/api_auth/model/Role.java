package api_auth.model;

import api_auth.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  Definição do Model Roles que será tabela no banco
 */

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesEnum roleName;

    public Role(RolesEnum roleName) {
        this.roleName = roleName;
    }
}
