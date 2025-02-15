package az.emlak.emlakecommerce.services.impls;

import az.emlak.emlakecommerce.model.Property;
import az.emlak.emlakecommerce.repositories.PropertyRepository;
import az.emlak.emlakecommerce.services.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    @Autowired
    public PropertyServiceImpl(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    @Override
    public List<Property> getHomeProperties() {
        List<Property> properties =propertyRepository.findAll();
        return properties;
    }

    @Override
    public List<Property> getPropertiesByCategory(Long categoryId) {
        return propertyRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Property> getPropertiesByListingType(Long listingTypeId) {
        return propertyRepository.findByListingTypeId(listingTypeId);
    }

    @Override
    public Property getPropertyById(Long id) {
        return propertyRepository.findById(id).orElse(null);
    }
}
