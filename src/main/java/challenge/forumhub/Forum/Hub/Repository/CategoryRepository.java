package challenge.forumhub.Forum.Hub.Repository;

import challenge.forumhub.Forum.Hub.CrudCore.CrudRepository;
import challenge.forumhub.Forum.Hub.Model.Entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
