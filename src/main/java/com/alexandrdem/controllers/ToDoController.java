package com.alexandrdem.controllers;

import com.alexandrdem.entities.ToDo;
import com.alexandrdem.repositories.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
/**
 * @author AlexanderDementev on 01.09.2021
 */

@Controller
@RequestMapping("/")
public class ToDoController {

    private ToDoRepository repository;

    @Autowired
    public ToDoController(ToDoRepository toDoRepository) {
        repository = toDoRepository;
    }

    @GetMapping
    public ModelAndView index(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping(value = "/toDos", method = { RequestMethod.GET },
            produces = {
                    MediaType.APPLICATION_JSON_UTF8_VALUE,
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.TEXT_XML_VALUE})
    public ResponseEntity<Iterable<ToDo>> getToDos(@RequestHeader HttpHeaders headers) {
        return new ResponseEntity<>(this.repository.findAll(),
                                    headers, HttpStatus.OK);
    }
}
