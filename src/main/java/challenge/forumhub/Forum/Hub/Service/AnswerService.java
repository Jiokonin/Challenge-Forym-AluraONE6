package challenge.forumhub.Forum.Hub.Service;

import challenge.forumhub.Forum.Hub.CrudCore.CrudService;
import challenge.forumhub.Forum.Hub.Model.Entity.Answer;
import challenge.forumhub.Forum.Hub.Model.Entity.Topic;
import challenge.forumhub.Forum.Hub.Model.Entity.User;
import challenge.forumhub.Forum.Hub.Model.Projections.AnswerSlim;
import challenge.forumhub.Forum.Hub.Repository.AnswerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AnswerService extends CrudService<Answer, Long> {

    @Autowired
    private AnswerRepository repository;

    @Override
    protected Answer editEntity(Answer oldEntity, Answer entityToSave) {
        oldEntity.setMessage(entityToSave.getMessage());
        return oldEntity;
    }

    @Override
    public Answer save(Answer entity) {
        return super.save(entity);
    }

    public Page<AnswerSlim> findAllByTopicId(Long id, Pageable pageable) {
        return repository.findAllByTopicId(id, pageable);
    }

    public void setAnswerSolution(Long answerId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Answer answer = getReferenceByIdIfExist(answerId);
        Topic topic = answer.getTopic();
        if (!topic.getAuthor().equals(user))
            throw new AccessDeniedException("You do not have access to this resource!");
        topic.setAnswerSolution(answer);
    }

    @Override
    public Answer getReferenceByIdIfExist(Long id) {
        if (!existsById(id)) throw new EntityNotFoundException("Answer with id " + id + " not exist!");
        return getReferenceById(id);
    }

}
