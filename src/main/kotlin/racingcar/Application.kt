package racingcar

fun main() {
    val inputHandler = InputHandler()
    val inputValidator = InputValidator()
    val outputHandler = OutputHandler()

    // 값 입력, 입력 값 검증
    val namesInput = inputHandler.getCarsNameInput()
    val countInput = inputHandler.getRacingCountInput()
    inputValidator.validateInput(namesInput, countInput)

    val racingCarGame = RacingCarGame(namesInput, countInput)

    // Racing 게임
    outputHandler.printRacingGame()
    racingCarGame.start()
    outputHandler.printRacingWinner(racingCarGame.findRaceWinners())
}
