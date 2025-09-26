package org.example.library.controller;

import lombok.RequiredArgsConstructor;
import org.example.library.service.ImageService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("images")
public class ImageController {
    private final ImageService imageService;

    @GetMapping("byName/{fileName}")
    public ResponseEntity<?> getImageByFileName(@PathVariable String fileName){
        return imageService.findImageByFileName(fileName);
    }
}
