package racingcar

class RaceManager(
    private val race: Race,
    private val inputView: InputView,
    private val outputView: OutputViewInterface,
    private val inputValidator: InputValidator
) {

    fun runRace() {
        initializeRace() // 경주 초기화
        startRace() // 경주 시작
        printFinalResult() // 최종 결과 출력
    }

    fun initializeRace() {
        val carNames = inputView.getCarNames()
        inputValidator.validateCarNames(carNames)

        val tryCount = inputView.getTryCount()
        inputValidator.validateTryCount(tryCount)

        val cars = carNames.map { Car(it) }
        race.initializeRace(cars, tryCount)
    }

    fun startRace() {
        race.startRace()
    }

    fun printFinalResult() {
        val raceWinners = race.getRaceWinners()
        outputView.printRaceWinners(raceWinners)
    }
}