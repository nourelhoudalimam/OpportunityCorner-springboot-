package com.example.stage.Controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Tips;
import com.example.stage.Services.TipsService;
@RestController
@CrossOrigin(origins="http://localhost:4200")
public class TipsController {
	@Autowired
	TipsService tipserv;
	@PostMapping("/AddTip")
	@ResponseBody
	public Tips addtip(@RequestBody Tips t,@PathVariable("idtip") Long idtip) {return tipserv.AddTip(t);}
	@PostMapping("/AddMultipleTips")
	@ResponseBody
	public List<Tips> addenstips(@RequestBody List<Tips> lc) {return  tipserv.AddTips(lc);}
	@DeleteMapping("/DeleteTip/{id}")
	@ResponseBody
	public void deletetips(@PathVariable("id") Long id) {tipserv.DeleteTip(id);}
	@GetMapping("/getAllTips")
	@ResponseBody
	public List<Tips> getAllTips() {
		// TODO Auto-generated method stub
		return tipserv.getAllTips();
	}
	@PostMapping("/UpdateTips/{Id}")
	@ResponseBody
	public 	Tips UpdateTips(@RequestBody Tips o ,@PathVariable ("Id") Long id) {return tipserv.UpdateTip(o, id);}
	@PostMapping("/addTipsWithTestExistence")
	@ResponseBody
	public String addtipWithtest(@RequestBody Tips o) {return tipserv.addTipWithTestExist(o);}
	@GetMapping("/gettipById/{id}")
	@ResponseBody
	public Tips getTipbyId(@PathVariable("id") Long id) {return tipserv.getTipById(id);}
	
	@GetMapping("/findByTitleOfTip/{title}")
	@ResponseBody
	public List<Tips> findByTitle(@PathVariable("title") String title)  {return tipserv.findByTitle(title);}
	@PostMapping("/addImgTip/{idTip}")
	@ResponseBody
	public Tips addCVUser(@PathVariable("idTip") Long idTip,@RequestParam("img") MultipartFile img) {return tipserv.addImgTip(idTip, img);}
	}

