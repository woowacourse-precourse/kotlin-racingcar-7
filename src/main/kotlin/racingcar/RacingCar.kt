package racingcar

class RacingCar(
    private val input: Input = Input(),
    private val output: Output = Output(),
    private val exeption: Exception = Exception(),
    private val race: Race = Race()
) {

    fun execute() {
        output.messageCarNames()
        val carNames = input.carNames()
        exeption.carNameException(carNames)

        output.messageMoveCount()
        val moveCount = input.moveCount()
        exeption.moveCountException(moveCount)

        race.start(carNames, moveCount.toInt())
    }

}