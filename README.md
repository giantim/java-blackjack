# java-blackjack
블랙잭 게임 미션 저장소

## 우아한테크코스 코드리뷰
* [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

## 기능 요구사항
도메인
- 카드 객체 묶음(숫자 +  종류)
- 카드(숫자 원시값 포장)
- 카드의 종류를 담당하는 enum

- 딜러(Dealer): implements Player
    - 16을 기준으로 카드를 받을지 결정하는 메서드
- 유저(User): implements Player
    - 승 / 패
    - enum Y / N 을 기준으로 카드를 받을지 결정하는 메서드
    - 현재 받은 카드의 총 합이 21을 초과하는지 검사하는 메서드
    - 승 / 패 계산하는 메서드
- 플레이어(Player): interface
    - 카드묶음을 갖는다
    - 카드를 받는 기능
- Users: 게임에 참여한 사람의 이름으로 생성한 유저 일급 컬렉션

- 예 / 아니오 값을 갖는 enum
    - 입력한 값에 대해 유효성을 검사하는 메서드

- 카드계산 클래스
    - 플레이어의 카드 묶음을 받아서 총 합을 계산
- 승패계산 클래스
    - 21(블랙잭)인지 판단하는 메서드
    - 딜러와 유저의 승 / 패를 판단하는 메서드

DTO
- 게임에 참여할 사람의 이름을 담는 DTO
- 예 / 아니오를 담는 DTO
- 카드를 담고 있는 DTO
    - 카드묶음의 합도 포함
- 플레이어들의 상태 정보를 담는 DTO