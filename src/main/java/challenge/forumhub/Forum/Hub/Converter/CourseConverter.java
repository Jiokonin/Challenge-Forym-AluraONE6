package challenge.forumhub.Forum.Hub.Converter;

import challenge.forumhub.Forum.Hub.CrudCore.CrudConverter;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.CourseDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.CourseResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Course;
import challenge.forumhub.Forum.Hub.Repository.Subcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseConverter implements CrudConverter<Course, CourseDTO, CourseResponseDTO> {

    @Autowired
    Subcat subcategoryRepository;

    @Override
    public Course dtoCadToEntity(CourseDTO dtocad) {
        Course course = new Course();
        course.setName(dtocad.getNome());
        course.setSubcategory((challenge.forumhub.Forum.Hub.Model.Entity.Subcategory) subcategoryRepository.getReferenceById(dtocad.getSubcategoryId()));
        return course;
    }

    @Override
    public CourseResponseDTO entityToDTOResponse(Course entity) {
        if (entity == null) return null;
        return new CourseResponseDTO(entity.getId(), entity.getName());
    }
}
