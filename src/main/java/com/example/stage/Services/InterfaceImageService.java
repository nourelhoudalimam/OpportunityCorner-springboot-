package com.example.stage.Services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Image;

public interface InterfaceImageService {
	public Image uploadImage(MultipartFile img) throws IOException;
}
