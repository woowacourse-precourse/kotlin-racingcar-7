package racingcar

class Exeption(private val input: Input = Input()) {

    fun carNameExeption(carName: List<String>) {

        when {
            COMMA !in carName[0] && lengthOver(carName) -> throw IllegalArgumentException("구분자는 (,)이어야 합니다.")
            lengthOver(carName) -> throw IllegalArgumentException("자동차 이름은 5글자가 넘어가면 안됩니다.")
            carName.any { it.isBlank() } -> throw IllegalArgumentException("자동차 이름이 공백이면 안됩니다.")
            else -> throw IllegalArgumentException("자동차 이름 입력 오류입니다.")
        }
    }

    /*fun moveCountExeption(moveCount: ) {
        // 숫자가 아닐 때
    }*/

    fun lengthOver(carName: List<String>) = carName.any { it.length > NAME_MAX_LENGTH }

    companion object {
        const val NAME_MAX_LENGTH = 5
        const val COMMA = ","
    }
}