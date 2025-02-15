package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.model.Property;

import java.util.List;

public interface PropertyService {
    List<Property> getHomeProperties();
    List<Property> getPropertiesByCategory(Long categoryId);
    List<Property> getPropertiesByListingType(Long listingTypeId);
    Property getPropertyById(Long id);
}
