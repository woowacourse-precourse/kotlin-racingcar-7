package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingCarModel {

    private lateinit var carList : List<String>
    private lateinit var carFowards : MutableList<String>

    fun seperateCarNames(input: String) {
        carList = input.split(",").map { it }
        carFowards = MutableList(carList.size) {""}
    }

    fun getRaceResult() : Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun repeatRace() {
        carList.indices.forEach{ index ->
            if (getRaceResult())
                carFowards[index] += "-"
        }
    }
}