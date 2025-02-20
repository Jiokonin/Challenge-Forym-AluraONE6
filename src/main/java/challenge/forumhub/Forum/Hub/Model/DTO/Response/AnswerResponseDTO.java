package challenge.forumhub.Forum.Hub.Model.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AnswerResponseDTO {
    private Long id;
    private String message;
    private LocalDateTime createdAt;
    private UserResponseDTO author;
}
