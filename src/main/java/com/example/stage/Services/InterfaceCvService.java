package com.example.stage.Services;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.CV;

public interface InterfaceCvService {
	public CV uploadCv(MultipartFile cv) throws IOException;
}
