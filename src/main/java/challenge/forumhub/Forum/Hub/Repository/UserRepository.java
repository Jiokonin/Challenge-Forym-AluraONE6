package challenge.forumhub.Forum.Hub.Repository;

import challenge.forumhub.Forum.Hub.CrudCore.CrudRepository;
import challenge.forumhub.Forum.Hub.Model.Entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    UserDetails findByLogin(String login);
}
