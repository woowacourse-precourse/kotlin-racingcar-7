package racingcar

fun main() {
    val inputs = UserInput.request()
    val race = Race(inputs.carNameList, inputs.rounds)
    race.run()
}
