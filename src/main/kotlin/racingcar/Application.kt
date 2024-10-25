package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game {
    // 게임 시작
    fun start() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val carNames = Console.readLine().split(",").map {Car(it.trim())}
        println("시도할 횟수는 몇 회인가요?")
        val roundCount = Console.readLine().toIntOrNull() ?: 0
        val race= Race(carNames, roundCount)
        race.runStart()
    }
}
// 자동차 클래스
data class Car(val name: String, val move: String = "") {
    // 자동차가 움직이는 기능
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.move += "-"
        }
    }
    // 자동차가 이동한 거리를 반환
    fun getMoveDistance(): Int {
        return this.move.length
    }
}

// 경주 관리 클래스
class Race(private val cars: List<Car>, private val roundCount: Int) {
    // 경주 시작
    fun runStart() {
        repeat(roundCount) {
            raceOnce()
        }
        announceWinner()
    }
}