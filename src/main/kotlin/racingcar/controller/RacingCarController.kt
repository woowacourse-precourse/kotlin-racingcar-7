package racingcar.controller

import racingcar.view.InputView

class RacingCarController {
    /* 순서
     * 1. 입력 값을 받는다.
     * 2, 입력 값을 검증한다.
     * 3. 입력 값을 가지고 레이싱을 진행한다.
     * 4. 각 시도 마다 레이싱을 진행하고, 매 결과를 출력
     * 5. 최종 우승자를 출력한다.
     * */

    private val inputView = InputView()

    fun runRacingGame() {
        val carList = getInput()
        val tryCount = getTryCount()

        playRacing()
        printWinners()
    }
}
