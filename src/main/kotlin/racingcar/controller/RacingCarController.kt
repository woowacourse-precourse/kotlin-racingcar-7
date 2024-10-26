package racingcar.controller

import racingcar.model.RacingCar

class RacingCarController {
    fun createRacingCars(input: String): List<RacingCar> {
        val racingCarNames = splitRacingCarNames(input)
        if (validateRacingCarNames(racingCarNames)) {
            return racingCarNames.map { racingCarName ->
                RacingCar(racingCarName)
            }
        }
        throw IllegalArgumentException("레이싱카 생성이 실패했습니다.")
    }

    private fun splitRacingCarNames(input: String) = input.split(",")

    private fun validateRacingCarNames(racingCarNames: List<String>): Boolean {
        return when {
            hasDuplicateNames(racingCarNames) -> throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
            else -> true
        }
    }

    private fun hasDuplicateNames(names: List<String>) = names.size != names.distinct().size

}