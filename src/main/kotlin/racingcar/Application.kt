package racingcar

fun main() {
    val randomNumberGenerator = RandomNumberGenerator()
    val inputView = InputView()
    val outputView = OutputView()
    val inputValidator = InputValidator()
    val race = Race(numberGenerator = randomNumberGenerator, outputView = outputView)
    val raceManager =
        RaceManager(race = race, inputView = inputView, outputView = outputView, inputValidator = inputValidator)
    raceManager.runRace()
}
