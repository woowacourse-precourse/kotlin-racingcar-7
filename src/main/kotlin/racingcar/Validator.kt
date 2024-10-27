package racingcar

class Validator {

    fun splitNames(names: String): List<String> {
        val cars = names.split(",")
        return cars
    }

    fun nameCheck(cars: List<String>) {
        carCountCheck(cars)
        nameDuplicateCheck(cars)
        for (name in cars) {
            nameCountCheck(name)
        }
    }

    private fun carCountCheck(cars: List<String>) {
        if (cars.size > MAX_CAR_COUNT) throw IllegalArgumentException("차는 9대 이하여야 합니다.")
    }

    private fun nameDuplicateCheck(cars: List<String>) {
        val maxCount = cars.groupingBy { it }.eachCount().toList().sortedBy { it.second }[0]
        if (maxCount.second > 1) throw IllegalArgumentException("차의 이름은 중복될 수 없습니다.")
    }

    private fun nameCountCheck(carName: String) {
        if (carName.length > MAX_CAR_LENGTH) throw IllegalArgumentException("차의 이름은 5자를 넘을 수 없습니다.")
    }

    fun iterationCountCheck(countInput: String): Int {
        val countNumber = isNumber(countInput)
        isPositive(countNumber)
        return countNumber
    }

    private fun isNumber(countInput: String): Int {
        val countNumber: Int
        try {
            countNumber = countInput.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("반복 횟수는 숫자여야 합니다.")
        }
        return countNumber
    }

    private fun isPositive(number: Int) {
        if (number <= 0) throw IllegalArgumentException("반복 횟수는 양수여야 합니다.")
    }

    companion object {
        const val MAX_CAR_COUNT = 9
        const val MAX_CAR_LENGTH = 5
    }
}