package racingcar.message

class InvalidCountException {
    companion object {
        const val EMPTY_COUNT = "횟수를 입력하지 않았습니다."
        const val ZERO_INPUT = "0회는 할 수 없습니다."
        const val INCLUDED_STRING = "숫자만 입력 가능합니다."
    }
}