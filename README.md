# 로또
## 진행 방법
* 로또 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 코드 리뷰 요청을 한다.
* 코드 리뷰 피드백에 대한 개선 작업을 하고 다시 PUSH한다.
* 모든 피드백을 완료하면 다음 단계를 도전하고 앞의 과정을 반복한다.

## 기능 요구 사항
- [ ] 로또를 들고 있는 객체
- [ ] 로또 번호를 생성하는 객체
  - [ ] 로또는 6자리 숫자를 가지고 있다.
  - [ ] 자동	
    - [ ] shuffle로 로또 번호 자동 생성
      - [ ] 로또 번호는 중복될 수 없다.
    - [ ] 생성된 로또 번호를 오름차순으로 정렬
  - [ ] 수동
    - [ ] ...
  
- [ ] 당첨 번호
  - [ ] 당첨 번호를 가지고 있는 객체 필요 + 보너스볼
- [ ] 통계를 집행하는 객체 필요
- [ ] 입력
  - [ ] 로또 구입 금액 입력
    - [ ] 로또 번호는 중복될 수 없다.
  - [ ] 지난 주 당첨 번호 6자리를 를 입력
  - [ ] 보너스 볼 하나를 입력
- [ ] 출력
  - [ ] 구입한 로또 개수 출력
  - [ ] 구매 개수만큼 6자리 로또 번호 출력
  - [ ] n개 일치 (당첨 금액)- 개수
  - [ ] 수익률은 구입금액 대비 당첨금액을 출력



## 추가 요구 사항

- [ ] indent는 1까지 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] else를 쓰지 않는다.
- [ ] 모든 기능을 TDD로 구현해서 단위 테스트가 존재한다. UI로직은 제외한다.
  - [ ] 구현코드와 UI코드는 분리한다.
  - [ ] UI로직은 InputView와 ResultView로 분리
- [ ] 함수의 길이가 10라인을 넘어가지 않는다.
- [ ] 배열 대신 컬렉션을 사용한다.
- [ ] Java Enum을 적용한다.
- [ ] 모든 원시값과 문자열을 포장한다.
- [ ] 축약하지 않는다.
- [ ] 일급 컬렉션을 사용한다.



## 온라인 코드 리뷰 과정
* [텍스트와 이미지로 살펴보는 온라인 코드 리뷰 과정](https://github.com/next-step/nextstep-docs/tree/master/codereview)



## 문자열 덧셈 계산기

#### 기능 요구 사항

- 쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환 (e.g. "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6)
- 앞의 기본 구분자(쉼표, 콜론) 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 “//”와 “\n” 사이에 위치하는 문자를 커스텀 구분자로 사용한다. 예를 들어 “//;\n1;2;3”과 같이 값을 입력할 경우 커스텀 구분자는 세미콜론(;)이며, 결과 값은 6이 반환되어야 한다.
- 문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 `RuntimeException` 예외를 throw 한다.



#### 기능 구현 **목록**

- [ ] 사용자의 입력을 받는다.
- [x] 구분자를 기준으로 숫자를 분리한다.
- [x] 빈 문자열 또는 `null`을 입력할 경우 0을 반환해야 한다. (e.g. "" => 0, null => 0)
- [x] 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다. (e.g. "1")
- [x] 숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다. (e.g. "1,2")
- [x] 구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다. (e.g. "1,2:3" => 6)
- [x] "//"와 "\n" 문자 사이에 커스텀 구분자를 지정할 수 있다. (e.g. "//;\n1;2;3" => 6)
- [x] 음수를 전달할 경우 RuntimeException 예외가 발생해야 한다. (e.g. "-1,2,3")



## [step1] 로또(자동)

#### 기능 요구 사항

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.

- 로또 1장의 가격은 1000원이다.

- 실행 결과 예시

  ```bash
  구입금액을 입력해 주세요.
  14000
  14개를 구매했습니다.
  [8, 21, 23, 41, 42, 43]
  [3, 5, 11, 16, 32, 38]
  [7, 11, 16, 35, 36, 44]
  [1, 8, 11, 31, 41, 42]
  [13, 14, 16, 38, 42, 45]
  [7, 11, 30, 40, 42, 43]
  [2, 13, 22, 32, 38, 45]
  [23, 25, 33, 36, 39, 41]
  [1, 3, 5, 14, 22, 45]
  [5, 9, 38, 41, 43, 44]
  [2, 8, 9, 18, 19, 21]
  [13, 14, 18, 21, 23, 35]
  [17, 21, 29, 37, 42, 45]
  [3, 8, 27, 30, 35, 44]
  
  지난 주 당첨 번호를 입력해 주세요.
  1, 2, 3, 4, 5, 6
  보너스 볼을 입력해 주세요.
  7
  
  당첨 통계
  ---------
  3개 일치 (5000원)- 1개
  4개 일치 (50000원)- 0개
  5개 일치 (1500000원)- 0개
  5개 일치, 보너스 볼 일치(30000000원) - 0개
  6개 일치 (2000000000원)- 0개
  총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
  ```

  



#### 기능 구현 목록

- [view] UI 로직

  - [ ] [InputView] 사용자의 입력을 받는다.
    - [ ] 구입금액 입력
    - [ ] 지난 주 당첨 번호 입력
    - [ ] 보너스 볼 입력

  - [ ] [ResultView] 결과를 출력한다.
    - [ ] 구입한 로또 개수 출력
    - [ ] 구입한 로또 번호 배열로 출력
    - [ ] 당첨 통계 출력

- [domain] 비즈니스 로직
  - [ ] [Lotto] 로또 단일 객체
    - [ ] 6개의 숫자를 가진 배열 생성
      - 숫자 범위는 1~45이다.
      - 중복되지 않은 숫자여야 한다.
      - 오름차순으로 정렬해야 한다.
  - [ ] [Lottos] 구입한 로또 전체 관리
  - [ ] [] 당첨 결과 집계









