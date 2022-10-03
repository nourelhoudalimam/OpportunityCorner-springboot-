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

import com.example.stage.Entities.Event;

import com.example.stage.Entities.TypeEvent;
import com.example.stage.Services.EventService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EventController {
@Autowired
EventService evserv;
@PostMapping("/AddEvent/{idtypeev}")
@ResponseBody
public Event addevent(@RequestBody  Event e, @PathVariable("idtypeev") Long idtypeev) {return evserv.AddEvent(e, idtypeev);}
@PostMapping("/AddMultipleEvent")
@ResponseBody
public List<Event> addevents(@RequestBody List<Event> le) {return  evserv.AddEvents(le);}
@DeleteMapping("/DeleteEvent/{id}")
@ResponseBody
public void deleteevent(@PathVariable("id") Long id) {evserv.DeleteEvent(id);}
@GetMapping("/getAllEvents")
@ResponseBody
public List<Event> getAllevents() {
	// TODO Auto-generated method stub
	return evserv.getAllEvents();
}
@PostMapping("/UpdateEvent/{id}")
@ResponseBody
public 	Event Updateevent(@RequestBody Event o ,@PathVariable("id") Long id) {return evserv.UpdateEvent(o, id);}
@PostMapping("/addEventWithTestExistence/{idtype}")
@ResponseBody
public String addeventWithtest(@RequestBody Event o,@PathVariable("idtype") Long idtype) {return evserv.addEventWithTestExist(o, idtype);}
@GetMapping("/getEventById/{id}")
@ResponseBody
public Event geteventById(@PathVariable("id") Long id) {
	// TODO Auto-generated method stub
	return evserv.getEventById(id);
}

@GetMapping("/findEventByTitle/{titre}")
@ResponseBody
public List<Event> findByTitle(@PathVariable("titre") String title)  {
	// TODO Auto-generated method stub
	return  evserv.findByTitle(title);
}
@GetMapping("/findEventByLieu/{lieu}")
@ResponseBody
public List<Event> findByLieu(@PathVariable("lieu") String lieu)  {
	// TODO Auto-generated method stub
	return  evserv.findByLieu(lieu);
}
@GetMapping("/findEventByOrganisator/{orga}")
@ResponseBody
public List<Event> findByOrga(@PathVariable("orga") String orga)  {
	// TODO Auto-generated method stub
	return  evserv.findByOrga(orga);
}
@GetMapping("/getEventsById/{id}")
@ResponseBody
public List<Event> ListEventsByIdType(@PathVariable("id") Long idtypeev) {
	// TODO Auto-generated method stub
	return evserv.ListEventsByIdType(idtypeev);
}

@GetMapping("/getTypeByIdEvent/{idEv}")
@ResponseBody
public TypeEvent getTypeByIdEvent(@PathVariable("idEv") Long idEv) {
	// TODO Auto-generated method stub
	return evserv.getTypeByIdEvent(idEv);
}
@PostMapping("/addImgEvent/{idEvent}")
@ResponseBody
public Event addImgEvent(@PathVariable("idEvent") Long idEvent,@RequestParam("img") MultipartFile img) {return evserv.addImgEvent(idEvent, img);}
}





