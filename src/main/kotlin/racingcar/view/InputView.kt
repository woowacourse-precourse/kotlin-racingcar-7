package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputName(): List<String> {
        val input = Console.readLine()
        val nameList = input.split(NAME_DELIMITER)
        return getNameOfCar(nameList)
    }

    fun getNameOfCar(nameList: List<String>): List<String> {
        require(nameList.size == nameList.distinct().size) { ERROR_SAME_NAME }
        for (name in nameList) {
            require(name.isNotEmpty()) { ERROR_EMPTY_NAME }
            require(name.all{ it.isLetter() }) { ERROR_INVALID_NAME }
            require(name.length <= 5) { ERROR_NAME_LENGTH }
        }
        return nameList
    }

    fun getCount(): Int {
        try {
            val count = Console.readLine().toInt()
            require(count > 0) { ERROR_COUNT_SIZE }
            return count
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_ONLY_DIGIT)
        }
    }

    companion object {
        private const val ERROR_SAME_NAME = "[경고] 중복된 이름이 있습니다."
        private const val ERROR_EMPTY_NAME = "[경고] 비어있는 이름이 있습니다."
        private const val ERROR_INVALID_NAME = "[경고] 알파벳으로 이뤄진 이름만 입력 가능합니다."
        private const val ERROR_NAME_LENGTH = "[경고] 이름은 5글자를 초과할 수 없습니다."
        private const val ERROR_COUNT_SIZE = "[경고] 1이상이어야 합니다."
        private const val ERROR_ONLY_DIGIT = "[경고] 숫자만 입력 가능합니다."
        private const val NAME_DELIMITER = ","
    }
}