package modelTest

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.Model.Garage

class GarageTest {
    @Test
    fun `쉼표(,)를 기준으로 각 자동차 이름을 구분할 수 있다`() {
        assertSimpleTest {
            //given
            val nameOfCars = "hyun, pobi, woni, jun"

            //when
            val carsInGarage = Garage(nameOfCars)

            //then
            assertThat(carsInGarage.carsInGarage.map { it.name }).isEqualTo(listOf("hyun", "pobi", "woni", "jun"))
        }
    }
}