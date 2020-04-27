package com.sovereign.gameservice.controller

import com.sovereign.gameservice.service.GameService
import com.sovereign.gameservice.model.Game
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/gameService")
class GameController(private val gameService: GameService) {



    @GetMapping("/")
    fun getByUsername(@RequestHeader("Username") username: String):ResponseEntity<Game> {
        return gameService.getByUsername(username).map { game ->
            ResponseEntity.ok(game)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/")
    fun postGame(@RequestBody game: Game):Boolean {
        return gameService.createNewGame(game)
    }
    @PutMapping("/")
    fun updateGame(@RequestBody game: Game):Boolean {
        return gameService.updateGame(game)
    }

    @DeleteMapping("/{username}")
    fun deleteGame(@RequestHeader("Username") username: String){
        gameService.deleteGame(username)
    }

}