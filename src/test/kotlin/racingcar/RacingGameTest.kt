package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.ApplicationTest.Companion.MOVING_FORWARD
import racingcar.ApplicationTest.Companion.STOP

class RacingGameTest : NsTest() {

    @DisplayName("레이싱 게임 생성 성공")
    @Test
    fun successCreateGame() {
        val input = listOf("우테코", "사랑")
        val game = RacingGame(input)

        for (i in input.indices) {
            assertEquals(input[i], game.cars[i].name)
        }
    }

    @DisplayName("레이싱 게임 생성 실패 - 너무 길은 이름")
    @Test
    fun failCreateGame() {
        val input = listOf("감자는", "우테코를 사랑", "해요")

        assertThrows<IllegalArgumentException> {
            RacingGame(input)
        }
    }

    @DisplayName("레이싱 게임 1라운드 성공")
    @Test
    fun successGameOneRound() {
        val game = RacingGame(listOf("우테코", "사랑"))

        assertRandomNumberInRangeTest(
            {
                game.startOneRound()
                assertEquals(game.cars[0].drivingDistance, 1)
                assertEquals(game.cars[1].drivingDistance, 0)
            },
            MOVING_FORWARD, STOP
        )
    }

    @DisplayName("레이싱 게임 3라운드 성공")
    @Test
    fun successGameThreeRound() {
        val game = RacingGame(listOf("우테코", "사랑"))

        assertRandomNumberInRangeTest(
            {
                game.startOneRound()
                game.startOneRound()
                game.startOneRound()
                assertEquals(game.cars[0].drivingDistance, 2)
                assertEquals(game.cars[1].drivingDistance, 1)
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        )
    }

    override fun runMain() {
    }
}