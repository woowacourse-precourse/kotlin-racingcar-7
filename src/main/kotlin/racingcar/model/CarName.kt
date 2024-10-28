package racingcar.model

import racingcar.constant.ModelConstants

class CarName {
    fun splitNameByComma(input: String): List<String> {
        return input.split(ModelConstants.COMMA)
    }

    fun changeDuplicateName(nameList: List<String>): List<String> {
        checkCarNameErrors(nameList)

        return nameList
            .groupingBy { it }
            .eachCount()
            .flatMap { (carName, count) ->
                if (count > ModelConstants.DUPLICATE_THRESHOLD) {
                    List(count) { nameNumber -> "${carName}_$nameNumber" }
                } else {
                    listOf(carName)
                }
            }
    }

    private fun checkCarNameErrors(carNameList: List<String>) {
        InputException.numberOfCarsException(carNameList.size)
        InputException.carNameLengthLimitException(carNameList)
    }
}