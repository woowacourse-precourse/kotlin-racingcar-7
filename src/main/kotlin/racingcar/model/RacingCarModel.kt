package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RacingCarModel {
    private lateinit var carList: List<String>
    private lateinit var carForwards: MutableList<String>
    private val lengthException = "자동차 이름은 0자 미만이거나 5자를 초과할 수 없습니다"

    private fun separateCarNames(input: String) {
        carList = input.split(",").map { isLengthOverOrNull(it) }
        carForwards = MutableList(carList.size) { "" }
    }

    private fun getRaceResult(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= 4
    }

    private fun runRaceAttempt(): String {
        carForwards =
            carForwards.mapIndexed { _, forward -> if (getRaceResult()) "$forward-" else forward }.toMutableList()
        return carList.indices.joinToString("\n") { "${carList[it]} : ${carForwards[it]}" } + "\n\n"
    }

    private fun findWinners(): String {
        val max = carForwards.max().length
        return carList.filterIndexed { index, _ -> carForwards[index].length == max }.joinToString(",")
    }

    fun runRace(inputCarList: String, attempts: Int): Pair<String, String> {
        var attemptResult = ""
        separateCarNames(inputCarList)
        repeat(attempts) { attemptResult += runRaceAttempt() }
        val winners = findWinners()
        return Pair(attemptResult, winners)
    }

    //Exception
    private fun isLengthOverOrNull(name: String): String {
        name.takeIf { it.length > 5 || it.isEmpty() }?.let { throw IllegalArgumentException("$lengthException: $name") }
        return name
    }

}