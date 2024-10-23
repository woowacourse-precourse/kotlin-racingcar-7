package racingcar

import racingcar.resources.Messages
import camp.nextstep.edu.missionutils.Console.readLine

class RacingGame {
    fun start() {
        val carNames = inputCarNames()
        val tryCount = inputTryCount()
        // TODO: 게임 진행 로직 구현
    }

    /**
     * 자동차 이름들을 사용자로부터 입력받기
     * @return 자동차 이름들과 0으로 초기화된 LinkedHashMap 값
     */
    fun inputCarNames(): LinkedHashMap<String, Int> {
        println(Messages.GAME_START)
        val inputString = readLine()
        return splitCarNames(inputString)
    }

    private fun splitCarNames(input: String): LinkedHashMap<String, Int> {
        val names = input.split(",")
        val value = List(names.size) { 0 }
        return names.zip(value).toMap(LinkedHashMap())
    }

    /**
     * 자동차 경주 횟수를 사용자로 부터 입력받기
     * @return 자동차 경주 횟수를 나타내는 Int 값
     */
    fun inputTryCount(): Int {
        println(Messages.GAME_INPUT_COUNT)
        val inputCountString = readLine()
        return inputCountString!!.toInt()
    }
}