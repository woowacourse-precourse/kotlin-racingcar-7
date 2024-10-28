package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.CarController
import racingcar.model.CarList

class CarControllerTest {
    private val carList = CarList()
    private val carController = CarController(carList)

    @Test
    fun `자동차 이름이 유효할 때 자동차 이름 목록에 자동차 추가`() {
        val carNames = "car1,car2,car3"

        carController.addCarList(carNames)

        assertThat(carList.getSize()).isEqualTo(3)
        assertThat(carList.getCar(0).getName()).isEqualTo("car1")
        assertThat(carList.getCar(1).getName()).isEqualTo("car2")
        assertThat(carList.getCar(2).getName()).isEqualTo("car3")
    }

}