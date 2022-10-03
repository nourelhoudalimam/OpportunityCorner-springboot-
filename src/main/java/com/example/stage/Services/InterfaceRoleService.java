package com.example.stage.Services;

import java.util.List;

import com.example.stage.Entities.Roleuser;


public interface InterfaceRoleService {
	public List<Roleuser> AddEnsRoles(List <Roleuser> lr);
	public Roleuser AddRole(Roleuser r);
	public String addRoleWithTestExist(	Roleuser r);
	public Roleuser UpdateRole(Roleuser r,Long id);
	public void DeleteRole(Long id);
	public List<Roleuser> getAllRoles();
	public Roleuser getRoleById(Long id);
}
