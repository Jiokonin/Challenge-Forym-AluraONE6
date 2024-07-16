package challenge.forumhub.Forum.Hub.Controller;

import challenge.forumhub.Forum.Hub.CrudCore.CrudController;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.AnswerDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.AnswerResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Answer;
import challenge.forumhub.Forum.Hub.Service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController extends CrudController<Answer, Long, AnswerDTO, AnswerResponseDTO> {

    @Autowired
    private AnswerService answerService;

    @Override
    public ResponseEntity<String> create(AnswerDTO e) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    @Transactional
    @PostMapping("{id}/answer_solution")
    public ResponseEntity<Void> answerSolution(@PathVariable("id") Long answerId) {
        answerService.setAnswerSolution(answerId);
        return ResponseEntity.ok().build();
    }

}