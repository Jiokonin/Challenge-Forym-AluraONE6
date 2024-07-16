package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.CrudCore.CrudController;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.SubcategoryDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.SubcategoryResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Subcategory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategories")
public class SubcategoryController extends CrudController<Subcategory, Long, SubcategoryDTO, SubcategoryResponseDTO> {

}