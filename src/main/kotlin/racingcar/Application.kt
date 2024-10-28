package racingcar
import camp.nextstep.edu.missionutils.Console.readLine

fun main() {
    Printer.printInputCarNames()
    val inputCarNames = readLine()
    val carRacing = CarRacing(inputCarNames)
    carRacing.racing()
}
