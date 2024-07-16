package challenge.forumhub.Forum.Hub.Service;

import challenge.forumhub.Forum.Hub.CrudCore.CrudService;
import challenge.forumhub.Forum.Hub.Model.Entity.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends CrudService<Category, Long> {
    @Override
    protected Category editEntity(Category oldEntity, Category entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Category getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Category with id " + id + " not exist!");
        return getReferenceById(id);
    }

}