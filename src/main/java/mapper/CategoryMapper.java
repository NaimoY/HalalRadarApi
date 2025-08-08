package mapper;

import com.halalradar.api.dtos.CategoryDto;
import com.halalradar.api.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category mapToCategroy(CategoryDto categoryDtos){

        Category category = new Category();
        category.setId(categoryDtos.getId());
        category.setName(categoryDtos.getName());

        return category;
    }

    public CategoryDto mapToCategoryDto(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());



        return categoryDto;
    }

}


