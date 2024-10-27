package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

class Car(private val name: String){
    var distance = 0L
        private set

    /**
     * 자동차를 확률적으로 distance만큼 전진시킵니다.
     *
     * @param distance 전진시킬 거리
     * */
    fun tryToMoveForward(distance: Long) {
        if (pickNumberInRange(0,9) >= 4) {
            moveForward(distance)
        }
    }

    private fun moveForward(distance: Long) {
        this.distance += distance
    }
}