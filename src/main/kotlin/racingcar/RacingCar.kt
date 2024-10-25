package racingcar

import kotlin.math.E

class RacingCar(
    private val input: Input = Input(),
    private val output: Output = Output(),
    private val exeption: Exeption = Exeption(),
    private val race: Race = Race()
) {

    fun execute() {
        output.messageCarNames()
        val carNames = input.carNames()
        exeption.carNameExeption(carNames)

        output.messageMoveCount()
        val moveCount = input.moveCount()
        exeption.moveCountExeption(moveCount)

        race.start(carNames, moveCount.toInt())
    }

}