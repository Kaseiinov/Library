package org.example.library.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.library.dto.TicketDto;
import org.example.library.dto.UserDto;
import org.example.library.service.BookService;
import org.example.library.service.CategoryService;
import org.example.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final BookService bookService;
    private final CategoryService categoryService;

    @GetMapping("/get_ticket")
    public String getTicket(Model model) {
        model.addAttribute("ticketDto", new TicketDto());
        return "users/getTicket";
    }


    @PostMapping("/get_ticket")
    public String postTicket(@Valid TicketDto ticketDto, BindingResult bindingResult, Model model) {
        if(!ticketDto.getPassword().equals(ticketDto.getConfirmPassword())) {
            bindingResult.rejectValue("confirmPassword", "error.password", "Passwords do not match");
        }

//        UserDto userDto = userService.findByPassport(ticketDto.getPassport());
//        if(userDto == null) {
//            bindingResult.rejectValue("passport", "error.passport", "There is no such passport");
//        }

        if (!bindingResult.hasErrors()) {
            String ticketNum = userService.getTicket(ticketDto);
            return  "redirect:/?ticket=" + ticketNum;
        }

        model.addAttribute("ticketDto", ticketDto);
        return "users/getTicket";
    }
}
