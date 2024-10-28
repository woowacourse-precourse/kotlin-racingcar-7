package racingcar.constant

object ModelConstants {
    const val NUMBER_OF_CARS_EXCEPTION_MESSAGE = "최소 2개에서 최대 16개의 이름을 입력해주세요."
    const val CAR_NAME_LENGTH_LIMIT_EXCEPTION_MESSAGE = "이름은 최소 한글자에서 최대 5글자로 입력해주세요.(공백은 입력시 0글자로 간주됩니다.)"
    const val NON_INTEGER_EXCEPTION_MESSAGE = "시도할 횟수는 정수를 입력해주세요."
    const val OUT_OF_TRY_COUNT_RANGE_EXCEPTION_MESSAGE = "시도할 횟수는 최소 1에서 16의 자연수로 입력해주세요."

    const val COMMA = ","
    const val COMMA_SPACE = ", "
    const val HYPHEN = "-"

    const val DUPLICATE_THRESHOLD = 1

    const val CAR_LOCATION_INITIAL_VALUE = 0
    const val ONE_STEP_THRESHOLD = 4
    const val ONE_STEP_LENGTH = 1

    const val NUMBER_OF_CARS_MIN = 2
    const val NUMBER_OF_CARS_MAX = 16
    const val CAR_NAME_LENGTH_MIN = 1
    const val CAR_NAME_LENGTH_MAX = 5
    const val TRY_COUNT_MIN = 1
    const val TRY_COUNT_MAX = 16
}