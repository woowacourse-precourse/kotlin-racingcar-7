package racingcar

import camp.nextstep.edu.missionutils.Randoms

import racingcar.model.Car

fun isValidName(name: String) : Boolean {
    if (name.length > 5) {
        throw IllegalArgumentException()
    }
    return true
}

fun isValidRound(round: Int): Boolean {
    if (round > 0) {
        return true
    }
    throw IllegalArgumentException()
}

fun splitName(names: String): List<String> {
    return names.split(",")
}

fun createCar(names: List<String>) : Map<String, Car> {
    val cars = mutableMapOf<String, Car>()
    for (name in names) {
        if (isValidName(name)) {
            cars[name] = Car(0, 0)
        }

    }
    return cars
}

fun getRandomNumber() : Int {
    return Randoms.pickNumberInRange(0,9)
}

fun moveCar(car: Map.Entry<String, Car>) {
    car.value.location += 1
}

fun stopCar(){ }

fun main() {
    val names = splitName(inputName)

    isValidRound(inputRound)
    val cars = createCar(names)



    var randomNumber = 0
    repeat(inputRound) {
        for (car in cars) {
            randomNumber = getRandomNumber()
            if (randomNumber >= 4) {
                moveCar(car)
            } else {
                stopCar()
            }
            val currentlocation: Int = car.value.location
            val line = "-"
            println("${car.key} : ${line.repeat(currentlocation)}")

        }
        println()
    }

    var top = 0
    var winner = ""

    for (car in cars) {
        if (car.value.location > 0) {
            top = car.value.location
        }
    }

    for (car in cars) {
        if (car.value.location == top) {
            if (winner == "") {
                winner = car.key
            } else {
                winner += ", ${car.key}"
            }
        }
    }
}
