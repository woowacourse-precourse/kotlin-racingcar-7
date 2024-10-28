# kotlin-racingcar-precourse

---

## 목표

- 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
- 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
- [1주 차 공통 피드백](https://docs.google.com/document/d/1VhEvU7rqzhlfTglVtp1wMr2j1hGtC0UZaZGTfWul29E/edit?tab=t.0)을 최대한 반영한다.


## 기능 요구 사항

#### 초간단 자동차 경주 게임을 구현한다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 기능 목록

---
#### 1. 실행 (`Application.kt, Race`)

- 시작

#### 2. 자동차 이름 입력 (`InputCarName`)

- 쉼표(,) 기준으로 이름을 구분하여 입력
- `Console` API 사용

#### 3. 자동차 이름 입력 오류 처리 (`CarNameValidation, InvalidCarNAmeException`)

- 오류시 `IllegalArgumentException`발생
- 오류조건
  - 미입력
  - 공백만 입력 (예: "   ")
  - 구분자만 입력 (예: ",")
  - 구분자 연속 입력 (예: "kim,,,lee,park")
  - 처음 또는 마지막에 구분자 입력 (예: ",kim,lee,park")
  - 이름이 공백 (예: " ,  ,  ")
  - 이름 5자 초과
  - 구분자 미입력 또는 이름 1개 입력 (예: "kim", "kim,")

#### 4. 이동 횟수 입력 (`InputCount`)

- 시도할 횟수(숫자) 입력
- `Console` API 사용

#### 5. 이동 횟수 입력 오류 처리 (`CountValidation, InvalidCountException`)

- 오류시 `IllegalArgumentException`발생
- 오류조건
  - 미입력
  - 0만 입력 (예: "0", "000")
  - 숫자아닌 문자 입력

#### 6. 자동차와 포인트(점수)를 결합하여 관리 (`CarWithPoints, CarNameSplitter, CarData`)

  - `CarData` 클래스 형태로 관리

#### 7. 무작위 값 추출 및 전진여부 결정 (`RandomNumberGenerator, ForwardStep`)

- 무작위 값이 4 이상이면 전진
- `Randoms` API 사용

#### 8. 경주시작 (`RaceStart`)

- 자동차마다 무작위 값에 따라 전진
- 전진시 (`-`) 출력

#### 9. 횟수 반복 (`RaceStart`)

- 입력한 횟수만큼 진행상황 출력

#### 10. 우승자 선정 (`WinnerSelector`)

- 자동차 별로 전진횟수 확인하여 최다 전진 차량을 (공동)우승자 선정

#### 11. 우승자 출력 (`OutputWinner`)

- (공동)우승자 출력 후 종료

#### 기타사항
- 이름이 같아도 입력순서가 달라 구분할수 있기에 중복을 허용한다.
- 이름에 특수문자,숫자 등을 허용한다.
- Int형 양수 범위(1 ~ 2,147,483,647)내로 이동횟수 입력이 가능하며 제한두지 않았다.
- 그밖에 사용된 클래스
    - `SettingValue` : 필요한 고정값 및 문자열 목록
    - `Other` : 사용자에게 보이는 문자열 목록