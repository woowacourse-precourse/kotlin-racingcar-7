package racingcar

class InputValidator {

    fun readCarNames(): List<String> {
        println(INPUT_CAR_NAMES_PROMPT)
        val input = readLine() ?: throw IllegalArgumentException(ERROR_CAR_NAME_REQUIRED)

        val carNames = input.split(",").map { it.trim() }

        carNames.forEach { name ->
            if (name.isEmpty()) {
                throw IllegalArgumentException(ERROR_CAR_NAME_EMPTY)
            }
            if (name.length > 5) {
                throw IllegalArgumentException(ERROR_CAR_NAME_TOO_LONG)
            }
        }

        if (carNames.size < 2) {
            throw IllegalArgumentException(ERROR_CAR_MINIMUM_REQUIRED)
        }

        return carNames
    }

    fun readAttemptCount(): Int {
        println(INPUT_ATTEMPT_COUNT_PROMPT)
        return readLine()?.toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException(ERROR_ATTEMPT_COUNT_INVALID)
    }

    companion object {
        // 안내 메시지
        const val INPUT_CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
        const val INPUT_ATTEMPT_COUNT_PROMPT = "시도할 횟수는 몇 회인가요?"

        // 에러 메시지
        const val ERROR_CAR_NAME_REQUIRED = "자동차 이름을 입력해야 합니다."
        const val ERROR_CAR_NAME_EMPTY = "자동차 이름은 공백으로 둘 수 없습니다."
        const val ERROR_CAR_NAME_TOO_LONG = "자동차 이름은 5자 이하만 가능합니다."
        const val ERROR_CAR_MINIMUM_REQUIRED = "자동차는 2대 이상이어야 합니다."
        const val ERROR_ATTEMPT_COUNT_INVALID = "1 이상의 정수를 입력해주세요."
    }
}