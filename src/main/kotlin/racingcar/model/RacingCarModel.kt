package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingCarModel{
    private lateinit var carList : List<String>
    private lateinit var carFowards : MutableList<String>

    fun seperateCarNames(input: String) {
        carList = input.split(",").map { it }
        carFowards = MutableList(carList.size) {""}
    }

    fun getRaceResult(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    fun runRaceAttempt() : String {
        var eachAttemptResult = ""
        carList.indices.forEach{ index ->
            if (getRaceResult())
                carFowards[index] += "-"
        }
        for (i in carList.indices) {
            eachAttemptResult += "${carList[i]} : ${carFowards[i]}\n"
        }
        return eachAttemptResult+"\n"
    }
    fun findWinners(): String {
        val max = carFowards.max().length
        return carList.filterIndexed{index, _ -> carFowards[index].length == max}.joinToString(",")
    }

    fun runRace(inputCarList: String, attempts: Int): Pair<String, String> {
        var attemptResult = ""
        seperateCarNames(inputCarList)
        repeat(attempts) {
            attemptResult += runRaceAttempt()
        }
        val winners = findWinners()
        return Pair(attemptResult, winners)
    }

}