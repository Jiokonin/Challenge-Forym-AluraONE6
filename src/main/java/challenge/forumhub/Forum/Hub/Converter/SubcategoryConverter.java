package challenge.forumhub.Forum.Hub.Converter;

import challenge.forumhub.Forum.Hub.CrudCore.CrudConverter;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.SubcategoryDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.SubcategoryResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Subcategory;
import org.springframework.stereotype.Component;

@Component
public class SubcategoryConverter implements CrudConverter<Subcategory, SubcategoryDTO, SubcategoryResponseDTO> {
    @Override
    public Subcategory dtoCadToEntity(SubcategoryDTO dtocad) {
        Subcategory subcategory = new Subcategory();
        subcategory.setName(dtocad.getNome());
        return subcategory;
    }

    @Override
    public SubcategoryResponseDTO entityToDTOResponse(Subcategory entity) {
        if (entity == null) return null;
        return new SubcategoryResponseDTO(entity.getId(), entity.getName());
    }
}
