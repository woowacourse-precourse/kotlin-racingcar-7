package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Organizer {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val judge = Judge()

    fun prepareRace() {
        outputView.printNotice("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val appliedCars: List<String> = inputView.inputCarNames()

        val isDuplicatedCar = appliedCars.distinct().count() != appliedCars.count()
        if (isDuplicatedCar) throw IllegalArgumentException("경주에 등록할 자동차 이름은 중복될 수 없습니다.")
        appliedCars.map { judge.validateCarName(it) }

        outputView.printNotice("시도할 횟수는 몇 회인가요?")
        val raceCount = inputView.inputRaceCount()
        if (!judge.isValidRaceCount(raceCount)) {
            throw IllegalArgumentException("경주 횟수는 최소 1회 이상이며, 정수만 입력 가능합니다.")
        }

        val raceCars: List<Car> = appliedCars.map { Car(it, 0) }
        startRace(raceCars, raceCount)
    }

    private fun startRace(raceCars: List<Car>, raceCount: String) {
        var updatedRaceCars: List<Car> = raceCars
        outputView.printNotice("실행 결과")

        for (i in 0..<raceCount.toInt()) {
            updatedRaceCars = playOneRace(updatedRaceCars)
            outputView.printNotice("")
        }

        endRace(updatedRaceCars)
    }

    private fun playOneRace(raceCars: List<Car>): List<Car> {
        val updatedRaceCars: MutableList<Car> = raceCars.toMutableList()
        for (j in 0..<raceCars.size) {
            val randomValue = pickNumberInRange(0, 9)
            if (judge.isPossibleForward(randomValue)) {
                val car = raceCars[j]
                updatedRaceCars[j] = car.copy(forward = car.forward + 1)
            }
            outputView.printNotice("\"${updatedRaceCars[j].name} : ${"-".repeat(updatedRaceCars[j].forward)}\"")
        }
        return updatedRaceCars
    }

    private fun endRace(raceCars: List<Car>) {
        val winnerCarsName = judge.findWinnerName(raceCars)
        outputView.printNotice("최종 우승자 : ${winnerCarsName.joinToString(", ")}")
    }
}