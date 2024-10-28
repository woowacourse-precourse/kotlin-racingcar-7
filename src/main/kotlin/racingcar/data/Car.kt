package racingcar.data

class Car(
    val name: String,
    distance: Int = INIT_DISTANCE
) {
    var distance: Int = distance
        private set

    init {
        require(name.length in NAME_MIN_LENGTH..NAME_MAX_LENGTH)
        require(!name.contains(SPACE))
        require(!name.contains(NEW_LINE))
    }

    fun move(random: Int): Int {
        require(random in MIN_ADVANCE_VALUE..MAX_ADVANCE_VALUE)
        if (random >= DISTANCE_PLUS_MIN_NUMBER) return ++distance
        return distance
    }

    companion object {
        private const val NAME_MIN_LENGTH = 1
        private const val NAME_MAX_LENGTH = 5
        private const val SPACE = " "
        private const val NEW_LINE = "\n"
        private const val INIT_DISTANCE = 0
        private const val DISTANCE_PLUS_MIN_NUMBER = 4
        private const val MAX_ADVANCE_VALUE = 9
        private const val MIN_ADVANCE_VALUE = 0
    }
}