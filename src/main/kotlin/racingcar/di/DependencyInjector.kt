package racingcar.di

import racingcar.delegate.ValidationDelegator
import racingcar.delegate.ValidationDelegatorImpl
import racingcar.delegate.name.NameErrorDelegator
import racingcar.delegate.name.NameErrorDelegatorImpl
import racingcar.delegate.playCount.PlayCountErrorDelegator
import racingcar.delegate.playCount.PlayCountErrorDelegatorImpl
import racingcar.viewModel.RacingViewModel

class DependencyInjector {

    fun injectViewModel(): RacingViewModel {
        val nameErrorDelegator = injectNameErrorDelegator()
        val playCountErrorDelegator = injectPlayCountErrorDelegator()
        val validationDelegator =
            injectValidationDelegator(nameErrorDelegator, playCountErrorDelegator)

        return RacingViewModel(validationDelegator)
    }

    private fun injectValidationDelegator(
        injectNameErrorDelegator: NameErrorDelegator,
        injectPlayCountErrorDelegator: PlayCountErrorDelegator
    ): ValidationDelegator {
        return ValidationDelegatorImpl(injectNameErrorDelegator, injectPlayCountErrorDelegator)
    }

    private fun injectNameErrorDelegator(): NameErrorDelegator = NameErrorDelegatorImpl()

    private fun injectPlayCountErrorDelegator(): PlayCountErrorDelegator = PlayCountErrorDelegatorImpl()
}