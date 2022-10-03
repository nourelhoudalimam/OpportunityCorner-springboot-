package com.example.stage.Services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.stage.Entities.Event;
import com.example.stage.Entities.TypeEvent;


public interface InterfaceEventService {
	public Event AddEvent(Event e,Long idtypeev);
	public List<Event> AddEvents(List <Event> le);

	public String addEventWithTestExist(	Event  event,Long idev);
	public Event UpdateEvent( Event e,Long id);
	public void DeleteEvent(Long id);
	public List<Event> getAllEvents();
	public Event getEventById(Long id);
	public List<Event> findByTitle(String title);

	public List<Event> findByLieu(String lieu);

	public List<Event> findByOrga(String orga);
	public List<Event> ListEventsByIdType(Long idtypeev);
	public TypeEvent getTypeByIdEvent(Long idEv);
	public Event addImgEvent(Long idEvent,MultipartFile img); 
}