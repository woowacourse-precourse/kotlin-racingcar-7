# kotlin-racingcar-precourse

---

## 구현할 기능 목록
- View
  - 입력(자동차, 시도 횟수)
  - 출력(상황, 결과)
- Controller
  - 문자열(자동차) 분리
  - 예외 처리
- Model
  - 랜덤 숫자 생성 : repeat(자동차 수)
  - 자동차 전진
  - 경주 상황 리턴
  - ~~경주 종료 판단~~
  - \+ 자동차 객체 생성
- Car(Name: String, Position: Int)
  - go 메소드
  - \+ 위치 반환

## 테스트
- ViewTest
  - 경주 상황 출력
  - maxPos인 우승자 출력
  - maxPos인 중복 우승자 출력
- ControllerTest
  - 0 이하 시도 횟수 예외 처리
- CarTest
  - 4 미만 난수 이동 체크
  - 4 이상 난수 이동 체크
