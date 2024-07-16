package challenge.forumhub.Forum.Hub.Repository;

import challenge.forumhub.Forum.Hub.CrudCore.CrudRepository;
import challenge.forumhub.Forum.Hub.Model.Entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
}
