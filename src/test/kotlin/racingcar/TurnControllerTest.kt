package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.controller.TurnController
import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.ConsoleView

class TurnControllerTest {

    private lateinit var carList: CarList
    private lateinit var consoleView: ConsoleView
    private lateinit var turnController: TurnController

    @BeforeEach
    fun setUp() {
        carList = CarList()
        consoleView = ConsoleView()
        turnController = TurnController(carList, consoleView)

        // 테스트용 자동차 추가
        carList.addCar(Car("car1"))
        carList.addCar(Car("car2"))
    }

    @Test
    fun `무작위 값이 4 이상이면 자동차가 이동한다`() {
        // 랜덤 값을 고정하여 테스트 (4 이상)
        val randomValue = 4
        val carIndex = 0

        // private 메서드를 호출하기 위한 Reflection
        val method = TurnController::class.java.getDeclaredMethod(
            "addMoveCount",
            Int::class.java,
            CarList::class.java,
            Int::class.java
        )
        method.isAccessible = true
        method.invoke(turnController, randomValue, carList, carIndex)

        // 자동차가 이동했는지 확인
        assertThat(carList.getCar(carIndex).getMoveCount()).isEqualTo(1)
    }

    @Test
    fun `무작위 값이 4 미만이면 자동차가 이동하지 않는다`() {
        // 랜덤 값을 고정하여 테스트 (4 미만)
        val randomValue = 3
        val carIndex = 1

        // private 메서드를 호출하기 위한 Reflection
        val method = TurnController::class.java.getDeclaredMethod(
            "addMoveCount",
            Int::class.java,
            CarList::class.java,
            Int::class.java
        )
        method.isAccessible = true
        method.invoke(turnController, randomValue, carList, carIndex)

        // 자동차가 이동하지 않았는지 확인
        assertThat(carList.getCar(carIndex).getMoveCount()).isEqualTo(0)
    }

}