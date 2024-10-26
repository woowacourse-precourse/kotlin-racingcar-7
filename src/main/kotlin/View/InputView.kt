package View
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        return Console.readLine().split(",").map { it.trim() }
    }

    fun getRounds(): Int {
        println("시도할 횟수는 몇 회인가요?")
        return Console.readLine().toIntOrNull()?.takeIf { it > 0 }
            ?: throw IllegalArgumentException("횟수는 1 이상의 정수를 입력해야 합니다.")
    }
}