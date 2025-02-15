package az.emlak.emlakecommerce.dtos.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContactUpdateDto {
    private String email;
    private String phone;
    private String address;
}
