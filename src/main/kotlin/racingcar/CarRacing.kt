package racingcar
import camp.nextstep.edu.missionutils.Console.readLine

class CarRacing(names: String) {
    private val cars: List<Car>

    init {
        val carNames = names.split(",")
        exceptForCarNamesLongerThan5Characters(carNames)
        this.cars = carNames.map { Car(it) }
    }

    private fun exceptForCarNamesLongerThan5Characters(carNames: List<String>) {
        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("5자 이하의 자동차 이름을 입력해주세요.")
        }
    }

    fun getNamesOfCars(): List<String> {
        return cars.map { it.name }
    }

    private fun moveCars() {
        cars.forEach { it.moveForwardRandomly() }
        Printer.printNewLine()
    }

    private fun moveCarsRepeat(count: Int) {
        Printer.printResultTitle()
        repeat(count) {
            moveCars()
        }
    }

    private fun getNamesOfChampions(): String {
        val leadingCarPosition = cars.maxOfOrNull { it.position } ?: return "없음"
        val championCars = cars.filter { it.position == leadingCarPosition }
        return championCars.joinToString(", ") { it.name }
    }

    private fun holdAnAwardsCeremony() {
        val namesOfChampions = getNamesOfChampions()
        Printer.printChampions(namesOfChampions)
    }

    fun racing() {
        val repeatCount = inputRepeatCount()
        moveCarsRepeat(repeatCount)
        holdAnAwardsCeremony()
    }

    private fun inputRepeatCount(): Int {
        Printer.printInputRepeatCount()
        val repeatCount = readLine()
        return repeatCount.toInt()
    }
}