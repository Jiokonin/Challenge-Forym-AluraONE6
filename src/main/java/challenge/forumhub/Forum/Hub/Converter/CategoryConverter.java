package challenge.forumhub.Forum.Hub.Converter;

import challenge.forumhub.Forum.Hub.CrudCore.CrudConverter;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.CategoryDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.CategoryResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter implements CrudConverter<Category, CategoryDTO, CategoryResponseDTO> {

    @Override
    public Category dtoCadToEntity(CategoryDTO dtocad) {
        Category category = new Category();
        category.setName(dtocad.getNome());
        return category;
    }

    @Override
    public CategoryResponseDTO entityToDTOResponse(Category entity) {
        return new CategoryResponseDTO(entity.getId(), entity.getName());
    }
}
