package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class CarMovement(val currentStatus: MutableList<Pair<String, Int>>) {
    fun carAction(): MutableList<Pair<String, Int>> {
        increaseForward()
        return currentStatus
    }

    private fun increaseForward() {
        currentStatus.replaceAll { pair ->
            if (randomChecker()) pair.copy(second = pair.second + 1) else pair
        }
    }

    private fun randomChecker(): Boolean {
        var randomInt = Randoms.pickNumberInRange(0, 9)
        return randomInt >= 4
    }
}