package racingcar.controller

import racingcar.model.RacingCar

class RacingCarController {
    fun createRacingCars(input: String): List<RacingCar> {
        val racingCarNames = parseRacingCarNames(input)
        if (validateRacingCarNames(racingCarNames)) {
            return racingCarNames.map { racingCarName ->
                RacingCar(racingCarName)
            }
        }
        throw IllegalArgumentException("레이싱카 생성이 실패했습니다.")
    }

    private fun parseRacingCarNames(input: String) = input.split(",").map { it.trim() }

    private fun validateRacingCarNames(racingCarNames: List<String>): Boolean {
        return when {
            hasDuplicateNames(racingCarNames) -> throw IllegalArgumentException("자동차 이름은 중복될 수 없습니다.")
            isNameEmpty(racingCarNames) -> throw IllegalArgumentException("자동차의 이름이 입력되지 않았습니다.")
            isOverMaxLength(racingCarNames) -> throw IllegalArgumentException("입력하신 이름의 길이가 5글자를 초과하였습니다.")
            else -> true
        }
    }

    private fun hasDuplicateNames(names: List<String>) = names.size != names.distinct().size

    private fun isNameEmpty(names: List<String>) = names.any { name ->
        name.isEmpty() }

    private fun isOverMaxLength(names: List<String>) = names.any { name ->
        name.length > 5
    }
}