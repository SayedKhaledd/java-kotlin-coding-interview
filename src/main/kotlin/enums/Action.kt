package com.example.enums

import kotlin.random.Random

enum class Action {
    ROCK, PAPER, SCISSORS;

    companion object {
        fun getRandomAction(): Action {
            val actions = entries.toTypedArray()
            return actions[Random.nextInt(actions.size)]
        }

        fun getWinningAction(actionA: Action, actionB: Action): Action? {
            return when {
                actionA == actionB -> null
                actionA == ROCK && actionB == SCISSORS -> actionA
                actionA == PAPER && actionB == ROCK -> actionA
                actionA == SCISSORS && actionB == PAPER -> actionA
                else -> actionB
            }
        }
    }
}