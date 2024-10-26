package racingcar.domain

class FakeRandomNumberImpl : RandomNumber {

    private var number = DEFAULT_NUMBER

    fun setNumber(number: Int) {
        this.number = number
    }

    override fun generate(): Int = number

    companion object {
        private const val DEFAULT_NUMBER = 4
    }
}
