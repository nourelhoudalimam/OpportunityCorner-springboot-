package com.example.stage.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Tips;


public interface InterfaceTipsService {
	public Tips AddTip(Tips t);
	public List<Tips> AddTips(List <Tips> lt);

	public String addTipWithTestExist(	Tips tips);
	public Tips UpdateTip(Tips o,Long id);
	public void DeleteTip(Long id);
	public List<Tips> getAllTips();
	public Tips getTipById(Long id);
	public List<Tips> findByTitle(String title);
	public Tips addImgTip(Long idTip,MultipartFile img); 
}
