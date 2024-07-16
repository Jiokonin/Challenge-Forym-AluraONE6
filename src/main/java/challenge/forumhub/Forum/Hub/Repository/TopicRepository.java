package challenge.forumhub.Forum.Hub.Repository;

import challenge.forumhub.Forum.Hub.CrudCore.CrudRepository;
import challenge.forumhub.Forum.Hub.Model.Entity.Topic;
import challenge.forumhub.Forum.Hub.Model.Projections.TopicCompleteDTO;
import challenge.forumhub.Forum.Hub.Model.Projections.TopicSlimDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {

    Page<TopicSlimDTO> findAllBy(Pageable pageable);

    Optional<TopicCompleteDTO> findTopicCompleteById(Long aLong);

    @Query("SELECT t.status FROM Topic t WHERE t.id = :id")
    Integer findStatusById(Long id);

    List<TopicSlimDTO> findAllTopicSlimByCategoryId(Long id);

    List<TopicSlimDTO> findAllByAuthor(UserDetails user);

    @Override
    Optional<Topic> findById(Long aLong);

}
