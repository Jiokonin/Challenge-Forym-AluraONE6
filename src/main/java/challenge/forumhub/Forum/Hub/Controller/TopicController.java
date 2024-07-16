package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.Converter.AnswerConverter;
import challenge.forumhub.Forum.Hub.CrudCore.CrudController;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.AnswerDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.TopicDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.AnswerResponseDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.TopicResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Answer;
import challenge.forumhub.Forum.Hub.Model.Entity.Topic;
import challenge.forumhub.Forum.Hub.Model.Projections.AnswerSlim;
import challenge.forumhub.Forum.Hub.Model.Projections.TopicCompleteDTO;
import challenge.forumhub.Forum.Hub.Model.Projections.TopicSlimDTO;
import challenge.forumhub.Forum.Hub.Service.AnswerService;
import challenge.forumhub.Forum.Hub.Service.TopicService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topics")
@AllArgsConstructor
public class TopicController extends CrudController<Topic, Long, TopicDTO, TopicResponseDTO> {

    private TopicService topicService;
    private AnswerService answerService;
    private AnswerConverter answerConverter;

    @Override
    public ResponseEntity<Page<TopicSlimDTO>> findAll(Pageable pageable) {
        return ResponseEntity.ok(topicService.findAllSlim(pageable));
    }

    @Override
    public ResponseEntity<TopicCompleteDTO> findById(@PathVariable("id") Long aLong) {
        return ResponseEntity.ok(topicService.findComplete(aLong));
    }

    @GetMapping("/{id}/answers")
    public ResponseEntity<Page<AnswerSlim>> findAnswersByTopic(@PathVariable("id") Long id, Pageable pageable) {
        Page<AnswerSlim> answers = answerService.findAllByTopicId(id, pageable);
        return ResponseEntity.ok(answers);
    }

    @Transactional
    @PostMapping("/{id}/answers")
    public ResponseEntity<AnswerResponseDTO> addAnswerToPost(@PathVariable("id") Long id, @RequestBody @Valid AnswerDTO answerDTO) {
        Answer answer = answerConverter.dtoCadToEntity(answerDTO);
        Answer answer1 = topicService.addAnswerToPost(answer, id);
        return ResponseEntity.ok(answerConverter.entityToDTOResponse(answer1));
    }


}
