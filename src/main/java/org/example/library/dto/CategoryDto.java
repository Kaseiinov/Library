package org.example.library.dto;

import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.example.library.model.Book;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String category;

    private List<BookDto> books;
}
