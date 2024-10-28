package racingcar.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RoundTest {
    private lateinit var cars: List<Car>

    @BeforeEach
    fun setup() {
        cars = listOf(Car("Car1"), Car("Car2"))
    }

    @Test
    @DisplayName("난수가 4 이상일 때 자동차는 전진해야 한다.")
    fun randomNumber_moveForward_test() {
        val moveGenerator = object : NumberGenerator {
            override fun generate(): Int = 4
        }

        val round = Round(moveGenerator)
        round.play(cars)

        cars.forEach { car ->
            assertEquals(1, car.position)
        }
    }

    @Test
    @DisplayName("난수가 4 미만일 때 자동차는 전진하지 않아야 한다.")
    fun randomNumber_neverMove_test() {
        val neverMoveGenerator = object : NumberGenerator {
            override fun generate(): Int = 3
        }

        val round = Round(neverMoveGenerator)
        round.play(cars)

        cars.forEach { car ->
            assertEquals(0, car.position)
        }
    }
}
