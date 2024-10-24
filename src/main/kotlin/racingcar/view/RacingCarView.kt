package racingcar.view

import camp.nextstep.edu.missionutils.Console

private const val GET_NAME_OF_CAR_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
private const val GET_COUNT_MESSAGE = "시도할 횟수는 몇 회인가요?"
private const val RESULT_MESSAGE = "실행 결과"
private const val LINE_FEED = "\n"

class RacingCarView {
    companion object {
        fun printGetNameOfCar() {
            println(GET_NAME_OF_CAR_MESSAGE)
        }

        fun getNameOfCar(): String {
            return Console.readLine()
        }

        fun printCountOfRacing() {
            println(GET_COUNT_MESSAGE)
        }

        fun getCountOfRacing(): Int {
            return Console.readLine().toInt()
        }

        fun printResultMessage() {
            printLineFeed()
            println(RESULT_MESSAGE)
        }

        fun printStatusOfName(name: String) {
            print("$name : ")
        }

        fun printStatusOfMove(status: Int) {
            for (i in 1..status) {
                print("-")
            }
            printLineFeed()
        }

        fun printLineFeed() {
            print(LINE_FEED)
        }
    }
}