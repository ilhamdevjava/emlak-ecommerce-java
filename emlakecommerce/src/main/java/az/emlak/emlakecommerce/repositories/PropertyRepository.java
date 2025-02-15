package az.emlak.emlakecommerce.repositories;

import az.emlak.emlakecommerce.model.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    // Category ID'ye göre filtreleme
    List<Property> findByCategoryId(Long categoryId);

    // ListingType ID'ye göre filtreleme
    List<Property> findByListingTypeId(Long listingTypeId);
}
