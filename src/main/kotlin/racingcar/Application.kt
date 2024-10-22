package racingcar

fun main() {
    val userInput = UserInput()
    val guideOutput = GuideOutput()
    val resultOutput = ResultOutput()
    RacingCarService(userInput, guideOutput, resultOutput).execute()
}
