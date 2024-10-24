package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputViewImpl : InputView {

    override fun readNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input.split(",")
    }

    override fun readAttemptCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()
        return input.toInt()
    }
}