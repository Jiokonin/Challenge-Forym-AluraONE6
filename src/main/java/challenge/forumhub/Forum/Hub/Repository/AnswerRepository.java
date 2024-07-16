package challenge.forumhub.Forum.Hub.Repository;

import challenge.forumhub.Forum.Hub.CrudCore.CrudRepository;
import challenge.forumhub.Forum.Hub.Model.Entity.Answer;
import challenge.forumhub.Forum.Hub.Model.Projections.AnswerSlim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {

    Page<AnswerSlim> findAllByTopicId(Long id, Pageable pageable);
}
