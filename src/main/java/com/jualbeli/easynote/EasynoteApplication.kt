package com.jualbeli.easynote

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration


@EnableAutoConfiguration
@ComponentScan
class EasynoteApplication

    fun main(args: Array<String>) {
        SpringApplication.run(EasynoteApplication::class.java, *args)
    }


