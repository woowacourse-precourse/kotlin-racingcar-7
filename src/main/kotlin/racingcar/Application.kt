package racingcar

import racingcar.ui.GuideOutput
import racingcar.ui.RacingCarController
import racingcar.ui.ResultOutput
import racingcar.ui.UserInput

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    RacingCarController(userInput, guideOutput, resultOutput).execute()
}
