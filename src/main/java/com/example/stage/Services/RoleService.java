package com.example.stage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.stage.Entities.Roleuser;
import com.example.stage.Repositories.RoleRepository;
@Service
public class RoleService implements InterfaceRoleService {
@Autowired 
RoleRepository rrep;
	public Roleuser AddRole(Roleuser r) {
		// TODO Auto-generated method stub
		return rrep.save(r);
	}
	@Override
	public String addRoleWithTestExist(Roleuser r) {
		// TODO Auto-generated method stub
		String ch="";
		if (rrep.existsByRole(r.getRole())) {ch="this role exist";}
		else {rrep.save(r);ch="role created";}
	return ch;
	}
	@Override
	public Roleuser UpdateRole(Roleuser r, Long id) {
		// TODO Auto-generated method stub
		Roleuser ro=rrep.findById(id).get();
		ro.setRole(r.getRole());
		
		rrep.save(ro);
		return ro;
	}
	@Override
	public void DeleteRole(Long id) {
		// TODO Auto-generated method stub
		rrep.deleteById(id);
	}
	@Override
	public List<Roleuser> getAllRoles() {
		// TODO Auto-generated method stub
		return (List<Roleuser>) rrep.findAll();
	}
	@Override
	public Roleuser getRoleById(Long id) {
		// TODO Auto-generated method stub
		return rrep.findById(id).orElse(null);
	}
	@Override
	public List<Roleuser> AddEnsRoles(List<Roleuser> lr) {
		// TODO Auto-generated method stub
		return (List<Roleuser>) rrep.saveAll(lr);
	}

}
