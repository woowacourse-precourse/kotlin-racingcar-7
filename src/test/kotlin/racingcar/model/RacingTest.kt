package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import racingcar.main


class RacingTest : NsTest(){

    @Test
    fun `readyToRace는 입력된 이름 리스트로 Car 객체 리스트를 생성한다`() {
        val carNames = listOf("Car1", "Car2", "Car3")
        val racing = Racing()

        val cars = racing.readyToRace(carNames)

        assertEquals(3, cars.size)
        assertEquals("Car1", cars[0].name)
        assertEquals("Car2", cars[1].name)
        assertEquals("Car3", cars[2].name)
    }

    @Test
    fun `eachRace는 각 차의 go 메서드를 호출하고 결과를 출력한다`() {
        assertRandomNumberInRangeTest(
            {
                val cars = listOf(
                    Car("Car1"),
                    Car("Car2")
                )
                Racing().race(1,cars)

                Assertions.assertThat(output()).contains("Car1 : -", "Car2 : -")
            },
            4, 4
        )
    }

    override fun runMain() {
        main()
    }

}