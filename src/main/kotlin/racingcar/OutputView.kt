package racingcar

class OutputView {

    fun printCarNamesRequest() {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    }

    fun printRaceCountRequest() {
        println("시도할 횟수는 몇 회인가요 ?")
    }

    fun printResultHeader() {
        println("실행 결과")
    }

    fun printLineBreak() {
        println()
    }

    fun printRaceProgress(car: Car) {
        println("${car.name} : ${"-".repeat(car.location)}")
    }

    fun printWinners(winnerNames: List<String>) {
        println("최종 우승자 : ${winnerNames.joinToString(", ")}")
    }
}