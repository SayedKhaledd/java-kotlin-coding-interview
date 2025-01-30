package com.example

import com.example.enums.Action
import com.example.exceptions.NoWinnerException
import com.example.model.Player

fun main() {
    val playerA = Player("Player A", Action.getRandomAction(), 0)
    val playerB = Player("Player B", Action.ROCK, 0)
    startGame(playerA, playerB, 100)
    try {
        val finalWinner = calculateFinalWinner(playerA, playerB)
        println("Final winner is ${finalWinner.name}")
    } catch (e: NoWinnerException) {
        println("No final winner")
    }
}

fun startGame(playerA: Player, playerB: Player, noOfRounds: Int) {
    var draws = 0
    repeat(noOfRounds) {
        try {
            val winner = calculateWinner(playerA, playerB)
            if (winner == playerA) playerA.score++ else playerB.score++
        } catch (e: NoWinnerException) {
            draws++
        }
        playerA.currentAction = Action.getRandomAction()
    }
    println("${playerA.name} wins ${playerA.score} of $noOfRounds games")
    println("${playerB.name} wins ${playerB.score} of $noOfRounds games")
    println("Draws: $draws of $noOfRounds games")
}

fun calculateWinner(playerA: Player, playerB: Player): Player {
    if (playerA.currentAction == playerB.currentAction) throw NoWinnerException("No winner")
    val winningAction = Action.getWinningAction(playerA.currentAction, playerB.currentAction)
    return if (playerA.currentAction == winningAction) playerA else playerB
}

fun calculateFinalWinner(playerA: Player, playerB: Player): Player {
    return when {
        playerA.score > playerB.score -> playerA
        playerA.score < playerB.score -> playerB
        else -> throw NoWinnerException("No winner")
    }
}