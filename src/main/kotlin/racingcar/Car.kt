package racingcar

class Car(val name: String) {

    companion object {

        fun validateCarName(name: String): Car {
            if (name.isNotBlank() && name.length <= 5 && !name.contains(" ")) {
                return Car(name)
            } else {
                throw IllegalArgumentException("경주에 등록할 자동차 이름은 공백을 포함할 수 없으며, 5자 이하여야 합니다.")
            }
        }
    }
}