package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.dto.BookDto;
import org.example.library.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class MainController {
    private final BookService bookService;


    @GetMapping
    public String index(Model model) {
        Page<BookDto> books = bookService.findAll();
        model.addAttribute("books", books);

        return "index";
    }
}
