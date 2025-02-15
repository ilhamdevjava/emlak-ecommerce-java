package az.emlak.emlakecommerce.services;

import az.emlak.emlakecommerce.dtos.category.CategoryDto;
import az.emlak.emlakecommerce.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getHomeCategories ();
    Category getCategoryById (Long id);
    CategoryDto getCategory (Long id);
}
