package challenge.forumhub.Forum.Hub.Model.Projections;

import challenge.forumhub.Forum.Hub.Model.Entity.Enums.TopicStatus;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.time.Instant;

@JsonPropertyOrder({"id", "title", "createdAt", "status", "statusName", "category", "subcategory", "course", "author"})
public interface TopicSlimDTO {
    Long getId();

    String getTitle();

    Instant getCreatedAt();

    Integer getStatus();

    default String getStatusName() {
        return TopicStatus.findById(getStatus()).getName();
    }

    CategorySlim getCategory();

    SubcategorySlim getSubcategory();

    CourseSlim getCourse();

    UserSlim getAuthor();

}