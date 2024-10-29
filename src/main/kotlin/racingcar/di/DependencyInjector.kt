package racingcar.di

import camp.nextstep.edu.missionutils.Randoms
import racingcar.PlayGround
import racingcar.constans.Constants.MAX_RANDOM_NUMBER
import racingcar.constans.Constants.MIN_RANDOM_NUMBER
import racingcar.reducer.PlayerStateReducer
import racingcar.delegate.ValidationDelegator
import racingcar.delegate.ValidationDelegatorImpl
import racingcar.delegate.playCount.PlayCountErrorDelegator
import racingcar.vm.RacingViewModel
import racingcar.delegate.playCount.PlayCountErrorDelegatorImpl
import racingcar.delegate.name.NameErrorDelegator
import racingcar.delegate.name.NameErrorDelegatorImpl
import racingcar.sam.MoveCountFactory

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

    private fun injectMoveCountFactory() = MoveCountFactory {
        Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
    }

    private fun injectStateReducer(): PlayerStateReducer = PlayerStateReducer()

    private fun injectPlayGround(): PlayGround =
        PlayGround(injectStateReducer(), injectMoveCountFactory())

    private fun injectNameErrorDelegator(): NameErrorDelegator = NameErrorDelegatorImpl()

    private fun injectPlayCountErrorDelegator(): PlayCountErrorDelegator =
        PlayCountErrorDelegatorImpl()
}