package racingcar

import camp.nextstep.edu.missionutils.Console.readLine
import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange

data class Player(val name: String, var progress: Int = 0)

fun createPlayers(input: String): List<Player> {
    val names = input.split(",").map { it.trim() }
    validateCarNames(names)
    return names.map { name -> Player(name) }
}

fun validateCarNames(names: List<String>) {
    for (name in names) {
        if (name.isEmpty() || name.length > 5) {
            throw IllegalArgumentException("1자 이상 5자 이하 이름만 가능합니다.")
        }
    }
}

fun playGame(players: List<Player>, rounds: Int) {
    println("\n실행 결과")
    repeat(rounds) {
        playRound(players)
        println()
    }
}

fun playRound(players: List<Player>) {
    players.forEach { player ->
        updateProgress(player, pickNumberInRange(0, 9))
        displayProgress(player)
    }
}

fun updateProgress(player: Player, randomNumber: Int) {
    if (randomNumber >= 4) {
        player.progress++
    }
}

fun displayProgress(player: Player) {
    val progressDisplay = "-".repeat(player.progress)
    println("${player.name} : $progressDisplay")
}

fun findWinners(players: List<Player>): List<Player> {
    val maxProgress = players.maxOfOrNull { it.progress } ?: 0
    return players.filter { it.progress == maxProgress }
}

fun getPlayerInput(): List<Player> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine() ?: ""
    return createPlayers(input)
}

fun getRoundsInput(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val rounds = readLine()?.toIntOrNull() ?: 0
    if (rounds <= 0) {
        throw IllegalArgumentException("시도 횟수는 1 이상 이어야 합니다.")
    }
    return rounds
}

fun displayWinners(winners: List<Player>) {
    val winnerNames = winners.joinToString(", ") { it.name }
    println("최종 우승자 : $winnerNames")
}

fun main() {
    try {
        val players = getPlayerInput()
        val rounds = getRoundsInput()

        playGame(players, rounds)

        val winners = findWinners(players)
        displayWinners(winners)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        throw e
    }
}