package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookDto;
import org.example.library.dto.CategoryDto;
import org.example.library.model.Category;
import org.example.library.service.BookService;
import org.example.library.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;
    private final CategoryService categoryService;

    @GetMapping
    public String index(@PageableDefault(size = 6)Pageable pageable,
                        @RequestParam(required = false) String category,
                        @RequestParam(required = false) String ticket,
                        Model model) {
        Page<BookDto> books = bookService.findAllByCategory(category, pageable);
        List<CategoryDto> categories = categoryService.findAll();
        model.addAttribute("books", books.getContent());
        model.addAttribute("items", books);
        model.addAttribute("categories", categories);
        model.addAttribute("ticket", ticket);

        return "index";
    }
}
