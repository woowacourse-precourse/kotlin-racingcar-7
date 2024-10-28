package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ApplicationKtTest {
    @Test
    fun `createPlayers는 플레이어 목록을 반환해야 한다`() {
        val players = createPlayers("car1, car2, car3")
        assertEquals(3, players.size)
        assertEquals("car1", players[0].name)
    }

    @Test
    fun `validateCarNames는 잘못된 이름에 대해 예외를 던져야 한다`() {
        assertThrows<IllegalArgumentException> {
            validateCarNames(listOf("", "car2", "longname"))
        }
    }

    @Test
    fun `validateCarNames는 유효한 이름에 대해 예외를 던지지 않아야 한다`() {
        assertDoesNotThrow {
            validateCarNames(listOf("car1", "car2", "car3"))
        }
    }

    @Test
    fun `findWinners는 최대 진행도를 가진 플레이어를 반환해야 한다`() {
        val players = listOf(Player("car1", 3), Player("car2", 3), Player("car3", 2))
        val winners = findWinners(players)
        assertEquals(2, winners.size)
        assertTrue(winners.any { it.name == "car1" })
        assertTrue(winners.any { it.name == "car2" })
    }

    @Test
    fun `updateProgress는 4이상일때 progress가 1 증가해야한다`() {
        val player = Player("test")
        updateProgress(player, 5)
        assertEquals(1, player.progress)
    }

    @Test
    fun `updateProgress는 4 미만일때 progress가 증가하면 안된다`() {
        val player = Player("test")
        updateProgress(player, 3)
        assertEquals(0, player.progress)
    }
}