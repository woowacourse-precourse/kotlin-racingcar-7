# kotlin-racingcar-precourse

## 기능 요구 사항
초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.  
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.  
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.  
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.  
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.  
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.  
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.  
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.  

Flow  
- 자동차 이름 입력 -> 시도 횟수 입력 -> 시도 횟수 만큼 실행 결과 출력 -> 우승자 결정 및 우승자 출력

## 기능 목록
자동차
- 전진한다
- 움직일 수 있는지 판단한다
- 이름을 반환한다

레이싱 게임
- 레이싱 게임을 시작한다
- 라운드를 시작한다
- 라운드 결과를 보여준다
- 우승자를 보여준다

시도 횟수
- 숫자를 반환한다.

출력
- 새로운 라인을 추가한다
- 실행 결과 메세지를 출력한다
- 전진 자동차 출력 시 자동차 이름을 같이 출력한다
- 우승자를 출력한다

입력
- 자동차 이름을 입력한다
- 시도 횟수를 입력한다

숫자 생성기
- 숫자를 생성한다

RacingCarPresenter
- 자동차 객체를 생성한다
- 시도 횟수를 생성한다

RacingCarGameApp
- 자동차 경주 게임 애플리케이션을 실행한다