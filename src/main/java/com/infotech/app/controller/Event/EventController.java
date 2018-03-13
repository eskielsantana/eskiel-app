package com.infotech.app.controller.Event;

import java.util.List;

import com.infotech.app.service.event.EventService;
import com.infotech.app.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("user")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("event/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable("id") Integer id) {
        Event event = eventService.getEventById(id);
        return new ResponseEntity<Event>(event, HttpStatus.OK);
    }

    @GetMapping("events")
    public ResponseEntity<List<Event>> getEventsList() {
        List<Event> list = eventService.getEventsList();
        return new ResponseEntity<List<Event>>(list, HttpStatus.OK);
    }

    @PostMapping("event")
    public ResponseEntity<Void> addArticle(@RequestBody Event event, UriComponentsBuilder builder) {

//        if (!eventService.checkIfExists(event.getId())) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }
        Event resultEvent = eventService.createEvent(event);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/event/{id}").buildAndExpand(resultEvent.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
//
//    @PutMapping("article")
//    public ResponseEntity<Event> updateArticle(@RequestBody Event event) {
//        articleService.updateArticle(event);
//        return new ResponseEntity<Event>(event, HttpStatus.OK);
//    }
//
//    @DeleteMapping("article/{id}")
//    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
//        articleService.deleteArticle(id);
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }
}