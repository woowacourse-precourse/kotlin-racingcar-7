package racingcar

class Exeption {
    fun carNameExeption(carName: List<String>) {
        if (carName.any { it.length > NAME_MAX_LENGTH }) throw IllegalArgumentException()
        // 구분자가 ,가 아닐 때
        // 이름이 공백일 때
    }


    /*fun moveCountExeption(moveCount: ) {
        // 숫자가 아닐 때
    }*/

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}