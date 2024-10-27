package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val ROUNDS_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"

data class Output(val carNameList: List<String>, val rounds: Long)

class UserInput {
    companion object {
        fun request(): Output {
            println(CAR_NAMES_REQUEST_MESSAGE)
            var carNamesInput = readLine()
            println(ROUNDS_REQUEST_MESSAGE)
            var roundsInput = readLine()

            verifyCarNamesInput(carNamesInput)
            verifyRoundsInput(roundsInput)
            val carNameList = parseCarNamesInput(carNamesInput)
            val rounds = parseRoundsInput(roundsInput)

            return Output(carNameList, rounds)
        }

        private fun parseCarNamesInput(carNamesInput: String): List<String> {
            val rawCarNameList = carNamesInput.split(",")
            return appendIndexToDuplicatedCarNames(rawCarNameList)
        }

        private fun appendIndexToDuplicatedCarNames(rawCarNameList: List<String>): List<String> {
            val map = mutableMapOf<String, Int>()
            val refinedCarNameList = mutableListOf<String>()

            for (carName in rawCarNameList) {
                if (!map.containsKey(carName)) {
                    map[carName] = 0
                    refinedCarNameList.add(carName)
                } else {
                    refinedCarNameList.add(carName + map[carName])
                    map[carName] = map[carName]!! + 1
                }
            }

            return refinedCarNameList.toList()
        }

        private fun parseRoundsInput(roundsInput: String): Long {
            return roundsInput.toLong()
        }

        private fun verifyCarNamesInput(carNamesInput: String) {
            if (carNamesInput.isBlank()) throw IllegalArgumentException("자동차 이름이 빈 문자열입니다.")

            val names = carNamesInput.split(",").map { it }
            for (name in names) {
                if (name.isBlank()) throw IllegalArgumentException("자동차 이름은 비어 있을 수 없습니다.")
                if (name.length > 5) throw IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.")
            }
        }

        private fun verifyRoundsInput(roundsInput: String) {
            val rounds = roundsInput.toIntOrNull() ?: throw IllegalArgumentException("이동 횟수는 숫자로 입력해야 합니다.")
            if (rounds <= 0) throw IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.")
        }
    }
}