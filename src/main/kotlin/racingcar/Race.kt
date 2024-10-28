package racingcar

import camp.nextstep.edu.missionutils.Randoms

fun raceCars(carNames: List<String>, attemptCount: Int): List<Int> {
    val distances = MutableList(carNames.size) { 0 }

    repeat(attemptCount) {
        carNames.indices.forEach { index ->
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                distances[index]++
            }
        }
        printResults(carNames, distances)
    }
    return distances
}
