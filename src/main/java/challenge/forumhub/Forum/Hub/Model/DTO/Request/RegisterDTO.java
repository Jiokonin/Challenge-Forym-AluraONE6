package challenge.forumhub.Forum.Hub.Model.DTO.Request;

import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank
        String name,
        @NotBlank
        String login,
        @NotBlank
        String password) {
}
