package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.controller.RaceController
import racingcar.controller.TurnController
import racingcar.model.Car
import racingcar.model.CarList
import racingcar.view.ConsoleView

class RaceControllerTest {

    private lateinit var consoleView: ConsoleView
    private lateinit var carList: CarList
    private lateinit var raceController: RaceController
    private lateinit var turnController: TurnController

    @BeforeEach
    fun setUp() {
        consoleView = ConsoleView()
        carList = CarList()
        raceController = RaceController(carList, consoleView)
        turnController = TurnController(carList, consoleView)
    }


    @Test
    fun `경주 횟수를 설정하는 테스트`() {
        raceController.setRaceCount(5)
        assertThat(raceController.getRaceCount()).isEqualTo(5)
    }

    @Test
    fun `우승자가 1명일 때 테스트`() {
        carList.addCar(Car("car1"))
        carList.addCar(Car("car2"))
        carList.addCar(Car("car3"))
        turnController.addMoveCount(4, carList, 0)

        val winners = raceController.pickWinner()

        assertThat(winners).hasSize(1) // car1만 우승이므로 1명
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("car1")
    }

    @Test
    fun `우승자가 2명 이상일 때 테스트`() {
        carList.addCar(Car("car1"))
        carList.addCar(Car("car2"))
        carList.addCar(Car("car3"))
        turnController.addMoveCount(4, carList, 1)
        turnController.addMoveCount(4, carList, 2)

        val winners = raceController.pickWinner()

        assertThat(winners).hasSize(2) // car2와 car3이 우승해야 하므로 2명
        assertThat(winners).extracting("name").containsExactlyInAnyOrder("car2", "car3")
    }

}