package racingcar.vm

import racingcar.constans.Constants.SEPARATOR
import racingcar.delegate.ValidationDelegator
import racingcar.event.RacingViewEvent.InputPlayerName
import racingcar.event.RacingViewEvent.InputPlayCount
import racingcar.PlayGround
import racingcar.event.RacingViewEvent
import racingcar.model.CarRacingState.PlayerState
import racingcar.model.CarRacingState.PlayResultState
import racingcar.model.GameState

class RacingViewModel(
    private val validationDelegator: ValidationDelegator,
    private val playGround: PlayGround,
) {
    private val state = GameState(mutableListOf(), 0)

    fun onCompleteInput(event: RacingViewEvent) {
        when (event) {
            is InputPlayerName -> onCompleteInputPlayerNames(event)
            is InputPlayCount -> onCompleteInputPlayCount(event)
        }
    }

    private fun onCompleteInputPlayerNames(event: InputPlayerName) {
        val userNames = event.userNames
        validationDelegator.handleUserNameInput(userNames)
        val separatedNames = userNames
            .split(SEPARATOR)
            .map { it.trim() }
        reducePlayerState(separatedNames)
    }

    private fun onCompleteInputPlayCount(event: InputPlayCount) {
        val playCount = event.playCount
        validationDelegator.checkPlayCountIsValidNumeric(playCount)
        validationDelegator.handlePlayCountInput(playCount.toInt())
        reducePlayCountState(playCount.toInt())
    }

    fun playGame(): PlayResultState {
        return playGround.play(state.players, state.playCount)
    }

    private fun reducePlayerState(separatedNames: List<String>) {
        separatedNames.forEach { name ->
            state.players.add(PlayerState(playerName = name, position = 0))
        }
    }

    private fun reducePlayCountState(playCount: Int) {
        state.playCount = playCount
    }
}