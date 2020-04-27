package com.sovereign.gameservice.model

import javax.persistence.*
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size


@Entity
data class Game (
        // [“username”, “gamestate”, #seed]
        @Id
        var username: String = "",

        var gameState: String = "",

        var boardSeed : Long = 0,

        var timeStamp :Long = 0
)