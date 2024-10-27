# kotlin-racingcar-precourse


# 기능 구현 목록

pobi,woni,jun

## View
- [x] getCarName
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능  
  - 잘못된 값을 입력할 경우 에러 발생
  - `경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)`

- [x] getNumberOfAttempts
  - 몇 번의 이동을 할 것인지를 입력
  - 잘못된 값을 입력할 경우 에러 발생
  - `시도할 횟수는 몇 회인가요?`

- [x] showRaceStart : `실행 결과` 출력

- [x] printRacingCar : 전진하는 자동차 출력
    - [x] `자동차 이름`도 같이 출력

- [x] showResult : 우승 차 출력 `최종 우승자 : ooo`
  - [x] 여러 명일 경우 쉼표를 이용해 구분

## Controler

- [x] run : input값을 받아서 아래의 함수들을 실행한 후 result를 view로 넘겨주는 역할

- [x] handleInput : input값을 받아서 generateCarList 후 error 처리하는 함수
  - [x] generateCarList
    - [x] car 객체 리스트를 만들고 초기화
  - [x] !예외처리
    - [x] 시도횟수가 0 이하인 경우
    - [x] 시도횟수가 숫자가 아닌 경우
    - [x] 차 이름의 길이가 5 초과인 경우
    - [x] 차 이름에 아무것도 없는 경우
    - [x] 콤마 사이에 공백이 들어있는 경우 - trim을 사용해 공백 없애기
  
- [x] simulateRace : 경주 시뮬레이션

- deleted(getRandomNumber : 0에서 9 사이에서 무작위 값을 구하기)

- [x] driveCar : 전진, 멈춤
  - [x] playRandom으로 구한 무작위 값이 4 이상일 경우

- [x] getWinner
  - [x] val winners: List<String>
  - [x] 각 자동차가 얼마나 나갔는지 비교하기

## Model
- [x] data class car
  - [x] val name
  - [x] var distanceCovered
- [x] data class CarList
  - [x] carList