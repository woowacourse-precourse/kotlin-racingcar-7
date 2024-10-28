package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constant.ModelConstants

class Race {
    fun adjustTryCountTypeInput(input: String): Int {
        InputException.nonIntegerException(input)
        val tryCountInput = input.toInt()
        InputException.outOfTryCountRange(tryCountInput)

        return tryCountInput
    }

    fun changeNameListToNameWithCountList(nameList: List<String>): List<Pair<String, Int>> {
        return nameList.groupBy { it }.map { (carName, _) -> carName to ModelConstants.CAR_LOCATION_INITIAL_VALUE }
    }

    fun updateCarLocation(carWithCount: List<Pair<String, Int>>): List<Pair<String, Int>> {
        return carWithCount.map { (carName, carLocation) ->
            val isGoOneStep = Randoms.pickNumberInRange(0, 9) >= ModelConstants.ONE_STEP_THRESHOLD
            if (isGoOneStep) carName to carLocation + ModelConstants.ONE_STEP_LENGTH else carName to carLocation
        }
    }

    fun getRoundResult(carLocation: Int): String {
        return ModelConstants.HYPHEN.repeat(carLocation)
    }

    fun getWinners(carWithCount: List<Pair<String, Int>>): String {
        val maxCount = carWithCount.maxOf { it.second }
        val winners = carWithCount.filter { it.second == maxCount }.joinToString(ModelConstants.COMMA_SPACE) { it.first }

        return winners
    }
}