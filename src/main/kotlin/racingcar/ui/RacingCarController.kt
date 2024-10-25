package racingcar.ui

import racingcar.domain.entity.Race
import racingcar.domain.factory.CarFactory

class RacingCarController(
    private val userInput: UserInput,
    private val guideOutput: GuideOutput,
    private val resultOutput: ResultOutput,
) {
    fun execute() {
        val carsName = getCarsName()
        val raceCount = getRaceCount()
        val cars = CarFactory().buildCars(input = carsName)
        val race = Race(cars)
        playRace(raceCount, race)
        resultOutput.printWinners(race.getWinnersName())
    }

    private fun getCarsName(): String {
        guideOutput.guideInputCarsName()
        return userInput.getCarsName()
    }

    private fun getRaceCount(): Int {
        guideOutput.guideInputRaceCount()
        return userInput.getRaceCount()
    }

    private fun playRace(raceCount: Int, race: Race) {
        guideOutput.guideExecuteResult()
        repeat(raceCount) {
            race.play()
            resultOutput.printRaceResult(race.cars)
        }
    }
}