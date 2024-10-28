package racingcar.controller

object CarNameValidator {
    const val ERROR_EMPTY_NAME = "자동차 이름은 공백이거나 빈 문자열일 수 없습니다."
    const val ERROR_LENGTH_EXCEEDED = "자동차 이름은 5자 이하여야 합니다."
    const val ERROR_CONTAINS_SPACE = "자동차 이름은 공백을 포함할 수 없습니다."
    const val ERROR_DUPLICATE_NAME = "자동차 이름은 중복될 수 없습니다."
}

object RaceCountValidator {
    const val ERROR_EMPTY_COUNT = "경주 시도 횟수는 빈 문자열일 수 없습니다."
    const val ERROR_NOT_NUMBER = "경주 시도 횟수는 숫자여야 합니다."
    const val ERROR_INVALID_COUNT = "경주 시도 횟수는 1 이상이어야 합니다."
}

object InputValidator {
    
    fun validateCarName(names: List<String>) {
        require(names.all { it.isNotBlank() }) {
            CarNameValidator.ERROR_EMPTY_NAME
        }
        require(names.all { it.length <= 5 }) {
            CarNameValidator.ERROR_LENGTH_EXCEEDED
        }
        require(names.all { !it.contains(" ") }) {
            CarNameValidator.ERROR_CONTAINS_SPACE
        }
        require(names.size == names.distinct().size) {
            CarNameValidator.ERROR_DUPLICATE_NAME
        }
    }

    fun validateRaceCount(count: String) {
        require(count.isNotBlank()) {
            RaceCountValidator.ERROR_EMPTY_COUNT
        }

        require(count.toIntOrNull() != null) {
            RaceCountValidator.ERROR_NOT_NUMBER
        }

        require(count.toInt() > 0) {
            RaceCountValidator.ERROR_INVALID_COUNT
        }
    }
}
