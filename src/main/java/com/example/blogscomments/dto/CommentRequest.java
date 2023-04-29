package com.example.blogscomments.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRequest {

    @NotNull(message = "Blog ID should not be null")
    private Long blogId;

    @NotNull(message = "Comment should not be null")
    @Size(min = 3, max = 200)
    private String comment;
}
