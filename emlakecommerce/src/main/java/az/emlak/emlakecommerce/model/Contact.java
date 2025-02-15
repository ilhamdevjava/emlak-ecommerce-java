package az.emlak.emlakecommerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String email;
    private String phone;
    private String map;

    public Contact() {}

    public Contact(String address, String email, String phone,String map) {
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.map = map;
    }

    // Call to Action (CTA) Bölümü
    private String imageUrl;
    private String title;
    private String description;
    private String callButtonText;
    private String callButtonUrl;
    private String appointmentButtonText;
    private String appointmentButtonUrl;
}
