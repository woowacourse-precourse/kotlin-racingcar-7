package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class RaceTest {
    private lateinit var race: Race

    @BeforeEach
    fun setUp() {
        val carList = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val rounds = 3
        race = Race(carList, rounds)
    }

    @Test
    fun `라운드마다 자동차를 전진시킨다`() {
        val expectedMoves = listOf(
            listOf(1, 1, 1),
            listOf(2, 2, 1),
            listOf(3, 2, 1)
        )
        val actualMoves = mutableListOf<List<Int>>()
        val callback: (List<Car>) -> Unit = { cars ->
            actualMoves.add(cars.map { it.moves })
        }
        assertRandomNumberInRangeTest(
            {
                race.play(callback)
                assertEquals(expectedMoves, actualMoves)
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // 1라운드
            MOVING_FORWARD, MOVING_FORWARD, STOP, // 2라운드
            MOVING_FORWARD, STOP, STOP // 3라운드
        )
    }

    @Test
    fun `가장 많이 전진한 자동차의 이름을 반환한다`() {
        val expected = listOf("pobi", "woni")
        assertRandomNumberInRangeTest(
            {
                race.play {}
                val actual = race.getRaceWinner()
                assertEquals(expected, actual)
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, // 1라운드
            MOVING_FORWARD, MOVING_FORWARD, STOP, // 2라운드
            MOVING_FORWARD, MOVING_FORWARD, STOP // 3라운드
        )
    }

    companion object {
        private const val MOVING_FORWARD: Int = 4
        private const val STOP: Int = 3
    }
}