package racingcar.util

import racingcar.model.Car

class InputValidator {
    fun getValidCarList(carNamesInput: String): List<Car> {
        val tmpCarList = carNamesInput.split(",")

        isAllValid(tmpCarList)

        return tmpCarList.map { carName -> Car(name = carName) }
    }

    fun getValidRounds(roundsInput: String): Int {
        val rounds = roundsInput.toIntOrNull() ?: throw IllegalArgumentException(ROUNDS_ONLY_NUMBER)
        if (rounds < 1) throw IllegalArgumentException(ROUNDS_POSITIVE_INT)
        return rounds
    }

    private fun isAllValid(tmpCarList: List<String>) {
        tmpCarList.map { carName ->
            isValidCarNameLength(carName)
            hasBlankInCarName(carName)
        }
        hasDuplicatedCarName(tmpCarList)
    }

    private fun isValidCarNameLength(carName: String) {
        val len = carName.length
        if (1 > len || len > 5) throw IllegalArgumentException(NAME_LEN_BETWEEN_ONE_AND_FIVE)
    }

    private fun hasBlankInCarName(carName: String) {
        if (carName.contains(" ")) throw IllegalArgumentException(NAME_NOT_BLANK)
    }

    private fun hasDuplicatedCarName(carNameList: List<String>) {
        if (carNameList.toSet().size != carNameList.size) throw IllegalArgumentException(NAME_NOT_DUPLICATION)
    }

    companion object Error {
        private const val ROUNDS_ONLY_NUMBER = "시도 횟수는 숫자를 입력해주세요"
        private const val ROUNDS_POSITIVE_INT = "시도 횟수는 1 이상을 입력해 주세요."

        private const val NAME_LEN_BETWEEN_ONE_AND_FIVE = "차량 이름은 1-5자의 길이로 입력해주세요."
        private const val NAME_NOT_BLANK = "차량 이름은 공백을 포함할 수 없습니다."
        private const val NAME_NOT_DUPLICATION = "차량 이름은 중복될 수 없습니다."
    }
}
