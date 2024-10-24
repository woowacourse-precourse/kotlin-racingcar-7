package racingcar

open class Validator {

    fun splitNames(nameString: String): List<String> {
        val carList = nameString.split(",")
        return carList
    }

    fun nameCheck(carList: List<String>) {
        carCountCheck(carList)
        nameDuplicateCheck(carList)
        for (car in carList) {
            nameCountCheck(car)
        }
    }

    private fun carCountCheck(carList: List<String>) {
        if (carList.size > MAX_CAR_COUNT) throw IllegalArgumentException("차는 9대 이하여야 합니다.")
    }

    private fun nameDuplicateCheck(carList: List<String>) {
        val maxCount = carList.groupingBy { it }.eachCount().toList().sortedBy { it.second }[0]
        if (maxCount.second > 1) throw IllegalArgumentException("차의 이름은 중복될 수 없습니다.")
    }

    private fun nameCountCheck(carName: String) {
        if (carName.length > MAX_CAR_LENGTH) throw IllegalArgumentException("차의 이름은 5자를 넘을 수 없습니다.")
    }

    fun iterCountCheck(countString: String): Int {
        val count = isNumber(countString)
        isPositive(count)
        return count
    }

    private fun isNumber(string: String): Int {
        val count: Int
        try {
            count = string.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException("반복 횟수는 숫자여야 합니다.")
        }
        return count
    }

    private fun isPositive(number: Int) {
        if (number <= 0) throw IllegalArgumentException("반복 횟수는 양수여야 합니다.")
    }

    companion object {
        const val MAX_CAR_COUNT = 9
        const val MAX_CAR_LENGTH = 5
    }
}