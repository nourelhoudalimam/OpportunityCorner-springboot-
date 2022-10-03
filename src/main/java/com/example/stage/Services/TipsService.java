package com.example.stage.Services;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Image;
import com.example.stage.Entities.Tips;

import com.example.stage.Repositories.TipsRepository;
@Service
public class TipsService implements InterfaceTipsService{
@Autowired
TipsRepository tiprep;
	
@Autowired
ImageService imgserv;
	@Override
	public List<Tips> AddTips(List<Tips> lt) {
		// TODO Auto-generated method stub
		return (List<Tips>) tiprep.saveAll(lt);
	}

	@Override
	public String addTipWithTestExist(Tips tips) {
		// TODO Auto-generated method stub
		String ch="";
		if( (tiprep.existsByTitrecons(tips.getTitrecons())) && (tiprep.existsByContenu(tips.getContenu()))) {ch="tips exist";}
		else {Timestamp updateTip= new Timestamp(System.currentTimeMillis());
		tips.setCreateDate(updateTip);tiprep.save(tips);ch="tips created";}
	return ch;
	}

	@Override
	public Tips UpdateTip(Tips o, Long id) {
		// TODO Auto-generated method stub
		Tips tips=tiprep.findById(id).get();
		tips.setTitrecons(o.getTitrecons());
		tips.setContenu(o.getContenu());
		tiprep.save(tips);
		return tips;
	}

	@Override
	public void DeleteTip(Long id) {
		// TODO Auto-generated method stub
		tiprep.deleteById(id);
	}

	@Override
	public List<Tips> getAllTips() {
		// TODO Auto-generated method stub
		return (List<Tips>) tiprep.findAll();
	}

	@Override
	public Tips getTipById(Long id) {
		// TODO Auto-generated method stub
		return tiprep.findById(id).orElse(null);
	}

	@Override
	public List<Tips> findByTitle(String title) {
		// TODO Auto-generated method stub
		return (List<Tips>) tiprep.findByTitrecons(title);
	}

	@Override
	public Tips AddTip(Tips t) {
		// TODO Auto-generated method stub
		
		Timestamp updateTip= new Timestamp(System.currentTimeMillis());
		t.setCreateDate(updateTip);
		
		return tiprep.save(t);
		
	}

	@Override
	public Tips addImgTip(Long idTip, MultipartFile img) {
		Tips t =tiprep.findById(idTip).get();
		try {
		Image i=imgserv.uploadImage(img);
			t.setImg(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return tiprep.save(t);
	}

}
