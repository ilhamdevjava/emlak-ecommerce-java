package az.emlak.emlakecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "testimonials")
@Entity
public class Testimonial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String authorName; // Müəllif adı
    private String authorPosition; // Müəllifin vəzifəsi
    private String authorImage; // Müəllifin şəkil URL-i
    private String feedback; // Rəy

}
