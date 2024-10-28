package racingcar.model

class RacingCarModel {
    fun seperateCarNames(input: String) : List<String> {
        return input.split(",").map { it }
    }
}