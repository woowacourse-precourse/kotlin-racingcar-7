package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(
    val name: String,
    var moveCount: Int = 0
) {

    fun tryMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) moveCount++
    }
}