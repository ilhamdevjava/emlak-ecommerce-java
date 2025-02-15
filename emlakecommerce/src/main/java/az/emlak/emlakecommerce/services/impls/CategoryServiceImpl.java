package az.emlak.emlakecommerce.services.impls;

import az.emlak.emlakecommerce.dtos.category.CategoryDto;
import az.emlak.emlakecommerce.model.Category;
import az.emlak.emlakecommerce.repositories.CategoryRepository;
import az.emlak.emlakecommerce.services.CategoryService;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Category> getHomeCategories() {
        List<Category> categories =categoryRepository.findAll();
        return categories;
    }

    @Override
    public CategoryDto getCategory(Long id) {
        Category findCategory =categoryRepository.findById(id).orElseThrow();
        CategoryDto result = modelMapper.map(findCategory,CategoryDto.class);
        return result;
    }

    @Override
    public Category getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow();
        return category;
    }
}
