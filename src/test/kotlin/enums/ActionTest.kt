package enums

import com.example.enums.Action
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ActionTest {

    @Test
    fun `getWinningAction() Rock vs Scissors should return Rock`() {
        assertEquals(Action.ROCK, Action.getWinningAction(Action.ROCK, Action.SCISSORS))
    }

    @Test
    fun `getWinningAction() Scissors vs Rock should return Rock`() {
        assertEquals(Action.ROCK, Action.getWinningAction(Action.SCISSORS, Action.ROCK))
    }

    @Test
    fun `getWinningAction() Paper vs Rock should return Paper`() {
        assertEquals(Action.PAPER, Action.getWinningAction(Action.PAPER, Action.ROCK))
    }

    @Test
    fun `getWinningAction() Rock vs Paper should return Paper`() {
        assertEquals(Action.PAPER, Action.getWinningAction(Action.ROCK, Action.PAPER))
    }

    @Test
    fun `getWinningAction() Scissors vs Paper should return Scissors`() {
        assertEquals(Action.SCISSORS, Action.getWinningAction(Action.SCISSORS, Action.PAPER))
    }

    @Test
    fun `getWinningAction() Paper vs Scissors should return Scissors`() {
        assertEquals(Action.SCISSORS, Action.getWinningAction(Action.PAPER, Action.SCISSORS))
    }

    @Test
    fun `getWinningAction() with same actions should return null`() {
        assertNull(Action.getWinningAction(Action.ROCK, Action.ROCK))
        assertNull(Action.getWinningAction(Action.PAPER, Action.PAPER))
        assertNull(Action.getWinningAction(Action.SCISSORS, Action.SCISSORS))
    }

    @Test
    fun `getRandomAction() should return a valid action`() {
        val action = Action.getRandomAction()
        assertTrue(action in Action.entries.toTypedArray())
    }

    @Test
    fun `getRandomAction() should return different actions on multiple calls`() {
        val actions = List(100) { Action.getRandomAction() }
        assertTrue(actions.distinct().size > 1)
    }
}
