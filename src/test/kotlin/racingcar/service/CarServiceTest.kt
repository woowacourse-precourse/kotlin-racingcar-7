package racingcar.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import racingcar.model.Car

class CarServiceTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "peter,stark,steve:3",
            "pobi,ijh:2"
        ],
        delimiter = ':'
    )
    fun `자동차 생성 개수 확인`(rawInput: String, expectedSize: Int) {
        val size = CarService.createCars(rawInput).size
        assertThat(size).isEqualTo(expectedSize)
    }

    @ParameterizedTest
    @ValueSource(ints = [2, 4])
    fun `자동차 상태 확인`(curPosition: Int) {
        val testCars = listOf(Car("ijh", curPosition))
        val status = CarService.getStatus(testCars)
        assertThat(status[0].contains("-".repeat(curPosition))).isEqualTo(true)
    }

    @Test
    fun `우승자 확인`() {
        val testCars = listOf(
            Car("ijh", 1),
            Car("steve", 3),
            Car("pobi", 5),
            Car("steve", 5)
        )
        val winners = CarService.getWinners(testCars)
        assertThat(winners.contains("pobi, steve")).isEqualTo(true)
    }
}