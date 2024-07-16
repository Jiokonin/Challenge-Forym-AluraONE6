package challenge.forumhub.Forum.Hub.Model.DTO.Response;

import challenge.forumhub.Forum.Hub.Model.Entity.Enums.TopicStatus;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class TopicResponseDTO {
    private Long id;
    private String title;
    private String message;
    private LocalDateTime createdAt;
    private TopicStatus status;
    private CategoryResponseDTO category;
    private SubcategoryResponseDTO subcategory;
    private CourseResponseDTO course;
    private String user;
}