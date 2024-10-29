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
        if(name.isEmpty() && index != 1) {
            throw IllegalArgumentException("유효한 자동차 이름이 아닙니다.")
        }
    }

    /**
     * 자동차 이름이 중복되었는지 확인한다. 이 때, 문자열 앞 또는 뒤에 포함된 공백 문자는 고려하지 않는다.
     * 예를 들어, " sandy", "sandy ", " sandy ", "sandy"는 모두 중복된 이름으로 처리한다.
     * @throws IllegalArgumentException
     */
    fun checkCarNameOverlap(list: List<String>) {
        val validSet = list.toSet()
        if(list.size != validSet.size) {
            throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
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
                throw IllegalArgumentException("실시횟수는 1 이상의 정수만 입력 가능합니다.")
            }
            if(100 < validNum) {
                throw IllegalArgumentException("실시횟수는 100을 넘길 수 없습니다.")
            }
        } catch (e: Exception) {
           throw IllegalArgumentException("실시횟수는 1 이상의 정수만 입력 가능합니다.")
        }
    }

}