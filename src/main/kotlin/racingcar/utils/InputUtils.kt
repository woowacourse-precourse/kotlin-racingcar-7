package racingcar.utils

import camp.nextstep.edu.missionutils.Console

object InputUtils {

    private const val INPUT_CARS_STR = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
    /**
     * 자동차 경주 게임에 참가하는 자동차 이름을 입력받는 함수
     * @return 자동차 이름 리스트(List)
     */
    fun getCarList(): List<String> {
        println(INPUT_CARS_STR)
        val input = Console.readLine()
        return input.toCarList()
    }

    private const val INPUT_CARS_SEPARATOR = ","
    /**
     * 자동차 이름을 쉼표(,)기준으로 분리하여 리스트를 생성한다.
     * @return 분리한 이름 리스트(List)
     */
    private fun String.toCarList(): List<String> {
        return split(INPUT_CARS_SEPARATOR).map {
            val name = it.trim()
            checkValidCarName(name)
            name
        }.filter {
            it.isBlank()
        }
    }

    private const val VALID_CAR_NAME_MAX_LENGTH = 5
    /**
     * 자동차 이름이 유효한 양식인지 확인한다. 이름은 반드시 [VALID_CAR_NAME_MAX_LENGTH] 이하만 가능하다.
     * @throws IllegalArgumentException
     */
    private fun checkValidCarName(name: String) {
        if(name.length > VALID_CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${VALID_CAR_NAME_MAX_LENGTH}자를 넘길 수 없습니다.")
        }
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
        return try {
            trim().toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }

}