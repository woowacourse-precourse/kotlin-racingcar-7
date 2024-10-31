package racingcar.enum

const val ERROR_FORMAT = "[ERROR] %s"

enum class ValidationError(val message: String) {
    EMPTY(ERROR_FORMAT.format("값이 입력되지 않았습니다.")),
    INCLUDED_GAP(ERROR_FORMAT.format("공백이 포함되어 있습니다.")),
    INVALID_NAME(ERROR_FORMAT.format("잘못된 이름 형식입니다.")),
    DUPLICATION_NAME(ERROR_FORMAT.format("중복된 이름이 포함되어 있습니다.")),
    EXCEEDED_PLAYER_LIMIT(ERROR_FORMAT.format("출전 가능한 선수는 최대 5명입니다.")),
    INVALID_ATTEMPT_COUNT(ERROR_FORMAT.format("시도 횟수는 1 이상의 정수만 입력 가능합니다.")),
    EXCEEDED_ATTEMPT_COUNT(ERROR_FORMAT.format("최대 시도 횟수는 10번입니다."))
}