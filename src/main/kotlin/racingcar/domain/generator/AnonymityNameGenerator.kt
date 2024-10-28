package racingcar.domain.generator

class AnonymityNameGenerator {
    private var anonymityCount = INITIAL_ANONYMITY_COUNT

    fun generator() = "${ANONYMITY}${anonymityCount++}"

    companion object {
        private const val INITIAL_ANONYMITY_COUNT = 1
        private const val ANONYMITY = "익명"
    }
}