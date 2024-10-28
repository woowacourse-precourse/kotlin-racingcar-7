package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.domain.RacingCar

class RacingCarTest {
    private lateinit var car: RacingCar

    @BeforeEach
    fun init() {
        car = RacingCar("name")
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3])
    fun `숫자가 4 미만인 경우 전진하지 않는지 확인`(input: Int) {
        car.moveForward(input)
        assert(car.position == 0)
    }

    @ParameterizedTest
    @ValueSource(ints = [4, 5, 6, 7, 8, 9])
    fun `숫자가 4 이상인 경우 전진하는지 확인`(input: Int) {
        car.moveForward(input)
        assert(car.position == 1)
    }
}