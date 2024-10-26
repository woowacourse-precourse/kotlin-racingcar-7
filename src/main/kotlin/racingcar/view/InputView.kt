package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarNames(): String {
        println(InputMessage.CAR_NAMES.message)
        return Console.readLine()
    }

    fun getTryCount(): String {
        println(InputMessage.TRY_COUNT.message)
        return Console.readLine()
    }

    private enum class InputMessage(
        val message: String,
    ) {
        CAR_NAMES("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
        TRY_COUNT("시도할 회수는 몇 회인가요?"),
    }
}
