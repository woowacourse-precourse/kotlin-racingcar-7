package racingcar.domain

@JvmInline
value class CarName(private val name: String) {
    init {
        require(name.length <= MAX_CAR_NAME_LENGTH)
    }

    companion object {
        private const val MAX_CAR_NAME_LENGTH = 5

        fun String.asCarName() = CarName(this)
    }
}