package racingcar

class RacingCar(
    private val input: Input = Input(),
    private val output: Output = Output(),
    private val race: Race = Race()
) {

    fun execute() {
        output.messageCarNames()
        input.carNames()
        output.messageMoveCount()
        input.moveCount()


    }

}