package az.emlak.emlakecommerce.dtos.auth;

import lombok.Data;

@Data
public class LoginDto {
    private String email;
    private String password;
}
