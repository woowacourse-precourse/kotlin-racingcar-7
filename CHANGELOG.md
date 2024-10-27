#### 2024-10-27

##### Documentation Changes

* **CHANGELOG:**  CHANGELOG 갱신 (71ef3e7c)
* **README:**
  *  프로그래밍 요구사항 확인 (47764940)
  *  요구 사항 및 기능 정의 (a3a8d48a)

##### New Features

* **RacingGameValidator:**  자동차 경주에 대한 유효성 검사 구현 (3916977a)
* **Application:**  RacingGameController 객체 생성 (bb8cf54f)
* **RacingGameController:**  RacingGameController 클래스 구현 (cf26c00d)
* **RacingGame:**
  *  우승자 리스트 조회하는 기능 구현 (b670be7a)
  *  자동차 경주 게임 모델 구현 (d67c69d4)
* **README:**  요구 사항 및 기능 정의 수정 (2b9dd61c)
* **RacingCar:**  자동차 모델 구현 (8cc30790)
* **OutputView:**
  *  경주 우승자 출력 기능 구현 (4049586c)
  *  경주 진행사항 출력 기능 구현 (656c8ae8)
* **InputView:**
  *  시도 횟수를 입력받고 유효성 검사하는 기능 구현 (e8247b0f)
  *  자동차 이름을 입력받고 유효성 검사하는 기능 구현 (43c8b8b5)
*  setup project (60e3e52e)

##### Bug Fixes

* **InputView:**  시도 횟수 유효성 검사 시 0미만을 0이하로 수정 (bc0ec2e3)
* **OutputView:**  경주 진행사항 출력 시 줄넘김 수정 (0f9966e5)

##### Refactors

* **Global:**  문자열 상수를 정의하여 코드에서 사용하도록 변경 (45371436)
* **InputView:**
  *  유효성 검사 로직을 Controller로 이동 (9b25f2e7)
  *  입력된 각 자동차 이름의 양쪽 공백 제거 로직 추가 (6a7d86ce)

##### Tests

* **ApplicationTest:**  ApplicationTest 작성 (63837703)
* **RacingGameTest:**  TryMove 기능 테스트 코드 추가 (54b6347d)