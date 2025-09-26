package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.CategoryRepository;
import org.example.library.dto.CategoryDto;
import org.example.library.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return convertToDto(categories);
    }

    public CategoryDto getByBookId(Long bookId) {
        Category category = categoryRepository.findCategoryByBookId(bookId);
        return convertToDto(category);
    }

    public CategoryDto convertToDto(Category category) {
        return CategoryDto
                .builder()
                .id(category.getId())
                .category(category.getCategory())
                .build();
    }

    public List<CategoryDto> convertToDto(List<Category> categories) {
        return categories
                .stream()
                .map(c -> CategoryDto
                        .builder()
                        .id(c.getId())
                        .category(c.getCategory())
                        .build()
                ).toList();
    }



}
