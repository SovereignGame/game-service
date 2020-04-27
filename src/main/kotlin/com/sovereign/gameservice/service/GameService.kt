package com.sovereign.gameservice.service

import com.sovereign.gameservice.model.Game
import com.sovereign.gameservice.repository.GameRepository
import org.joda.time.Instant
import org.springframework.stereotype.Service
import java.util.*

//TODO add MUCH MORE logic, checks and functionality
@Service
class GameService(private val gameRepository: GameRepository) {

    fun getByUsername(username: String): Optional<Game> {
        return gameRepository.findById(username)
    }

    fun createNewGame(game: Game):Boolean{
        gameRepository.save(game)
        return true
    }
    fun updateGame(game: Game):Boolean{
        val oldSaveGame = gameRepository.findById(game.username)
        if(oldSaveGame.isPresent){
            gameRepository.save(oldSaveGame.get().copy(gameState = game.gameState, boardSeed = game.boardSeed, timeStamp = Instant.now().millis))
            return true
        }
        return false
    }

    fun deleteGame(username: String){
        gameRepository.deleteById(username)

    }
}