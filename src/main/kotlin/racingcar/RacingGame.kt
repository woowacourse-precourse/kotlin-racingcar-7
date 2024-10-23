package racingcar

import racingcar.resources.Messages
import camp.nextstep.edu.missionutils.Console.readLine

class RacingGame {
    fun start() {
        val carNames = inputCarNames()
        val tryCount = inputTryCount()
        // TODO: 게임 진행 로직 구현
    }

    fun inputCarNames(): LinkedHashMap<String, Int> {
        TODO("입력 스트링 처리 코드 구현")
    }

    fun splitCarNames(input: String): LinkedHashMap<String, Int> {
        TODO("입력 스트링 분할 코드 구현")
    }

    fun inputTryCount(): Int {
        TODO("시도할 횟수 입력 코드 구현")
    }


}