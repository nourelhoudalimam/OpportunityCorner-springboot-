package com.example.stage.Services;




import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Event;
import com.example.stage.Entities.Image;

import com.example.stage.Entities.TypeEvent;
import com.example.stage.Repositories.EventRepository;
import com.example.stage.Repositories.TypeEventRepository;
@Service
public class EventService implements InterfaceEventService {
@Autowired
EventRepository evrep;
@Autowired
TypeEventRepository tevrep;
@Autowired
ImageService imgsrv;
	@Override
	public Event AddEvent(Event e,Long idtypeev) {
		// TODO Auto-generated method stub
		TypeEvent te=tevrep.findById(idtypeev).get();
		e.setTypeev(te);
		Timestamp updateEvent= new Timestamp(System.currentTimeMillis());
		e.setCreateDate(updateEvent);
		
		return evrep.save(e);
		
		
	}

	@Override
	public List<Event> AddEvents(List<Event> le) {
		// TODO Auto-generated method stub
		return (List<Event>) evrep.saveAll(le);
	}

	@Override
	public String addEventWithTestExist(Event event,Long idtypeev) {
		// TODO Auto-generated method stub
		String ch="";
		if( (evrep.existsByDevent(event.getDevent())) && (evrep.existsByLieu(event.getLieu()))) {ch="event exist";}
		else {TypeEvent te=tevrep.findById(idtypeev).get();
		event.setTypeev(te);
		Timestamp updateEvent= new Timestamp(System.currentTimeMillis());
		event.setCreateDate(updateEvent);evrep.save(event);ch="event created";}
	return ch;
	}

	@Override
	public Event UpdateEvent(Event e, Long id) {
		// TODO Auto-generated method stub
		Event ev=evrep.findById(id).get();
		ev.setDevent(e.getDevent());
		ev.setLieu(e.getLieu());
		evrep.save(ev);
		return ev;
	}

	@Override
	public void DeleteEvent(Long id) {
		// TODO Auto-generated method stub
		evrep.deleteById(id);
	}

	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return (List<Event>) evrep.findAll();
	}

	

	public Event getEventById(Long id) {
		// TODO Auto-generated method stub
		return evrep.findById(id).orElse(null);
	}

	@Override
	public List<Event> findByTitle(String title) {
		// TODO Auto-generated method stub
		return  (List<Event>) evrep.findByTitre(title);
	}
	public List<Event> ListEventsByIdType(Long idtypeev)
	{
		TypeEvent te=tevrep.findById(idtypeev).get();
		return evrep.findByTypeev(te);
	}

	@Override
	public TypeEvent getTypeByIdEvent(Long idEv) {
		// TODO Auto-generated method stub
		Event e=evrep.findById(idEv).get();
		return e.getTypeev();
	}

	
	@Override
	public List<Event> findByLieu(String lieu) {
		// TODO Auto-generated method stub
		return (List<Event>) evrep.findByLieu(lieu);
	}

	@Override
	public List<Event> findByOrga(String orga) {
		// TODO Auto-generated method stub
		return (List<Event>) evrep.findByOrga(orga);
	}

	@Override
	public Event addImgEvent(Long idEvent, MultipartFile img) {
		// TODO Auto-generated method stub
		Event ev =evrep.findById(idEvent).get();
		try {
		Image i=imgsrv.uploadImage(img);
			ev.setImg(i);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return evrep.save(ev);
	}

	
	
}

