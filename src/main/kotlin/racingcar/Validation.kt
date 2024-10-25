package racingcar

class Validation {

    fun checkCarNameLength(carName: List<Car>) {
        carName.forEach {
            if (it.name.length > 5) {
                throw IllegalArgumentException("자동차 이름은 5자 이하만 입력 가능합니다.")
            }
        }
    }
}