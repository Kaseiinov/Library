package org.example.library.dto;

import jakarta.persistence.*;
import lombok.*;
import org.example.library.model.Category;
import org.example.library.model.History;
import org.example.library.model.User;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDto {
    private Long id;
    private String name;
    private String author;
    private String avatar;
    private Boolean available;
    private LocalDate returnDate;

    private HistoryDto history;

    private List<UserDto> users;

    private CategoryDto category;
}
