package org.example.library.service;

import lombok.RequiredArgsConstructor;
import org.example.library.util.FileUtil;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final FileUtil fileUtil;

    public ResponseEntity<?> findImageByFileName(String fileName){
        return fileUtil.getOutputFile(fileName, "files", MediaType.IMAGE_JPEG);
    }

//    public void create(ImageDto imageDto){
//        String fileName = saveUploadedFile(imageDto.getFile(), "images");
//        System.out.println(fileName);
//    }
}
