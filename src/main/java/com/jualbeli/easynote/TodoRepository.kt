package com.jualbeli.easynote

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.repository.Repository
import java.util.*
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "todo", path = "todo")
interface TodoRepository : MongoRepository<Todo,String>{
}