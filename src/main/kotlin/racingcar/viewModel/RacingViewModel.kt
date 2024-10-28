package racingcar.viewModel

import racingcar.constans.Constants.SEPARATOR
import racingcar.delegate.ValidationDelegator
import racingcar.event.RacingViewEvent.InputPlayerName
import racingcar.event.RacingViewEvent.InputPlayCount
import racingcar.PlayGround
import racingcar.event.RacingViewEvent
import racingcar.model.CarRacingState.PlayerState
import racingcar.model.CarRacingState.PlayResultState

class RacingViewModel(
    private val validationDelegator: ValidationDelegator,
    private val playGround: PlayGround,
) {
    private val state = mutableListOf<PlayerState>()
    private var playCount: Int = 0

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
        readyForPlayers(separatedNames)
    }

    private fun onCompleteInputPlayCount(event: InputPlayCount) {
        val playCount = event.playCount
        validationDelegator.checkPlayCountIsValidNumeric(playCount)
        validationDelegator.handlePlayCountInput(playCount.toInt())
        readyForPlayCount(playCount.toInt())
    }

    fun playGame(): PlayResultState {
        return playGround.play(state, playCount)
    }

    private fun readyForPlayers(separatedNames: List<String>) {
        separatedNames.forEach { name ->
            state.add(PlayerState(playerName = name, position = 0))
        }
    }

    private fun readyForPlayCount(playCount: Int) {
        this.playCount = playCount
    }
}