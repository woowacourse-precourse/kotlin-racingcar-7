package racingcar.view
import camp.nextstep.edu.missionutils.Console

class UserInterface {
    fun getCarName(): String {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        return input
    }

    fun getNumberOfAttempts(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine().toInt()
        return input
    }

    fun showRaceStart() {
        println()
        println("실행 결과")
    }

    fun printRacingCar(carNames: List<String>, carMoved: List<Int>){
        for(i in carNames.indices){
            val dashes = "-".repeat(carMoved[i])
            println("${carNames[i]} : $dashes")
        }
    }

    fun showResult(result: List<String>) {
        println("최종 우승자: ${result.joinToString(", ")}")
    }
}