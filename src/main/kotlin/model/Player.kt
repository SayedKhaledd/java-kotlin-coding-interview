package com.example.model

import com.example.enums.Action

data class Player(
    val name: String,
    var currentAction: Action,
    var score: Int
) {

}