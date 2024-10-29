package racingcar

import racingcar.di.DependencyInjector
import racingcar.view.RacingView

fun main() {
    val dependencyInjector = DependencyInjector()
    val viewModel = dependencyInjector.injectViewModel()

    RacingView(viewModel)
}