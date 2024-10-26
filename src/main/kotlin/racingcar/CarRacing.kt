package racingcar
import camp.nextstep.edu.missionutils.Console.readLine

class CarRacing(names: String) {
    val cars: List<Car>

    init {
        this.cars = names.split(",").map { Car(it) }
    }

    fun getNamesOfCars(): List<String> {
        return cars.map { it.name }
    }

    fun moveCars() {
        for (car in cars) {
            car.moveForwardRandomly()
        }
        print("\n")
    }

    fun moveCarsRepeat(count: Int) {
        print("실행결과\n")
        repeat(count) {
            moveCars()
        }
    }

    fun getNamesOfChampions(): String {
        val leadingCarPosition = cars.maxOfOrNull { it.position } ?: return "없음"
        val championCars = cars.filter { it.position == leadingCarPosition }
        return championCars.joinToString(", ") { it.name }
    }

    fun printNamesOfChampions() {
        val namesOfChampions = getNamesOfChampions()
        print("최종 우승자 : $namesOfChampions")
    }

    fun racing() {
        print("시도할 횟수는 몇 회인가요?\n")
        val inputRepeatCount = readLine()
        val repeatCount = inputRepeatCount.toInt()
        moveCarsRepeat(repeatCount)
        printNamesOfChampions()
    }
}