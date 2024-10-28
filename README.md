# kotlin-racingcar-precourse

## 기능 목록

### Car
- 숫자를 할당 받아 4이상일 경우 이동하여 포지션 상태를 1높인다.
- 할당 받은 수가 0~9사이가 아닐 경우 예외를 발생시킨다.
- 이름이 5보다 클 경우 예외를 발생시킨다.

### NumberGenerator
- NumbersGenerator
  - 생성자로 받은 숫자들을 실행할때마다 하나씩 반환한다
    - 랜덤 숫자는 테스트의 신뢰도가 매우 떨어지기 때문에 고정 값을 사용하기 위해 구현 
- RaceRandomGenerator
  - 레이스에서 발생하는 랜덤 숫자를 반환한다

### CreateCarsUseCase
- 입력 받은 문자열들을 구분자로 나눠서 자동차 객체를 만든다
- 자동차들 이름이 공백일 경우 순서데로 익명1,익명2 와 같은 이름으로 객체 생성한다.
- 자동차들 이름에 중복이 있을 경우 예외를 발생시킨다.

### GetWinnersUseCase
- 포지션이 제일 높은 우승자들을 반환한다.

### RacingCarController
- 자동차들이 랜덤 숫자를 받아서 이동을 시도한다.

### UserInput
- 사용자에게 이름을 일력 받는다
- 사용자에게 이동 횟수를 받는다
  - 숫자가 아닐 경우에 예외를 발생시킨다.

### ResultOutput
- 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다. 
  - 예시(blue : -)
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
  - 예시(blue)
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 출력한다.
  - 예시 (blue, red)

### GuideOutput
- 자동차들의 이름을 입력 받는 가이드 출력
- 시도 횟수를 입력 받는 가이드 출력
- 실행 결과를 안내하는 가이드 출력

### RacingCarService
전체 실행 흐름 구현
  - RacingInputView를 통해 입력 안내 및 자동차들 이름과 레이스 숫자 입력을 반환
  - CreateCarsUseCase를 통해 자동차들 이름으로 자동차들 객체 생성
  - 레이스 숫자가 1 보다 낮을 경우 예외 발생
  - PlayRaceUseCase를 레이스 숫자만큼 실행하면서 RacingResultView를 통해 각 자동차 위치 출력
  - GetWinnersUseCase를 통해 제일 많이 이동한 자동차들 이름을 반환하고 RacingResultView를 통해 결과 출력