package com.jualbeli.easynote

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Service
import java.util.stream.Collectors.toList
import java.util.*
import kotlin.streams.toList

@Service
class MongoDDTodoService @Autowired constructor(var repository: TodoRepository) : TodoService {


    override fun create(todo: TodoDTO): TodoDTO {
        var persisted : Todo = Todo.getBuilder()
                .title(todo.title)
                .description(todo.description)
                .build()
        print(persisted.title)
        System.out.println("Save to MongoDb")
        repository.save(persisted)
        return convertToDTO(persisted)
    }

    override fun delete(id: String): TodoDTO {
        var deleted : Todo = finTodoById(id)
        repository.delete(deleted)
        return convertToDTO(deleted)
    }

    override fun findAll(): List<TodoDTO> {
        var todoEntry = repository.findAll()
        System.out.println("RANDAJKSDHKJASHDLKJHASJKDH")
        todoEntry.forEach { System.out.println(it.title) }

        return convertToDTOs(todoEntry)
    }

    override fun findById(id: String): TodoDTO {
        var found = finTodoById(id)
        return convertToDTO(found)
    }

    override fun update(todo: TodoDTO): TodoDTO {
        var update = finTodoById(todo.id)
        update.update(todo.title,todo.description)
        return convertToDTO(update)
    }

    fun finTodoById(id : String) : Todo {
        var result : Todo = repository.findOne(id)
        return result
    }

    fun convertToDTO(model : Todo) : TodoDTO {
        var todoDTO = TodoDTO(model.id,model.description,model.title)
        return todoDTO
    }


    private fun convertToDTOs(models: List<Todo>): List<TodoDTO> {
        return models.stream()
                .map(this::convertToDTO)
                .collect(toList())
    }

}