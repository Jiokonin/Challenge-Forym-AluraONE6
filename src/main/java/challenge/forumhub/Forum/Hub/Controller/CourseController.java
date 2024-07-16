package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.CrudCore.CrudController;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.CourseDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.CourseResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends CrudController<Course, Long, CourseDTO, CourseResponseDTO> {
}
