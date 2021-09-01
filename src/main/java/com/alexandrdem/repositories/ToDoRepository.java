package com.alexandrdem.repositories;

import com.alexandrdem.entities.ToDo;
import org.springframework.data.repository.CrudRepository;
/**
 * @author AlexanderDementev on 01.09.2021
 */
public interface ToDoRepository extends CrudRepository<ToDo, String> {
}
