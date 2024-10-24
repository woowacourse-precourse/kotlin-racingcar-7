package racingcar

fun main() {
    repeat(inputRound) {
        for (car in cars) {
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
