package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.Car
import racingcar.model.Race
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.view.OutputView.displayRaceResults


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
        val names = namesInput.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        // 입력받은 이름들을 쉼표로 분리하고 공백 제거 후, 빈 문자열이 아닌 것들로 리스트 생성

        require(names.isNotEmpty()) { "자동차 이름이 비어있습니다." }

        require(names.all { it.length <= 5 }) { "자동차 이름은 5자 이하이어야 합니다." }

        require(names.size >= 2) { "자동차는 최소 두 대 이상이어야 합니다." }

        val uniqueNames = names.toSet()
        require(uniqueNames.size == names.size) {"자동차 이름은 중복될 수 없습니다."}

        val namePattern = Regex("^[a-zA-Z0-9]+$")
        require(names.all { it.matches(namePattern) }) { "자동차 이름에는 알파벳과 숫자만 사용할 수 있습니다." }

        return names
    }

    private fun getAttemptCount(): Int {
        InputView.attemptCount()
        val attemptInput = Console.readLine()
        val attempt =
            attemptInput.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수는 정수여야 합니다.")
        // 입력받은 시도 횟수를 정수로 변환, 변환되지 않을 경우 예외 발생
        require(attempt >= 1) { "시도 횟수는 1 이상이어야 합니다." }
        return attempt

    }

    private fun createCars(names: List<String>): List<Car> {
        // 이름 리스트를 기반으로 Car 객체 리스트 생성
        return names.map { Car(it) }
    }

    private fun startRace(cars: List<Car>, attempts: Int): List<List<Car>> {
        // Race 객체를 생성하고 레이스를 시작하여 결과를 반환
        val race = Race(cars, attempts)
        return race.startRace()
    }

    private fun displayRaceResults(raceResults: List<List<Car>>) {
        OutputView.displayRaceResults(raceResults)
    }

    private fun displayWinners(cars: List<Car>) {
        val race = Race(cars, 0)
        val winners = race.getWinners()
        OutputView.displayWinners(winners)
    }
}
