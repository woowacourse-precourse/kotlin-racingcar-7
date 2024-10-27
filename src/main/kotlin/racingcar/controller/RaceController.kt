package racingcar.controller

import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

class RaceController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var race: Race
    private var rounds = 0

    fun run() {
        setUp()
        showRoundResult()
        showWinnerResult()

        inputView.close()
    }

    private fun setUp() {
        val carList = getValidCarList()
        rounds = getValidRounds()
        race = Race(carList)
    }

    private fun showRoundResult() {
        repeat(rounds) {
            val roundResult = race.getRoundResult()
            outputView.printRoundResult(roundResult)
        }
    }

    private fun showWinnerResult() {
        val raceWinner = race.getRaceWinner()
        outputView.printWinner(raceWinner)
    }

    private fun getValidCarList(): List<Car> {
        val carNames: String = inputView.getCarNames()
        val tmpCarList = carNames.split(",")

        isAllValid(tmpCarList)

        return tmpCarList.map { carName -> Car(name = carName) }
    }

    private fun isAllValid(tmpCarList: List<String>) {
        tmpCarList.map { carName ->
            isValidCarNameLength(carName)
            hasBlankInCarName(carName)
        }
        hasDuplicatedCarName(tmpCarList)
    }

    private fun isValidCarNameLength(carName: String) {
        val len = carName.length
        if (1 > len || len > 5) throw IllegalArgumentException("차량 이름의 길이는 1-5자 입니다.")
    }

    private fun hasBlankInCarName(carName: String) {
        if (carName.contains(" ")) throw IllegalArgumentException("차량 이름에 공백을 제거해 주세요.")
    }

    private fun hasDuplicatedCarName(carNameList: List<String>) {
        if (carNameList.toSet().size != carNameList.size) throw IllegalArgumentException("차량 이름은 중복될 수 없습니다.")
    }

    private fun getValidRounds(): Int {
        val rounds = inputView.getRounds()
        if (rounds < 1) throw IllegalArgumentException("1 이상의 횟수를 입력해 주세요.")
        return rounds
    }
}