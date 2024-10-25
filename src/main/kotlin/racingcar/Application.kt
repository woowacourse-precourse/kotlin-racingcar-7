package racingcar

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    RacingCarController(userInput, guideOutput, resultOutput).execute()
}
