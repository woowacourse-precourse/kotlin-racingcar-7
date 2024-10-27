package racingcar

import camp.nextstep.edu.missionutils.Console.readLine

const val CAR_NAMES_REQUEST_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"
const val TOTAL_ATTEMPTS_REQUEST_MESSAGE = "시도할 횟수는 몇 회인가요?"

data class Output(val carNameList: List<String>, val totalAttempts: Long)

class UserInput {
    companion object {
        fun request(): Output {
            println(CAR_NAMES_REQUEST_MESSAGE)
            var carNamesInput = readLine()
            println(TOTAL_ATTEMPTS_REQUEST_MESSAGE)
            var totalAttemptsInput = readLine()

            verifyCarNamesInput(carNamesInput)
            verifyTotalAttemptsInput(totalAttemptsInput)
            val carNameList = parseCarNamesInput(carNamesInput)
            val totalAttempts = parseTotalAttemptsInput(totalAttemptsInput)

            return Output(carNameList, totalAttempts)
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
                    refinedCarNameList.add(carName+map[carName])
                    map[carName] = map[carName]!! + 1
                }
            }

            return refinedCarNameList.toList()
        }

        private fun parseTotalAttemptsInput(totalAttemptsInput: String): Long {
            return totalAttemptsInput.toLong()
        }

        private fun verifyCarNamesInput(carNamesInput: String) {
            // TODO: 자동차 이름 입력에 대한 검증 구현
        }

        private fun verifyTotalAttemptsInput(totalAttemptsInput: String) {
            // TODO: 총 이동 횟수에 대한 검증 구현
        }
    }
}