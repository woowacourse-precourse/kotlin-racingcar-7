package racingcar

class CheckException {

    fun firstInput(car: String) {
        if (car == "" || !car.contains(",")) {
            throw IllegalArgumentException()
        }
        val carList = car.split(",").map { it.trim() }
        if (carList.size != carList.distinct().size) {
            throw IllegalArgumentException()
        }
        carList.forEach {
            if (it.isBlank() || it.length > 5) {
                throw IllegalArgumentException()
            }
        }
    }

    fun secondInput(count: String) {
        val num = count.toFloatOrNull()
        if (num == null || num <= 0 || num % 1 != 0f) throw IllegalArgumentException()
    }

    fun result(scores: MutableMap<String, Int>) {
        var check = 0
        for (score in scores) {
            if (score.value != 0)
                check += 1
        }
        if (check == 0) throw IllegalArgumentException()
    }
}