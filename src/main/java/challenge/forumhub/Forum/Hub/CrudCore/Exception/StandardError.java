package challenge.forumhub.Forum.Hub.CrudCore.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StandardError {
    private Integer status;
    private String error;
    private String message;
}