package racingcar

class RacingCarService(
    private val userInput: UserInput,
    private val guideOutput: GuideOutput,
    private val resultOutput: ResultOutput,
) {
    fun execute() {
        guideOutput.guideInputCarsName()
        val carsName = userInput.getCarsName()
        guideOutput.guideInputRaceCount()
        val raceCount = userInput.getRaceCount()
        guideOutput.guideExecuteResult()
        val cars = CarFactory().buildCars(input = carsName)
        val race = Race(cars)
        repeat(raceCount) {
            race.play()
            resultOutput.printRaceResult(race.cars)
        }
        resultOutput.printWinners(race.getWinnersName())
    }
}