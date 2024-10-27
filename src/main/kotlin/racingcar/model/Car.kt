package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.constants.CarException

class Car(val name: String) {
    var distance = 0
        private set

    init {
        require(name.length <= 5) { CarException.LENGTH.message }
        require(!name.contains(" ")) { CarException.NO_SPACES.message }
        require(name.all { it.isLowerCase() }) { CarException.LOWERCASE_ONLY.message }
    }

    fun moveForwardIfPossible() {
        if (shouldMove()) {
            distance++
        }
    }

    private fun shouldMove(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}