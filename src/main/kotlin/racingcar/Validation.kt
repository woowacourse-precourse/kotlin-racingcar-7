package racingcar

class Validation() {
    // 자동차 이름은 문자, 숫자 모두 허용
    // split에 사용할 구분자는 ","만 허용
    fun isDelimitersCorrect(registaration: Registaration): Boolean {
        for (char in registaration.cars) {
            if (!char.isLetter() && !char.isDigit() && char != ',') {
                throw IllegalArgumentException()
            }
        }
        return true
    }

    fun isCarNameUnder5(cars: List<String>): Boolean {
        cars.map { if (it.length > 5) throw IllegalArgumentException() }
        return true
    }
}