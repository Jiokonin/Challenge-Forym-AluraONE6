package challenge.forumhub.Forum.Hub.CrudCore;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface CrudRepository<E, ID> extends JpaRepository<E, ID> {
}