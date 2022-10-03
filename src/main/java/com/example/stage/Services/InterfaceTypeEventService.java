package com.example.stage.Services;

import java.util.List;

import com.example.stage.Entities.TypeEvent;



public interface InterfaceTypeEventService {
	public List<TypeEvent> AddEnsTypes(List <TypeEvent> lte);
	public TypeEvent AddType(TypeEvent t);
	public String addTypeWithTestExist(	TypeEvent t);
	public TypeEvent UpdateType(TypeEvent t,Long id);
	public void DeleteType(Long id);
	public List<TypeEvent> getAllTypes();
	public TypeEvent getTypeById(Long id);
}
