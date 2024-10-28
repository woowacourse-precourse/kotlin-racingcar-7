package racingcar.validator

object InputValidator {
    fun validateNameNotNull(cars: List<String>) {
        cars.forEach {
            if (it.isEmpty()) throw IllegalArgumentException("자동차의 이름은 비어있을 수 없습니다.")
        }
    }

    fun validateNameLength(cars: List<String>) {
        cars.forEach {
            if (it.length > 5) throw IllegalArgumentException("자동차의 이름은 최대 5자입니다.")
        }
    }

    fun validateNameUniqueness(cars: List<String>) {
        if (cars.toSet().size < cars.size) throw IllegalArgumentException("중복된 자동차 이름이 있습니다.")
    }

    fun validateCountIsNumeric(countInput: String) {
        if (countInput.toIntOrNull() == null) throw IllegalArgumentException("올바른 숫자가 아닙니다.")
    }

    fun validateCountIsPositive(countInput: String) {
        if (countInput.toInt() < 1) throw IllegalArgumentException("시행 횟수는 1 이상이어야 합니다.")
    }
}
