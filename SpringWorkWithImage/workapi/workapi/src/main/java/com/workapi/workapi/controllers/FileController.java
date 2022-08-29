package com.workapi.workapi.controllers;

import com.workapi.workapi.interfaces.IFileUploadService;
import com.workapi.workapi.interfaces.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
//@Route
@RequestMapping("/file")
public class FileController {
    @Autowired
    private IFileUploadService fileUploadService;

    @Autowired
    private IImageService imageService;
    @PostMapping("/uploadImage")
    public String uploadImage(@RequestParam("image") MultipartFile imageFile) {
        if(imageFile.isEmpty()) {
            //redirectAttributes.addFlashAttribute("errorMessage", "Please choose file to upload.");
            //return new HttpClientErrorException.BadRequest("Please choose file to upload.");
            return "Not Ok";
        }

        File file = fileUploadService.upload(imageFile);
        if(file == null) {
            //redirectAttributes.addFlashAttribute("errorMessage", "Upload failed.");
            //return "redirect:/";
            return "Upload failed";

        }
        boolean resizeResult =  imageService.resizeImage(file);
        if(!resizeResult) {
            //redirectAttributes.addFlashAttribute("errorMessage", "Resize failed.");
            //return "redirect:/";
            return "resizeFailed";
        }

        //redirectAttributes.addFlashAttribute("successMessage", "File upload successfully.");
        //return "redirect:/";
        return "Ok";
    }
}
