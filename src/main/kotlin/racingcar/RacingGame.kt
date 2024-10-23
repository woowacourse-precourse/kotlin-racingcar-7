package racingcar

import racingcar.resources.Messages
import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms

class RacingGame {
    companion object {
        private lateinit var carMap: LinkedHashMap<String, Int>
        private var tryCount: Int? = null
    }

    fun gameStart() {
        carMap = inputCarNames()
        tryCount = inputTryCount()
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

    /**
     * 경주를 한번 진행 하고 결과를 출력
     */
    fun singleRace() {
        carMap.forEach { (name, position) ->
            val randomVal = Randoms.pickNumberInRange(0, 9)
            if (randomVal >= 4) {
                carMap[name] = position + 1
            }
            val distanceIndicator = carMap[name]?.let { convertRaceIndicator(it) }
            println(Messages.PROGRESS_FORMAT.format(name, distanceIndicator))
        }
    }

    /**
     * 이동 거리를 기호로 변환하여 시각화
     * @param distance 기호로 변환할 정수값
     * @return 기호로 변환된 문자열
     */
    private fun convertRaceIndicator(distance: Int): String {
        return Messages.PROGRESS_MARK.repeat(distance)
    }
}