package racingcar.model

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import racingcar.ApplicationTest

class CarTest {

    @Test
    fun `go 호출 시 randomGenerator가 true를 반환하면 status가 증가한다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.go()
                car.go()
                car.go()
                car.go()
                assertEquals(4, car.getStatus())
            },
            4,4,5,6
        )
    }

    @Test
    fun `go 호출 시 randomGenerator가 false를 반환하면 status가 증가하지 않는다`() {
        camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
            {
                val car = Car("test")
                car.go()
                assertEquals(0, car.getStatus())
            },
            3
        )
    }
}