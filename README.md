# 📝 기능 목록
#### 설명의 편의를 위해 RacingCarController는 Controller, RacingCarModel는 Model, RacingCarView는 View로 칭한다.

## RacingCarController

### Model과 View 사이에서 컨트롤러 역할

- View로부터 받아온 경주할 자동차의 이름을 Model에 반환
- Model로부터 매 차수마다 진행 사항(자동차 이름, 전진 횟수 쌍)을 전달받아 출력형식에 맞춰 적절히 변환 후 View를 통해 출력
- 경주가 끝나면 Controller에 저장된 진행 사항을 바탕으로, 최종 우승자를 View를 통해 출력

## RacingCarModel

- 입력받은 자동차 이름 문자열을 ','을 기준으로 분리해 각 이름을 저장하는 기능
  - 각 자동차마다 전진 횟수를 포함할 수 있도록 Map 사용
- 각 자동차마다 무작위 값(0~9)을 받아와 4이상일 경우 전진 횟수 1씩 증가
- 진행 사항(자동차 이름, 전진 횟수 쌍)을 Controller로 반환
- Controller로부터 결과 반환 요청이 들어오면 진행 사항을 토대로 최종 우승자를 Controller로 반환
- 첫번째 입력 예외 처리 (IllegalArgumentException)
    - 입력이 빈 경우
    - 이름이 알파벳이 아닌 경우
    - 이름이 비어있는 경우
    - 이름이 5글자가 넘어갈 경우
    - 이름이 중복되는 경우
- 두번째 입력 예외 처리 (IllegalArgumentException)
  - 숫자가 아닌 문자가 들어오는 경우
  - 1보다 크지 않을 경우
  - int 범위가 아닐 경우

## RacingCarView

- 입출력 기능
  - 경주할 자동차의 이름을 입력받는 기능
  - 시도 횟수를 입력받는 기능
  - 각 차수마다 진행 사항을 출력하는 기능
  - 결과를 출력하는 기능