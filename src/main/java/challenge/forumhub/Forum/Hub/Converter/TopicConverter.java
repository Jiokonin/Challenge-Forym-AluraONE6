package challenge.forumhub.Forum.Hub.Converter;

import challenge.forumhub.Forum.Hub.CrudCore.CrudConverter;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.TopicDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.TopicResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Category;
import challenge.forumhub.Forum.Hub.Model.Entity.Course;
import challenge.forumhub.Forum.Hub.Model.Entity.Subcategory;
import challenge.forumhub.Forum.Hub.Model.Entity.Topic;
import challenge.forumhub.Forum.Hub.Model.Entity.Enums.TopicStatus;
import challenge.forumhub.Forum.Hub.Service.CategoryService;
import challenge.forumhub.Forum.Hub.Service.CourseService;
import challenge.forumhub.Forum.Hub.Service.SubcategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class TopicConverter implements CrudConverter<Topic, TopicDTO, TopicResponseDTO> {

    CourseConverter courseConverter;
    CourseService courseService;

    CategoryConverter categoryConverter;
    CategoryService categoryService;

    SubcategoryConverter subcategoryConverter;
    SubcategoryService subcategoryService;

    @Override
    public Topic dtoCadToEntity(TopicDTO dtocad) {
        Topic topic = new Topic();
        topic.setTitle(dtocad.getTitle());
        topic.setMessage(dtocad.getMessage());
        if (dtocad.getCourseID() != null) {
            Course course = courseService.getReferenceByIdIfExist(dtocad.getCourseID());
            Subcategory subcategory = course.getSubcategory();
            Category category = subcategory.getCategory();
            topic.setCourse(course);
            topic.setSubcategory(subcategory);
            topic.setCategory(category);
        } else {
            if (dtocad.getSubcategoryId() != null)
                topic.setSubcategory(subcategoryService.getReferenceByIdIfExist(dtocad.getSubcategoryId()));
            if (dtocad.getCategoryId() != null)
                topic.setCategory(categoryService.getReferenceByIdIfExist(dtocad.getCategoryId()));
        }
        return topic;
    }

    @Override
    public TopicResponseDTO entityToDTOResponse(Topic entity) {
        return new TopicResponseDTO(entity.getId(),
                entity.getTitle(),
                entity.getMessage(),
                entity.getCreatedAt(),
                TopicStatus.findById(entity.getStatus()),
                categoryConverter.entityToDTOResponse(entity.getCategory()),
                subcategoryConverter.entityToDTOResponse(entity.getSubcategory()),
                courseConverter.entityToDTOResponse(entity.getCourse()),
                entity.getAuthor().getName()
        );
    }
}
