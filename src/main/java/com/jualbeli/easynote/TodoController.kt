package com.jualbeli.easynote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/todo")
class TodoController(@Autowired var service: TodoService) {

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestParam("title") titles : String, @RequestParam("description") descriptions : String) : TodoDTO{
        var todoDTO = TodoDTO("0", descriptions, titles)
        return service.create(todoDTO)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun findAll() : List<TodoDTO>{
        return service.findAll()
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleNotFound(ex : ChangeSetPersister.NotFoundException){

    }
}