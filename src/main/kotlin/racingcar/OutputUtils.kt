package racingcar

fun printResults(carNames: List<String>, distances: List<Int>) {
    carNames.indices.forEach { index ->
        println("${carNames[index]} : ${"-".repeat(distances[index])}")
    }
}

fun determineWinners(carNames: List<String>, distances: List<Int>): List<String> {
    val maxDistance = distances.maxOrNull() ?: return emptyList()
    return carNames.filterIndexed { index, _ -> distances[index] == maxDistance }
}
