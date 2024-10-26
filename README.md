# kotlin-racingcar-precourse

## 서비스 소개

여러 이름의 자동차와 진행할 라운드를 입력받아, 각 라운드마다 랜덤하게 전진하여 진행되는 자동차 경주 서비스입니다.

## 기능 요구 사항

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 생각해볼 것

### 1. 자동차 이름에 들어갈 수 없는 글자?

- 공백을 허용할 것인가?, 공백이 '5자'에 포함되는가?

공백은 허용하나, 이름의 앞, 뒤에는 허용하지 않는다. 그 이유는 다음과 같다.

1. 공백만으로 이루어진 자동차가 생길 수 있다.
2. 같은 이름으로 보이나, 맨 뒤에 공백이 존재하는 두 자동차가 생길 수 있다.
3. 쉼표를 이용해 구분한다는 요구사항이 있지만, 사람에 따라 쉼표 뒤에 띄어쓰기를 하는 경우를 배제하기 위함이다.

### 2. 경주 진행 과정을 어떻게  출력할 것인가?

1. 한 라운드에 대한 함수를 `ViewModel`에서 여러 번 수행

   여러 번 수행한 값을 계속해서 결과 `List`에 추가하고, 한 번에 출력

2. 경주에 대한 함수를 `ViewModel`에서 한 번 수행하고, 해당 함수 내에서 여러 번 라운드를 수행

   라운드 결과를 `List`로 반환

굳이 한 라운드의 결과를 알아야 할 필요는 없다. `ViewModel`이 궁금한 것은 경기 과정, 결과일 뿐이다.
또한, 결과는 `ViewModel` 내부에서 파악할 수도 있다.
결과를 데이터 모델로 받아, `View`에서 보여줄 데이터로 변환하는 과정을 `ViewModel`에 담자.

### 3. 입력값이 올바르지 않을 때, 어디에서 처리해야 하는가?

`View`를 말 그대로 보여주는 것에만 집중하면 `View`에서 처리하는 것이 올바르지 않다고 생각할 수 있다.
다만 나는 `View`는 보여주는 것만이 아니라, 사용자에게 보여지는 것으로 사용자와의 상호작용을 담당한다고 생각한다.

그러나 입력값이 비즈니스 로직과 연관된다면 문제가 달라진다고 생각한다. 그렇게 되면 **잘 변하지 않는 것**이 된다.
이 경우 `View`에 있으면 자주 변하는 `View`에 영향을 받을 가능성이 높다.

따라서 검증할 것이 무엇인가에 대해 달라질 것 같다.
만약 입력값의 글자 수나, 숫자인지 아닌지 등을 검증하는 것은 `View`에서 처리하고,
비즈니스와 연관된 로직이라면(중복 검사나, 숫자가 일정 값 이상이어야 하는 경우) `ViewModel`에서 처리하자.

이 경우, 빈 값이 아닌지 검증하거나, 숫자인지 검증하는 것은 `View`에서 처리하고,
_이름은 5자 이하만 가능하다._ 등의 비즈니스 관련 검증 로직은 `ViewModel`에서 처리하자.

## 설계

### 1. 경주할 자동차 이름을 입력받는다.

`View`의 책임

### 2. 입력받은 자동차의 이름이 적합한지 검증한다.

`StringValidator`의 책임

### 3. 자동차 이름을 저장한다.

`ViewModel`의 책임

### 4. 시도할 횟수를 입력받는다.

`View`의 책임

### 5. 입력받은 시도할 횟수가 적합한지 검증한다.

`StringValidator`의 책임

### 6. 횟수만큼 각 차가 전진하거나, 이동하지 않는다.

`Stadium`의 책임

### 7. 각 결과를 출력한다.

`View`의 책임

### 8. 최종 우승자를 출력한다.

`View`의 책임

## 학습 노트

