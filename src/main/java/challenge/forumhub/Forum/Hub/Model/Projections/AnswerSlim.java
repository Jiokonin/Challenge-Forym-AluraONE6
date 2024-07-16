package challenge.forumhub.Forum.Hub.Model.Projections;

import java.time.LocalDateTime;

public interface AnswerSlim {
    Long getId();

    String getMessage();

    LocalDateTime getCreatedAt();

    UserSlim getAuthor();
}
