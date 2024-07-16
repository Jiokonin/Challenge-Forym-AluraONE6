package challenge.forumhub.Forum.Hub.Converter;

import challenge.forumhub.Forum.Hub.CrudCore.CrudConverter;
import challenge.forumhub.Forum.Hub.Model.DTO.Request.AnswerDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.AnswerResponseDTO;
import challenge.forumhub.Forum.Hub.Model.DTO.Response.UserResponseDTO;
import challenge.forumhub.Forum.Hub.Model.Entity.Answer;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter implements CrudConverter<Answer, AnswerDTO, AnswerResponseDTO> {

    @Override
    public Answer dtoCadToEntity(AnswerDTO dtocad) {
        Answer answer = new Answer();
        answer.setMessage(dtocad.getMessage());
        return answer;
    }

    @Override
    public AnswerResponseDTO entityToDTOResponse(Answer entity) {
        return new AnswerResponseDTO(entity.getId(), entity.getMessage(), entity.getCreatedAt(), new UserResponseDTO(entity.getAuthor().getName()));
    }
}
