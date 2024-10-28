package racingcar.utils

import camp.nextstep.edu.missionutils.Console

object InputUtils {

    private const val INPUT_PLAY_CAR_STR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    /**
     * 자동차 경주 게임에 참가하는 자동차 이름을 입력받는 함수
     * @return 자동차 이름 리스트(List)
     */
    fun getCarList(): List<String> {
        println(INPUT_PLAY_CAR_STR)
        val input = Console.readLine()
        Console.close()
        return input.toCarList()
    }

    /**
     * 자동차 이름을 쉼표(,)기준으로 분리하여 리스트를 생성한다.
     * @return 분리한 이름 리스트(List)
     */
    private fun String.toCarList(): List<String> {
        return split(",")
    }

    private const val INPUT_GAME_ROUND_STR = "시도할 횟수는 몇 회인가요?"
    /**
     * 자동차 경주 게임의 총 라운드를 입력받는 함수
     * @return 게임 총 라운드수(Int)
     */
    fun getTotalRound(): Int {
        println(INPUT_GAME_ROUND_STR )
        val input = Console.readLine()
        Console.close()
        return input.toGameCount()
    }

    private fun String.toGameCount(): Int {
        return trim().toInt()
    }

}