package racingcar

class RacingCar(
    private val input: Input = Input(),
    private val output: Output = Output(),
    private val race: Race = Race()
) {

    fun execute() {
        output.messageCarNames()
        val carNames = input.carNames()

        output.messageMoveCount()
        val moveCount = input.moveCount()

        race.start(carNames, moveCount)
    }

}