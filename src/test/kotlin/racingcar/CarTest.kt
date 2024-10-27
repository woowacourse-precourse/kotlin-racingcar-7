package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `자동차 이름과 초기 위치 설정 테스트`() {
        val car = Car("pobi")
        assertThat(car.name).isEqualTo("pobi")
        assertThat(car.getCurrentPosition()).isEqualTo(0)
    }

    @Test
    fun `자동차 전진 테스트`() {
        val car = Car("pobi")
        car.move()
        assertThat(car.getCurrentPosition()).isEqualTo(1)
    }

    @Test
    fun `자동차 여러 번 전진 테스트`() {
        val car = Car("pobi")
        car.move()
        car.move()
        car.move()
        assertThat(car.getCurrentPosition()).isEqualTo(3)
    }
}