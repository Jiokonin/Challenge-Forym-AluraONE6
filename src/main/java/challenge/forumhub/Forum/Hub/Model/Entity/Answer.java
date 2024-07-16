package challenge.forumhub.Forum.Hub.Model.Entity;

import challenge.forumhub.Forum.Hub.CrudCore.CrudDomain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Answer implements CrudDomain<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime createdAt = LocalDateTime.now();
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_topic")
    private Topic topic;
    @ManyToOne
    @JoinColumn(name = "fk_author")
    private User author;
}
