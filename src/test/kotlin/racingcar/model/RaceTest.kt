package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RaceTest {
    private val race = Race("a,b,c", 3)
    private val result = race.carList
    private val randomValues = listOf(4, 2, 5, 3, 6, 1, 7, 8, 0)
    private var index = 0

    @Test
    fun `Car객체 생성 테스트`() {
        val expected = listOf(Car("a"), Car("b"), Car("c"))

        assertEquals(expected, result)
    }

    @Test
    fun `자동차 이동 횟수 테스트`() {
        // 랜덤 값을 강제할 수 없으므로, 고정된 랜덤값에 따라 시뮬레이션
        repeat(race.tryCount) {
            race.carList.forEach { car ->
                val randomNumber = randomValues[index]
                car.move(randomNumber > 3)
                index++
            }
        }

        assertEquals(2, race.carList[0].getMoveCount())
        assertEquals(2, race.carList[1].getMoveCount())
        assertEquals(1, race.carList[2].getMoveCount())
    }

    @Test
    fun `우승자 테스트`() {
        // 랜덤 값을 강제할 수 없으므로, 고정된 시퀀스에 따라 시뮬레이션
        repeat(race.tryCount) {
            race.carList.forEach { car ->
                val randomNumber = randomValues[index]
                car.move(randomNumber > 3)
                index++
            }
        }

        val winners = race.getWinners()
        assertEquals(listOf("a", "b"), winners) // "A"와 "C"가 가장 많이 이동했어야 함
    }
}
