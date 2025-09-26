package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.service.BookService;
import org.example.library.service.CategoryService;
import org.example.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final BookService bookService;
    private final CategoryService categoryService;

}
