package az.emlak.emlakecommerce.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listing_types")
public class ListingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Örneğin: "Satılık", "Kiralık"
    private String description;

    @OneToMany (mappedBy = "listingType")
    private List<Property> properties;

}
