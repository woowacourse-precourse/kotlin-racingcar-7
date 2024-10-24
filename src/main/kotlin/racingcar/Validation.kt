package racingcar

class Validation() {
    fun isNotEmpty(string: String) {
        if (string.isEmpty()) {
            throw IllegalArgumentException()
        }
    }

    fun isDigit(string: String) {
        string.map {
            if (!it.isDigit()) {
                throw IllegalArgumentException()
            }
        }
    }

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

    fun isCarNameUnder5(car: String): Boolean {
        if (car.length > 5) {
            throw IllegalArgumentException()
        }
        return true
    }
}