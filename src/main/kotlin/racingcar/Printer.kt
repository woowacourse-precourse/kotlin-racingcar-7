package racingcar

class Printer {
    companion object {
        fun printPosition(carName: String, position: Int) {
            val positionString = "-".repeat(position)
            print("$carName : $positionString\n")
        }

        fun printResultTitle() {
            print("\n실행결과\n")
        }

        fun printNewLine() {
            print("\n")
        }

        fun printChampions(namesOfChampions: String) {
            print("최종 우승자 : $namesOfChampions")
        }

        fun printInputRepeatCount() {
            print("시도할 횟수는 몇 회인가요?\n")
        }

        fun printInputCarNames() {
            print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
        }
    }
}