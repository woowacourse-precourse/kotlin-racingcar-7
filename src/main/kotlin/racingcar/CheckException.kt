package racingcar

class CheckException {

    fun firstInput(car: String) {
        if (car == "" || !car.contains(",")) { // 빈문자열 또는 자동차 이름 하나만 입력 시
            throw IllegalArgumentException()
        }
        val carList = car.split(",").map { it.trim() }
        if (carList.size != carList.distinct().size) { //중복된 자동차 이름이 존재할 경우
            throw IllegalArgumentException()
        }
        carList.forEach {
            if (it.isBlank() || it.length > 5) { // 자동차 이름이 공백이거나 5자가 넘을 때
                throw IllegalArgumentException()
            }
        }
    }

    fun secondInput(count: String) {
        val num = count.toFloatOrNull()
        //양의 정수가 아닌 경우
        if (num == null || num <= 0 || num % 1 != 0f) { //실수형으로 입력된 정수(ex 3.0)은 정상적으로 처리
            throw IllegalArgumentException()
        }
    }
    //모든 자동차의 전진 결과가 0인 경우
    fun result(scores: MutableMap<String, Int>) {
        var check = 0
        for (score in scores) {
            if (score.value != 0)
                check += 1
        }
        if (check == 0) throw IllegalArgumentException()
    }
}