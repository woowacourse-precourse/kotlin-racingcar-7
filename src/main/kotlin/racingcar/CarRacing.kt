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

    fun moveCars(count: Int) {
        repeat(count) {
            for (car in cars) {
                car.moveForwardRandomly()
            }
        }
    }

    fun racing() {
        print("시도할 횟수는 몇 회인가요?\n")
        val inputRepeatCount = readLine()
        moveCars(inputRepeatCount.toInt())
    }
}