package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.CrudCore.CrudController;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.CategoryDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.CategoryResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Category;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<Category, Long, CategoryDTO, CategoryResponseDTO> {

}
