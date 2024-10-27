package racingcar

class Car(
    val name: String,
) {
    init {
        name.validateCarNaming()
    }

    private fun String.validateCarNaming() {
        if (this.length > CAR_NAME_MAX_LENGTH) {
            throw IllegalArgumentException(CAR_NAME_MAX_LENGTH_EXCEPTION)
        }
    }
}

private const val CAR_NAME_MAX_LENGTH = 5
private const val CAR_NAME_MAX_LENGTH_EXCEPTION = "자동차 이름은 5자 이하만 가능 합니다."
