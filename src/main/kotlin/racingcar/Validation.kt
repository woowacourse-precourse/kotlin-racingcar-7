package racingcar

class Validation {

    fun validateCarName(carName: List<Car>) {
        checkCarNameLength(carName)
        checkCarNameBlank(carName)
        checkOnlyOneCar(carName)
        checkCarNameDuplication(carName)
    }

    fun checkCarNameLength(carName: List<Car>) {
        carName.forEach {
            if (it.name.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.")
            }
        }
    }

    fun checkCarNameBlank(carName: List<Car>) {
        if (carName.any { it.name.isBlank() }) {
            throw IllegalArgumentException("자동차 이름이 공백일 수 없습니다.")
        }
    }

    fun checkOnlyOneCar(carName: List<Car>) {
        if (carName.isEmpty()) {
            throw IllegalArgumentException("자동차 이름은 2대 이상 입력해 주세요.")
        }
    }

    fun checkCarNameDuplication(carName: List<Car>) {
        val carNames = carName.map { it.name }
        if (carNames.distinct().size != carNames.size) {
            throw IllegalArgumentException("중복된 이름은 작성할 수 없습니다.")
        }
    }

    fun checkRoundCountNotNumber(inputRoundCount: String) {
        if (inputRoundCount.toIntOrNull() == null) {
            throw IllegalArgumentException("숫자가 아닙니다.")
        }
    }

    fun checkRoundCountNegativeInteger(inputRoundCount: String) {
        val roundCount = inputRoundCount.toInt()
        if (roundCount < 1) throw IllegalArgumentException("1보다 작은 수는 입력할 수 없습니다.")
    }
}