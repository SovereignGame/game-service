package com.sovereign.gameservice.repository

import com.sovereign.gameservice.model.Game
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GameRepository: JpaRepository<Game, String>{

    fun findAllByUsername(username:String): Optional<List<Game>>
}