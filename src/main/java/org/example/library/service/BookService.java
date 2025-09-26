package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.Repository.BookRepository;
import org.example.library.dto.BookDto;
import org.example.library.dto.CategoryDto;
import org.example.library.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final UserService userService;
    private final CategoryService categoryService;

    public Page<BookDto> findAllByCategory(String category, Pageable pageable) {
        Page<Book> books;
        if(category == null) {
            books = bookRepository.findAll(pageable);
        }else {
            books = bookRepository.findAllByCategoryCategory(category, pageable);
        }
        return convertDtoToModel(books);
    }

    public Page<BookDto> convertDtoToModel(Page<Book> books){
        List<BookDto> bookDtoList = books.getContent()
                .stream()
                .map(b -> BookDto
                        .builder()
                        .id(b.getId())
                        .name(b.getName())
                        .author(b.getAuthor())
                        .avatar(b.getAvatar())
                        .available(b.getAvailable())
                        .returnDate(b.getReturnDate())
                        .category(categoryService.getByBookId(b.getId()))
                        .users(userService.findAllByBookId(b.getId()))
                        .build()
                ).toList();
        return new PageImpl<>(bookDtoList, books.getPageable(), books.getTotalElements());


    }

}
