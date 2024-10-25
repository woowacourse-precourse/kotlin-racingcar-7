package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.entity.Car

class CarTest {

    lateinit var car: Car

    @Test
    fun `이동 성공 테스트`(){
        car = Car("white")
        car.tryMove(6)
        val expect = 1
        assertEquals(expect,car.position)
    }

    @Test
    fun `이동 실패 테스트`(){
        car = Car("white")
        car.tryMove(3)
        val expect = 0
        assertEquals(expect,car.position)
    }
}