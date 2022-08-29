package com.workapi.workapi.interfaces;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

public interface IFileUploadService {
    File upload(MultipartFile imageFile);
}
