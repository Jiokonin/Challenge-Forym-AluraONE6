package challenge.forumhub.Forum.Hub.Service;

import challenge.forumhub.Forum.Hub.CrudCore.CrudService;
import challenge.forumhub.Forum.Hub.Model.Entity.Subcategory;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SubcategoryService extends CrudService<Subcategory, Long> {
    @Override
    protected Subcategory editEntity(Subcategory oldEntity, Subcategory entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Subcategory getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Subcategory with id " + id + " not exist!");
        return getReferenceById(id);
    }
}