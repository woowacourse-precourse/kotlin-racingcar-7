package racingcar.utils

object Validator {
    fun validateCarName(carList: List<String>) {
        carList.forEach {
            if (it.length > 5) {
                throw IllegalArgumentException("이름은 5자 이내여야합니다.")
            } else if(it.isBlank()) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }
        }
    }
}