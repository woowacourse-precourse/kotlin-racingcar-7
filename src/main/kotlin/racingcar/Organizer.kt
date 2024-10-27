package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Organizer {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val validator = Validator()
    private val judge = Judge()

    fun prepareRace() {
        val appliedCars = inputCarNames()
        val raceCount = inputRaceCount()
        val raceCars = appliedCars.map { Car.of(it) }

        startRace(raceCars, raceCount)
    }

    private fun inputCarNames(): List<String> {
        outputView.printNotice("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val appliedCars = inputView.inputCarNames()

        validateCarNames(appliedCars)
        return appliedCars
    }

    private fun validateCarNames(appliedCars: List<String>) {
        if (validator.isDuplicatedCarNames(appliedCars)) {
            throw IllegalArgumentException("경주에 등록할 자동차 이름은 중복될 수 없습니다.")
        }
        if (!appliedCars.all { validator.isValidCarName(it) }) {
            throw IllegalArgumentException("경주에 등록할 자동차 이름은 공백을 포함할 수 없으며, 5자 이하여야 합니다.")
        }
    }

    private fun inputRaceCount(): String {
        outputView.printNotice("시도할 횟수는 몇 회인가요?")
        val raceCount = inputView.inputRaceCount()

        validateRaceCount(raceCount)
        return raceCount
    }

    private fun validateRaceCount(raceCount: String) {
        if (!validator.isValidRaceCount(raceCount)) {
            throw IllegalArgumentException("경주 횟수는 최소 1회 이상이며, 정수만 입력 가능합니다.")
        }
    }

    private fun startRace(raceCars: List<Car>, raceCount: String) {
        var updatedRaceCars = raceCars
        outputView.printNotice("실행 결과")

        for (race in 0 until raceCount.toInt()) {
            updatedRaceCars = updateRaceProgress(updatedRaceCars)
            outputView.printNotice("")
        }

        endRace(updatedRaceCars)
    }

    private fun updateRaceProgress(raceCars: List<Car>): List<Car> {
        val updatedRaceCars: MutableList<Car> = raceCars.toMutableList()
        raceCars.forEachIndexed { index, car ->
            val randomValue = pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE)
            if (validator.isPossibleForward(randomValue)) {
                updatedRaceCars[index] = car.copy(location = car.location + FORWARD)
            }
            outputView.printNotice("${updatedRaceCars[index].name} : ${"-".repeat(updatedRaceCars[index].location)}")
        }
        return updatedRaceCars
    }

    private fun endRace(raceCars: List<Car>) {
        val winnerCarsName = judge.findWinnerName(raceCars)
        outputView.printNotice("최종 우승자 : ${winnerCarsName.joinToString(", ")}")
    }

    companion object {
        private const val MINIMUM_RANDOM_VALUE = 0
        private const val MAXIMUM_RANDOM_VALUE = 9
        private const val FORWARD = 1
    }
}