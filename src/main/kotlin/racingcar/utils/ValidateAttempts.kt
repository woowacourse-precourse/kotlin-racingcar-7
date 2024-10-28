package racingcar.utils

object ValidateAttempts {

    fun checkIfEmpty(input: String): Int {
        return input.toIntOrNull() ?: throw IllegalArgumentException("숫자를 입력해주세요.")
    }

    fun validatePositiveAttempts(numberOfAttempts: Int) {
        if (numberOfAttempts <= 0) {
            throw IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.")
        }
    }
}