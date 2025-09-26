package org.example.library.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.library.dto.UserDto;
import org.example.library.exception.UserAlreadyExistsException;
import org.example.library.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/register")
    public String showRegister(Model model){
        model.addAttribute("userDto", new UserDto());

        return "/auth/register";
    }

    @PostMapping("/register")
    public String register(@Valid UserDto userDto, BindingResult bindingResult, Model model, HttpServletRequest request) throws UserAlreadyExistsException {
        if(!bindingResult.hasErrors()){
            userService.save(userDto, request);
            return "redirect:/users/get_ticket";
        }
        model.addAttribute("userDto", userDto);
        return "/auth/register";
    }

    @GetMapping("/login")
    public String showLogin (){
        return "/auth/login";
    }
}
