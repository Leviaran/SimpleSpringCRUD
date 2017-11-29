package com.jualbeli.easynote

interface TodoService {
    fun create(todo : TodoDTO) : TodoDTO
    fun delete(id : String) : TodoDTO
    fun findAll() : List<TodoDTO>
    fun findById(id : String) :TodoDTO
    fun update(todo : TodoDTO) : TodoDTO
}