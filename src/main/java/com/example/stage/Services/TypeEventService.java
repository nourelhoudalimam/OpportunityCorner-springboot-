package com.example.stage.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.stage.Entities.TypeEvent;
import com.example.stage.Repositories.TypeEventRepository;

@Service
public class TypeEventService implements InterfaceTypeEventService {
@Autowired
TypeEventRepository tipevrep;

@Override
public List<TypeEvent> AddEnsTypes(List<TypeEvent> lte) {
	// TODO Auto-generated method stub
	return (List<TypeEvent>) tipevrep.saveAll(lte);
}

@Override
public TypeEvent AddType(TypeEvent t) {
	// TODO Auto-generated method stub
	return tipevrep.save(t);
}

@Override
public String addTypeWithTestExist(TypeEvent t) {
	// TODO Auto-generated method stub
	String ch="";
	if( tipevrep.existsByType(t.getType())) {ch="this Type of events exist";}
	else {tipevrep.save(t);ch="Type events created";}
return ch;
}

@Override
public TypeEvent UpdateType(TypeEvent t, Long id) {
	// TODO Auto-generated method stub
	TypeEvent te=tipevrep.findById(id).get();
	te.setType(t.getType());
	
	tipevrep.save(te);
	return te;
}

@Override
public void DeleteType(Long id) {
	// TODO Auto-generated method stub
	tipevrep.deleteById(id);	
}

@Override
public List<TypeEvent> getAllTypes() {
	// TODO Auto-generated method stub
	return (List<TypeEvent>) tipevrep.findAll();
}

@Override
public TypeEvent getTypeById(Long id) {
	// TODO Auto-generated method stub
	return tipevrep.findById(id).orElse(null);
}

}
