package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView

object RacingController {
    fun run() {
        val carNames = getCarNames()
        val attemptCount = getAttemptCount()
        val cars = createCars(carNames)
        val raceResults = startRace(cars, attemptCount)
        displayRaceResults(raceResults)
        displayWinners(cars)
    }

    private fun getCarNames(): List<String> {
        InputView.carNames()
        val namesInput = Console.readLine()
        val names = parseCarNames(namesInput)
        validateCarNames(names)
        return names
    }

    private fun parseCarNames(input: String): List<String> {
        return input.split(",").map { it.trim() }.filter { it.isNotEmpty() }
    }

    private fun validateCarNames(names: List<String>) {
        require(names.isNotEmpty()) { "자동차 이름이 비어있습니다." }
        require(names.all { it.length <= 5 }) { "자동차 이름은 5자 이하이어야 합니다." }
        require(names.size >= 2) { "자동차는 최소 두 대 이상이어야 합니다." }
        val uniqueNames = names.toSet()
        require(uniqueNames.size == names.size) { "자동차 이름은 중복될 수 없습니다." }
        val namePattern = Regex("^[a-zA-Z0-9]+$")
        require(names.all { it.matches(namePattern) }) { "자동차 이름에는 알파벳과 숫자만 사용할 수 있습니다." }
    }

    private fun getAttemptCount(): Int {
        InputView.attemptCount()
        val attemptInput = Console.readLine()
        val attempt = parseAttemptCount(attemptInput)
        validateAttemptCount(attempt)
        return attempt
    }

    private fun parseAttemptCount(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 정수여야 합니다.")
    }

    private fun validateAttemptCount(attempt: Int) {
        require(attempt >= 1) { "시도 횟수는 1 이상이어야 합니다." }
    }

    private fun createCars(names: List<String>): List<Car> {
        return names.map { Car(it) }
    }

    private fun startRace(cars: List<Car>, attempts: Int): List<List<Car>> {
        val race = Race(cars, attempts)
        return race.startRace()
    }

    private fun displayRaceResults(raceResults: List<List<Car>>) {
        OutputView.displayRaceResults(raceResults)
    }

    private fun displayWinners(cars: List<Car>) {
        val winners = cars.filter { it.position == cars.maxOf { car -> car.position } }
        OutputView.displayWinners(winners)
    }
}
