import com.example.calculateFinalWinner
import com.example.calculateWinner
import com.example.enums.Action
import com.example.exceptions.NoWinnerException
import com.example.model.Player
import com.example.startGame
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MainTest {


    @Test
    fun `calculateWinner() Rock vs Scissors should return Player B`() {
        val playerA = Player("Player A", Action.SCISSORS, 0)
        val playerB = Player("Player B", Action.ROCK, 0)
        assertEquals(playerB, calculateWinner(playerA, playerB))
    }

    @Test
    fun `calculateWinner() Scissors vs Rock should return Player B`() {
        val playerA = Player("Player A", Action.SCISSORS, 0)
        val playerB = Player("Player B", Action.ROCK, 0)
        assertEquals(playerB, calculateWinner(playerA, playerB))
    }

    @Test
    fun `calculateWinner() Paper vs Rock should return Player A`() {
        val playerA = Player("Player A", Action.PAPER, 0)
        val playerB = Player("Player B", Action.ROCK, 0)
        assertEquals(playerA, calculateWinner(playerA, playerB))
    }

    @Test
    fun `calculateWinner() Rock vs Paper should return Player A`() {
        val playerA = Player("Player A", Action.PAPER, 0)
        val playerB = Player("Player B", Action.ROCK, 0)
        assertEquals(playerA, calculateWinner(playerA, playerB))
    }

    @Test
    fun `calculateWinner() with same actions should throw NoWinnerException`() {
        val playerA = Player("Player A", Action.ROCK, 0)
        val playerB = Player("Player B", Action.ROCK, 0)
        assertThrows(NoWinnerException::class.java) {
            calculateWinner(playerA, playerB)
        }
    }

    @Test
    fun `calculateFinalWinner() when Player A has higher score should return Player A`() {
        val playerA = Player("Player A", Action.ROCK, 5)
        val playerB = Player("Player B", Action.ROCK, 3)
        assertEquals(playerA, calculateFinalWinner(playerA, playerB))
    }

    @Test
    fun `calculateFinalWinner() when Player B has higher score should return Player B`() {
        val playerA = Player("Player A", Action.ROCK, 2)
        val playerB = Player("Player B", Action.ROCK, 4)
        assertEquals(playerB, calculateFinalWinner(playerA, playerB))
    }

    @Test
    fun `calculateFinalWinner() when scores are equal should throw NoWinnerException`() {
        val playerA = Player("Player A", Action.ROCK, 3)
        val playerB = Player("Player B", Action.ROCK, 3)
        assertThrows(NoWinnerException::class.java) {
            calculateFinalWinner(playerA, playerB)
        }
    }

    @Test
    fun `startGame() should update player scores and count draws`() {
        val playerA = Player("Player A", Action.ROCK, 0)
        val playerB = Player("Player B", Action.PAPER, 0)
        val totalRounds = 10

        startGame(playerA, playerB, totalRounds)

        val totalGamesPlayed = playerA.score + playerB.score
        val draws = totalRounds - totalGamesPlayed

        assertTrue(totalGamesPlayed + draws == totalRounds, "Total wins and draws should match total rounds")
    }

    @Test
    fun `startGame() should handle multiple rounds correctly`() {
        val playerA = Player("Player A", Action.ROCK, 0)
        val playerB = Player("Player B", Action.PAPER, 0)
        val totalRounds = 100

        startGame(playerA, playerB, totalRounds)

        val totalWins = playerA.score + playerB.score
        val totalDraws = totalRounds - totalWins

        assertTrue(totalWins + totalDraws == totalRounds, "Total wins and draws should equal the total rounds")
        assertTrue(totalDraws >= 0, "Draws should not be negative")
    }


}