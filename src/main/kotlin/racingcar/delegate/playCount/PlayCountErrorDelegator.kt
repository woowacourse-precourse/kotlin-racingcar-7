package racingcar.delegate.playCount

interface PlayCountErrorDelegator {
    // 입력값이 공백인 경우
    fun checkPlayCountIsEmpty(playCount: String)
    // 입력값이 숫자로 변환될 수 있는가
    fun checkForChangeableToLong(playCount: String)
    // 입력값이 너무 커서 Int로 처리할 수 없는 경우
    fun checkForExceededMaxInt(playCount: Long)
    // 입력값이 숫자가 아닌 경우
    fun checkInvalidPlayCountFormat(playCount: String)
    // 입력값이 음수/소수인 경우
    fun checkInvalidPlayCountRange(playCount: String)
    // 입력값이 0인 경우
    fun checkInvalidPlayCountByZero(playCount: Int)
    // 입력값이 최대 이동 횟수를 초과할 경우
    fun checkExceededMaxPlayCount(playCount: Int)
}