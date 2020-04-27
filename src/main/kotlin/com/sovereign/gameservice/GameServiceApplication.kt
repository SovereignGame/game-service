package com.sovereign.gameservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GameServiceApplication

fun main(args: Array<String>) {
	runApplication<GameServiceApplication>(*args)
}
