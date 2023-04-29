package com.example.blogscomments.dto;

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
public class BlogRequest {


    @NotNull(message = "Title Should not be null")
    @Size(min = 3, max = 100, message = "Size Error")
    private String title;

    @NotNull(message = "Content should not be null")
    @Size(min = 3, max = 200, message = "Size Error")
    private String content;
}
