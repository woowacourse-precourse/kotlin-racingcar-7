package racingcar.message

class InvalidCarNameException {
    companion object {
        const val EMPTY_NAME = "이름을 입력하지 않았습니다."
        const val ONLY_GAP = "공백만 입력할 수 없습니다."
        const val DELIMITER_INPUT = "구분자만 입력 되었습니다."
        const val CONTINUOUS_DELIMITER = "구분자는 연속 입력할 수 없습니다."
        const val START_AND_END_DELIMITER_INPUT = "시작과 끝 문자에 구분자를 입력할 수 없습니다."
        const val GAP_DELIMITER_INPUT = "공백만 있는 이름이 있습니다."
        const val EXCEEDED_CHARACTER_COUNT = "이름은 다섯글자를 초과할 수 없습니다."
        const val CANT_RACE_ALONE = "혼자 경주할 수 없습니다."
    }
}