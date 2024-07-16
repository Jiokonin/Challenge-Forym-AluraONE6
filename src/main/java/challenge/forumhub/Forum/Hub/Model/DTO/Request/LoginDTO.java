package challenge.forumhub.Forum.Hub.Model.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public record LoginDTO(
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
