package api_auth.model;

import api_auth.enums.RolesEnum;
import jakarta.persistence.*;
import lombok.Data;

/**
 *  Definição do Model Roles que será tabela no banco
 */

@Data
@Entity
@Table(name = "tb_roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private RolesEnum roleName;
}
