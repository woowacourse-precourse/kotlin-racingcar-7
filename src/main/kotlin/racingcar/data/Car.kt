package racingcar.data

class Car(
    val name: String
) {
    init {
        require(name.length in NAME_MIN_LENGTH..NAME_MAX_LENGTH)
        require(!name.contains(SPACE))
        require(!name.contains(NEW_LINE))
    }

    companion object {
        private const val NAME_MIN_LENGTH = 1
        private const val NAME_MAX_LENGTH = 5
        private const val SPACE = " "
        private const val NEW_LINE = "\n"
    }
}