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
        val raceCars = appliedCars.map { Car.from(it) }

        startRace(raceCars, raceCount)
    }

    private fun inputCarNames(): List<String> {
        outputView.printCarNamesRequest()
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
        outputView.printRaceCountRequest()
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
        outputView.printResultHeader()

        for (race in 0 until raceCount.toInt()) {
            updatedRaceCars = updateRaceProgress(updatedRaceCars)
            outputView.printLineBreak()
        }

        endRace(updatedRaceCars)
    }

    private fun updateRaceProgress(raceCars: List<Car>): List<Car> {
        val updatedRaceCars: MutableList<Car> = raceCars.toMutableList()
        raceCars.forEach { car ->
            val randomValue = pickNumberInRange(MINIMUM_RANDOM_VALUE, MAXIMUM_RANDOM_VALUE)
            if (validator.isPossibleForward(randomValue)) {
                car.forward()
            }
            outputView.printRaceProgress(car)
        }
        return updatedRaceCars
    }

    private fun endRace(raceCars: List<Car>) {
        val winnerCarsName = judge.findWinnerName(raceCars)
        outputView.printWinners(winnerCarsName)
    }

    companion object {
        private const val MINIMUM_RANDOM_VALUE = 0
        private const val MAXIMUM_RANDOM_VALUE = 9
    }
}