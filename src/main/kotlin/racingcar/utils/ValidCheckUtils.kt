package racingcar.utils

object ValidCheckUtils {

    private const val VALID_CAR_NAME_MAX_LENGTH = 5
    /**
     * 자동차 이름이 유효한 양식인지 확인한다. 이름은 반드시 [VALID_CAR_NAME_MAX_LENGTH] 이하만 가능하다.
     * @throws IllegalArgumentException
     */
    fun checkValidCarName(name: String) {
        if(name.length > VALID_CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${VALID_CAR_NAME_MAX_LENGTH}자를 넘길 수 없습니다.")
        }
    }

    /**
     * 입력받은 실시횟수가 유효한지 확인한다.
     * @throws IllegalArgumentException
     */
    fun checkGameCount(num: String) {
        try {
            val validNum = num.toInt()
            if(1 > validNum) {
                throw IllegalArgumentException("실시횟수는 1 이상의 양수만 가능합니다.")
            }
            if(100 > validNum) {
                throw IllegalArgumentException("실시횟수는 100을 넘길 수 없습니다.")
            }
        } catch (e: Exception) {
            throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }

}