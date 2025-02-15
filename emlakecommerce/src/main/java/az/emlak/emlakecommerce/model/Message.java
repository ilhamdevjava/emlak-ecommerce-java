package az.emlak.emlakecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Message {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Otomatik artırılan birincil anahtar

    @NotBlank(message = "Ad boş bırakılamaz")
    @Size(max = 50, message = "Ad en fazla 50 karakter olabilir")
    private String firstName;  // Gönderenin adı

    @NotBlank(message = "Soyad boş bırakılamaz")
    @Size(max = 50, message = "Soyad en fazla 50 karakter olabilir")
    private String lastName;  // Gönderenin soyadı

    @NotBlank(message = "E-posta boş bırakılamaz")
    @Email(message = "Geçerli bir e-posta adresi girin")
    private String email;  // Gönderenin e-posta adresi

    @NotBlank(message = "Mesaj boş bırakılamaz")
    @Size(max = 500, message = "Mesaj en fazla 500 karakter olabilir")
    private String content;  // Mesaj içeriği

    private LocalDateTime sentAt;  // Mesajın gönderilme zamanı

    @Column(name = "is_read")
    private Boolean isRead;

    // **Varsayılan Yapıcı (Default Constructor)**
    public Message() {
        this.sentAt = LocalDateTime.now();  // Gönderim zamanı otomatik atanır
    }

    // **Parametreli Yapıcı**
    public Message(String firstName, String lastName, String email, String content) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.content = content;
        this.sentAt = LocalDateTime.now();

    }
}