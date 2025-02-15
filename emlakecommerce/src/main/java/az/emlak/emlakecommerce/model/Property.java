package az.emlak.emlakecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "properties")
public class Property {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double price;
    private String address;
    private Double area;
    private Integer bedrooms;
    private Integer bathrooms;
    private String imageUrl;

    @ManyToOne
    private  Category category;

    @ManyToOne
    private  ListingType listingType;
}

