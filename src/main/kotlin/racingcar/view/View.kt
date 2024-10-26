package racingcar.view

interface View {
    fun requestCarNames(): String
    fun requestRoundCount(): Int
    fun showMatchProcess()
    fun showWinner()
}