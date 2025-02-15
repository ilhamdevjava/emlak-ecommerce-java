package az.emlak.emlakecommerce.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    private String name;
    private String email;
    private String password;
    private Set<Long> roleIds;
}
