package racingcar

import racingcar.domain.Car
import racingcar.infrastructure.ConsoleInput
import racingcar.infrastructure.ConsoleOutput
import racingcar.interfaces.InputAdapter
import racingcar.useCases.GameManger

fun main() {
    // TODO: 프로그램 구현
    val consoleInput = ConsoleInput()
    val consoleOutput = ConsoleOutput()

    val inputCarNames: String = consoleInput.getCarNames()
    val inputMatches: String = consoleInput.getMatches()
    consoleInput.closeInput()

    val inputAdapter = InputAdapter(inputCarNames, inputMatches)

    val car: List<String> = inputAdapter.splitCarName()
    val racingCars = inputAdapter.validateCarName(car)
    val readyRacingCars: List<Car> = inputAdapter.changeTypeOfCar(racingCars)
    val matches: Int = inputAdapter.changeTypeOfMatches()

    val gameManger = GameManger(readyRacingCars, matches, consoleOutput)
    gameManger.playGame()
    gameManger.findWinners()
}
