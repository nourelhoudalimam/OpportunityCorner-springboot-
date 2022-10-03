package com.example.stage.Services;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.CV;
import com.example.stage.Repositories.CvRepository;
@Service
public class CvService implements InterfaceCvService  {
@Autowired
CvRepository cvrep;
	@Override
	public CV uploadCv(MultipartFile cv) throws IOException {
		// TODO Auto-generated method stub
		String path="C:/Users/AHINFOO/OpportunityCorner/src/assets/imgs";
		System.out.println("Original Image Byte Size - " + cv.getBytes().length);
		CV img = new CV(cv.getOriginalFilename(), cv.getContentType(),
				compressBytes(cv.getBytes()));
		File f=new File(path+"/"+cv.getName());
		OutputStream fl=new FileOutputStream(f);
		fl.close();
		//return ResponseEntity.status(HttpStatus.OK);
		return cvrep.save(img);
	}
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();

		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);

		return outputStream.toByteArray();
	}	
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	}	}


