package racingcar

fun main() {
    val view = View()
    val model = Model()
    val controller = Controller(model, view)
    controller.run()
}
