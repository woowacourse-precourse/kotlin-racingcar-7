package racingcar

class Exeption {
    fun carNameExeption(carName: List<String>) {
        if (carName.any { it.length > NAME_MAX_LENGTH }) throw IllegalArgumentException()
    }


    /*fun moveCountExeption(moveCount: ) {

    }*/

    companion object {
        const val NAME_MAX_LENGTH = 5
    }
}