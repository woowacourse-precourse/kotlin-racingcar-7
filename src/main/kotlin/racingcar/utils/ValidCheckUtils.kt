package racingcar.utils

object ValidCheckUtils {

    private const val VALID_CAR_NAME_MAX_LENGTH = 5
    /**
     * 자동차 이름이 유효한 양식인지 확인한다. 이름은 반드시 [VALID_CAR_NAME_MAX_LENGTH] 이하만 가능하다.
     * @throws IllegalArgumentException
     */
    fun checkValidCarName(name: String, index: Int) {
        if(name.length > VALID_CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException("자동차 이름은 ${VALID_CAR_NAME_MAX_LENGTH}자를 넘길 수 없습니다.")
        }
        // 주의: input 값이 "xxx,"형태일 경우 index가 1일 때 name은 Empty형태지만 이 경우 예외가 발생해서는 안된다.
        if(name.isEmpty() && index > 1) {
            throw IllegalArgumentException("유효한 자동차 이름이 아닙니다.")
        }
    }

    /**
     * 입력받은 실시횟수가 유효한지 확인한다.
     * @throws IllegalArgumentException
     */
    fun checkValidGameRound(num: String) {
        try {
            val validNum = num.toInt()
            if(1 > validNum) {
                throw IllegalArgumentException("실시횟수는 1 이상의 양수만 가능합니다.")
            }
            if(100 < validNum) {
                throw IllegalArgumentException("실시횟수는 100을 넘길 수 없습니다.")
            }
        } catch (e: Exception) {
           throw IllegalArgumentException("숫자만 입력 가능합니다.")
        }
    }

}