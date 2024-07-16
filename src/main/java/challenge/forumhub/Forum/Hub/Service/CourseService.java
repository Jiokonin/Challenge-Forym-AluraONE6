package challenge.forumhub.Forum.Hub.Service;

import challenge.forumhub.Forum.Hub.CrudCore.CrudService;
import challenge.forumhub.Forum.Hub.Model.Entity.Course;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CourseService extends CrudService<Course, Long> {
    @Override
    protected Course editEntity(Course oldEntity, Course entityToSave) {
        oldEntity.setName(entityToSave.getName());
        return oldEntity;
    }

    @Override
    public Course getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Course with id " + id + " not exist!");
        return getReferenceById(id);
    }
}