package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.CategoryRepository;
import org.example.library.dto.CategoryDto;
import org.example.library.model.Category;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryDto getByBookId(Long bookId) {
        Category category = categoryRepository.findCategoryByBookId(bookId);
        return convertToDto(category);
    }

    public CategoryDto convertToDto(Category category) {
        return CategoryDto
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
