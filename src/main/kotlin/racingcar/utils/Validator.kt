package racingcar.utils
object Validator {
    fun validateCarName(carList: List<String>) {
        carList.forEach { carName ->
            validateCarNameLength(carName)
            validateCarNameBlank(carName)
            validateCarNameCharacters(carName)
        }
    }

    fun validateMoveCount(moveCount: Int) {
        if (moveCount <= 0) {
            throw IllegalArgumentException("시도 횟수는 0이 아닌 양의 정수여야합니다.")
        }
    }

    private fun validateCarNameLength(carName: String) {
        if (carName.length > 5) {
            throw IllegalArgumentException("이름은 5자 이내여야합니다.")
        }
    }

    private fun validateCarNameBlank(carName: String) {
        if (carName.isBlank()) {
            throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
        }
    }

    private fun validateCarNameCharacters(carName: String) {
        if (!carName.all { it.isLetter() || it == ',' }) {
            throw IllegalArgumentException("콤마(,)를 제외한 기호는 입력할 수 없습니다.")
        }
    }
}
