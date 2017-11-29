package com.jualbeli.easynote

import org.springframework.data.mongodb.core.mapping.Document
import javax.validation.constraints.Size

data class TodoDTO (var id : String,
                    @Size(max = Todo.MAX_LENGTH_DESCRIPTION)
                    var description : String,
                    @Size(max = Todo.MAX_LENGTH_TITLE)
                    var title : String)