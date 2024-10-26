package racingcar.di

import racingcar.PlayGround
import racingcar.reducer.PlayerStateReducer
import racingcar.delegate.ValidationDelegator
import racingcar.delegate.ValidationDelegatorImpl
import racingcar.delegate.playCount.PlayCountErrorDelegator
import racingcar.viewModel.RacingViewModel
import racingcar.delegate.playCount.PlayCountErrorDelegatorImpl
import racingcar.delegate.name.NameErrorDelegator
import racingcar.delegate.name.NameErrorDelegatorImpl

class DependencyInjector {

    fun injectViewModel(): RacingViewModel {
        val nameErrorDelegator = injectNameErrorDelegator()
        val playCountErrorDelegator = injectPlayCountErrorDelegator()
        val validationDelegator =
            injectValidationDelegator(nameErrorDelegator, playCountErrorDelegator)

        return RacingViewModel(validationDelegator, injectPlayGround())
    }

    private fun injectValidationDelegator(
        injectNameErrorDelegator: NameErrorDelegator,
        injectPlayCountErrorDelegator: PlayCountErrorDelegator
    ): ValidationDelegator {
        return ValidationDelegatorImpl(injectNameErrorDelegator, injectPlayCountErrorDelegator)
    }

    private fun injectStateReducer(): PlayerStateReducer = PlayerStateReducer()

    private fun injectPlayGround(): PlayGround = PlayGround(injectStateReducer())

    private fun injectNameErrorDelegator(): NameErrorDelegator = NameErrorDelegatorImpl()

    private fun injectPlayCountErrorDelegator(): PlayCountErrorDelegator = PlayCountErrorDelegatorImpl()
}