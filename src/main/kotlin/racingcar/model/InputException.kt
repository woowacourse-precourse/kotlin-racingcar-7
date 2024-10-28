package racingcar.model

import racingcar.constant.ModelConstants

class InputException {
    companion object {
        fun numberOfCarsException(numberOfCars: Int) {
            if (numberOfCars !in ModelConstants.NUMBER_OF_CARS_MIN..ModelConstants.NUMBER_OF_CARS_MAX) {
                throw IllegalArgumentException(ModelConstants.NUMBER_OF_CARS_EXCEPTION_MESSAGE)
            }
        }

        fun carNameLengthLimitException(nameList: List<String>) {
            for (name in nameList) {
                if (name.length !in ModelConstants.CAR_NAME_LENGTH_MIN..ModelConstants.CAR_NAME_LENGTH_MAX) {
                    throw IllegalArgumentException(ModelConstants.CAR_NAME_LENGTH_LIMIT_EXCEPTION_MESSAGE)
                }
            }
        }

        fun nonIntegerException(stingTypeTryCountInput: String) {
            val nonInteger = stingTypeTryCountInput.toIntOrNull() == null
            if (nonInteger) throw IllegalArgumentException(ModelConstants.NON_INTEGER_EXCEPTION_MESSAGE)
        }

        fun outOfTryCountRangeException(tryCountInput: Int) {
            val countRange = tryCountInput in ModelConstants.TRY_COUNT_MIN..ModelConstants.TRY_COUNT_MAX
            if (!countRange) throw IllegalArgumentException(ModelConstants.OUT_OF_TRY_COUNT_RANGE_EXCEPTION_MESSAGE)
        }
    }
}