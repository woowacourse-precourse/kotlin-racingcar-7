package racingcar

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.constans.PlayCountError.errorMessageForEmptyPlayCount
import racingcar.constans.PlayCountError.errorMessageForExceededMaxPlayCount
import racingcar.constans.PlayCountError.errorMessageForInValidPlayCount
import racingcar.constans.PlayCountError.errorMessageForInValidPlayCountByZero
import racingcar.delegate.playCount.PlayCountErrorDelegator
import racingcar.delegate.playCount.PlayCountErrorDelegatorImpl

class PlayCountErrorDelegatorImplTest {
    private lateinit var playCountErrorDelegator: PlayCountErrorDelegator

    @BeforeEach
    fun setUp(){
        playCountErrorDelegator = PlayCountErrorDelegatorImpl()
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "   ", "  "])
    fun `시도 횟수가 비어있을 때 예외 테스트`(input: String){

        // when
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkPlayCountIsEmpty(input)
        }

        // then
        assert(exception.message == errorMessageForEmptyPlayCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["21474052457483902574238570234857503750248574023570432578024574038583648"])
    fun `시도 횟수를 숫자로 변환할 수 없을 때 예외 테스트`(input: String) {
        val exception = assertThrows<IllegalArgumentException> {
            playCountErrorDelegator.checkForChangeableToLong(input)
        }
        assert(exception.message == errorMessageForExceededMaxPlayCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["dsa", "22e", "@##@", "ㄷ2ㄴ2ㅇ3"])
    fun `시도 횟수가 숫자가 아닐 때 예외 테스트`(input: String){
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkInvalidPlayCountFormat(input)
        }
        assert(exception.message == errorMessageForInValidPlayCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "-10000"])
    fun `시도 횟수가 음수일 때 예외 테스트`(){
        val input = "-1"
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkInvalidPlayCountRange(input)
        }
        assert(exception.message == errorMessageForInValidPlayCount)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1.0", "-0.1"])
    fun `시도 횟수가 실수일 때 예외 테스트`(input: String){
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkInvalidPlayCountRange(input)
        }
        assert(exception.message == errorMessageForInValidPlayCount)
    }

    @Test
    fun `시도 횟수가 0일 때 예외 테스트`(){
        val input = 0
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkInvalidPlayCountByZero(input)
        }
        assert(exception.message == errorMessageForInValidPlayCountByZero)
    }

    @Test
    fun `시도 횟수가 최대 횟수를 초과할 때 예외 테스트`(){
        val input = 10001
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkExceededMaxPlayCount(input)
        }
        assert(exception.message == errorMessageForExceededMaxPlayCount)
    }

    @Test
    fun `시도 횟수가 너무 커서 숫자로 처리할 수 없는 경우 예외 테스트`(){
        val input = Int.MAX_VALUE.toLong() + 1
        val exception = assertThrows<IllegalArgumentException>{
            playCountErrorDelegator.checkForExceededMaxInt(input)
        }
        assert(exception.message == errorMessageForExceededMaxPlayCount)
    }
}