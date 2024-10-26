package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.model.CarRacingState.PlayerState
import racingcar.reducer.PlayerStateReducer

class PlayerStateReducerTest {
    private lateinit var reducer: PlayerStateReducer

    @BeforeEach
    fun setUp() {
        reducer = PlayerStateReducer()
    }

    @Test
    fun `이동 가능할 때 상태 반환 테스트`() {
        // given
        val state = PlayerState("test", 0)
        val mutation = 5

        // when
        val reducedState = reducer(mutation, state)

        // then
        assertEquals(PlayerState(playerName = "test", position = 5), reducedState)
    }

    @Test
    fun `이동 불가능할 때 상태 반환 테스트`() {
        // given
        val state = PlayerState("test", 3)
        val mutation = 0

        // when
        val reducedState = reducer(mutation, state)

        // then
        assertEquals(PlayerState(playerName = "test", position = 3), reducedState)
    }
}