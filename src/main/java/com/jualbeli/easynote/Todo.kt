package com.jualbeli.easynote

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

class Todo (var builder : Builder) {
    @Id
    lateinit var id : String

    lateinit var description : String
    lateinit var title : String


    companion object {
        const val MAX_LENGTH_DESCRIPTION = 500
        const val MAX_LENGTH_TITLE = 100

        fun getBuilder() : Builder {
            return Builder()
        }

        class Builder {
            private lateinit var description : String
            private lateinit var title : String
            private lateinit var builder : Builder

            fun description(description: String): Builder {
                this.description = description
                return this
            }

            fun title(title: String): Builder {
                System.out.println("Title" + title)
                this.title = title
                return this
            }

            fun build(): Todo{
                System.out.println("INI")
                var build = Todo(this)
                build.title = this.title
                build.description = this.description
                build.checkTitleAndDescription(build.title,build.description)
                return build
            }
        }
    }

    fun update(title : String, description : String){
        checkTitleAndDescription(title,description)
        this.title = title
        this.description = description
    }

    fun checkTitleAndDescription(title: String, description: String?){
        description?.let {
            when {
                description.length <= MAX_LENGTH_DESCRIPTION -> MAX_LENGTH_DESCRIPTION
                else -> print("Description cannot be longer than 500 character")
            }
        }
    }



}