package racingcar

class Validation {

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
}