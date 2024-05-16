package ch07_OOP2;

// 추상클래스란 미완성 설계도이다. 미완성 메서드를 갖고 있으면 미완성 설계도이다. (필드와는 상관 없고, 메서드랑 관련 있음)
// 추상 메서드는 다음과 같은 상황에 만든다 :
// 1) 자기 자신의 클래스 인스턴스는 만들 필요 없다.
// 2) 자손 클래스에서 꼭 필요할 때
// 3) 자손 클래스마다 다르게 구현될 것으로 예상될 때

// 추상 메서드는 구현부 { }를 작성하지 않고, 추상 메서드를 상속한 자손 클래스에서 오버라이딩 받아서 구현부를 작성한다.
// 추상 메서드의 장점은 무엇일까? 구체화된 코드보다 유연하다는 장점이 있다. 즉, 변경에 유리하다.

abstract class Player {
    boolean pause;          // 일시정지 여부
    int currentPos = 0;     // 현재 재생위치

    abstract void play(int pos);
    // 자손 클래스에서 지정된 위치에서 재생을 시작하는 기능을 구현하게 될 추상 메서드

    abstract void stop();
    // 자손 클래스에서 재생을 멈추는 기능을 구현하게 될 추상 메서드

    Player() {
        pause = false;      // 초기화 값: false - 재생
        currentPos = 0;     // 초기화 값: 0 - 처음 위치 0
    }
    // 이 생성자는 Player 객체를 만들기 위한 목적은 아니고, 상속 받은 클래스에서 호출할 super() 를 정의하기 위해 적은 것이다.
    // 추상 클래스이기 때문에 사실 객체를 만들 수도 없다.
}

// 추상 클래스의 존재 목적은 "다른 클래스를 작성하는 데에 도움을 주기 위한 것"이다.
// 자기 자신의 객체를 만들기 위함이 아니다. 만들 수도 없다.
// 다만 추상 클래스는 참조변수의 타입으로 사용될 수는 있다. 그렇기 때문에 추상 클래스는 상속이 되어야만 제 역할을 하게 된다.



class AudioPlayer extends Player {
    @Override
    void play(int pos) {
        if(pos < 0 || pos > 100) {
            System.out.println("올바르지 않은 재생위치입니다.");
        } else {
            this.pause = false;
            System.out.println(pos + " 위치부터 play 합니다.");
        }
    }
    @Override
    void stop() {
        this.pause = true;
        System.out.println("AudioPlayer 의 작동을 중지합니다.");
    }

/*  public AudioPlayer() { super(); }  */  // 생략 가능
}
// 만약 자손 클래스인 AudioPlayer 가 play()와 stop() 메서드를 구현시켜놓지 않는다면 컴파일 에러가 발생한다.
// 추상 메서드를 가진 추상 클래스를 상속 받게 되면 추상 메서드를 반드시 구현하도록 강제받기 때문이다.




// 추상클래스를 그러면 어떻게 만들까? 물론 간단한 상황이라면 곧바로 작성이 가능하겠지만
// 상황이 복잡하면 기존 클래스들을 살펴 봐야 한다. 기존 클래스들을 살펴보고 공통부분을 뽑아서 추상 메서드를 뽑아내고,
// 그 추상 메서드를 포함시키는 추상 클래스를 만드는 것이다.
// 아래 코드들을 살펴보고, 공통적으로 묶을 만한 메서드가 무엇이 있는지 살펴보자.

  class Marine1 {
      int x, y;
      void move (int x, int y) {
          this.x = x;
          this.y = y;
          // 지상유닛이므로 지형의 제한을 받음
      }

      void stop() {
          // 위치를 정지시키는 코드
      }

      void stimPack() {
          System.out.println("스팀팩 사용");
          // 각종 효과 상승 코드
      }
  }

  class Tank1 {
      int x, y;
      void move (int x, int y) {
          this.x = x;
          this.y = y;
          // 지상유닛이므로 지형의 제한을 받음
      }
      void stop() {
          // 위치를 정지시키는 코드
      }
      void changeMode() {
          System.out.println("모드 변경");
      }
  }

  class DropShip1 {
      int x, y;
      void move (int x, int y) {
          this.x = x;
          this.y = y;
          // 공중유닛이므로 지형 제한이 없음
      }
      void stop() {
          // 위치를 정지시키는 코드
      }
      void load() {
          System.out.println("탑승");
          // 탑승 구현 코드
      }
      void unload() {
          System.out.println("하차");
          // 하차 구현 코드
      }
  }

// 위 세 가지 클래스들을 살펴보면 알겠지만 위치 필드값, stop()의 경우 완전히 같기 때문에 공통 조상 클래스를 만들어서 물려받으면 된다.
// 그런데 move()를 보니 세 클래스 모두 필요하고 담당하는 기능이 비스샇여 메서드명도 모두 같게 하면 될 것 같은데 완전하게 기능이 같지는 않다.
// 이런 상황에서는 아래와 같이 공통 조상 클래스에서 move() 메서드를 추상 메서드로 선언하는 것이 바람직하다 :

abstract class Unit {
    int x, y;
    int hp;
    float speed;
    int power;
    int armour;
    float attackPeriod;
    boolean attackable;
    boolean isAlive;

    void stop() {
        // 위치를 정지시키는 코드
    }
    abstract void move(int x, int y);

    void die() {
        System.out.println(this.toString() + " 유닛이 제거되었습니다.");
        this.hp = 0;
        this.x = -1;
        this.y = -1;
        this.speed = 0;
        this.power = 0;
        int amour = 0;
        this.attackable = false;
        this.isAlive = false;
    }

    public Unit(int hp, float speed, int power, int amour, float attackPeriod, boolean attackable) {
        this.hp = hp;
        this.speed = speed;
        this.power = power;
        this.armour = amour;
        this.attackPeriod = attackPeriod;
        this.attackable = attackable;
        this.isAlive = true;
    }
}

class Marine extends Unit {
    @Override
    void move(int x, int y) {
        this.x = x;
        this.y = y;
        // 지상유닛이므로 지형의 제한을 받도록 구현하는 내용 생략
        System.out.println("Marine" + " (" + x + ", " + y + ") 위치로 달려갑니다.");
    }
    void stimPack() {
        System.out.println("스팀팩 사용! 3초간 이동속도와 공격주기가 빨라집니다.");
        speed = 2.8125f;
        attackPeriod = 7.5f;
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        speed = 1.875f;
        attackPeriod = 15;
        System.out.println("스팀팩 지속시간이 끝났습니다. 이동속도와 공격주기가 원래 상태로 되돌아옵니다.");
    }

    public Marine() {
        super(40, 1.875f, 6, 0, 15, true);
        System.out.println("Marine : \"You wanna piece of me, boy?\"");
    }
}

class Tank extends Unit {
    String mode;
    boolean movable;
    float attackArrange;

    @Override
    void move (int x, int y) {
        if(movable == true) {
            this.x = x;
            this.y = y;
            // 지상유닛이므로 지형의 제한을 받도록 구현하는 내용 생략
            System.out.println("Tank" + " (" + x + ", " + y + ") 위치로 굴러갑니다.");
        } else {
            System.out.println("공성모드입니다. 전차모드로 모드 변경을 한 후 이동명령을 내리세요.");
        }
    }
    void changeMode() {
        if(this.mode.equals("전차모드")) {
            this.mode = "공성모드";
            this.attackArrange = 12;
            this.power = 70;
            this.attackPeriod = 75;
            this.movable = false;
            System.out.println("공성모드로 변환합니다. 공격 사거리 증가, 공격력 증가, 공격 주기 증가. 위치를 고정합니다.");
        } else if (this.mode.equals("공성모드")) {
            this.mode = "전차모드";
            this.attackArrange = 7;
            this.power = 30;
            this.attackPeriod = 37;
            this.movable = true;
            System.out.println("전차모드로 변환합니다. 공격 사거리 감소, 공격력 감소, 공격 주기 감소. 이동할 수 있습니다.");
        }
    }

    public String toString() {
        return "Tank";
    }
    public Tank() {
        super(150, 1.875f, 30, 1, 37, true);
        this.mode = "전차모드";
        this.attackArrange = 7;
        this.movable = true;
        System.out.println("Tank : \"Ready to roll out!\"");
    }
}

class DropShip extends Unit {
    @Override
    void move (int x, int y) {
        this.x = x;
        this.y = y;
        // 공중유닛이므로 지형 제한이 없음
        System.out.println("DropShip" + " (" + x + ", " + y + ") 위치로 항해합니다.");
    }
    void load() {
        System.out.println("탑승");
        // 탑승 구현 코드
    }
    void unload() {
        System.out.println("하차");
        // 하차 구현 코드
    }

    public DropShip() {
        super(150, 2.563f, 0, 1, 0, false);
        System.out.println("DropShip : \"Can I take your order?\"");
    }
}

// 이렇게 공통적인 기능이나 특성(필드)를 살펴보고 추상클래스를 구현시키면 코드의 중복을 없앨 수 있게 되고, 유지보수도 더 간편해진다.

public class _14_AbstractClass {
    public static void main(String[] args) {
        Player p1 = new AudioPlayer();
        AudioPlayer p2 = new AudioPlayer();
        // 비록 Player 가 abstract class 이긴 하지만 참조변수 타입으로는 사용될 수 있다.
        // 버튼이 제한되어 있긴 하지만 Player 추상 클래스가 갖고 있는 멤버에 한하여는 AudioPlayer 객체에 접근할 수 있다.

        System.out.println("ㅡㅡㅡㅡㅡ조상 타입의 참조변수를 통한 호출ㅡㅡㅡㅡㅡ");
        p1.play(102);
        p1.stop();
        p1.play(50);
        p1.play(2);

        System.out.println("ㅡㅡㅡㅡㅡ자손 타입의 참조변수를 통한 호출ㅡㅡㅡㅡㅡ");
        p2.play(105);
        p2.stop();
        p2.play(42);
        p2.stop();
        p1.play(80);

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        Unit[] group1 = new Unit[3];
        group1[0] = new Marine();       // Marine : "You wanna piece of me, boy?"
        group1[1] = new Tank();         // Tank : "Ready to roll out!"
        group1[2] = new DropShip();     // DropShip : "Can I take your order?"

        Unit[] group2 = { new Marine(), new Marine(), new Tank() };
        // Marine : "You wanna piece of me, boy?"
        // Marine : "You wanna piece of me, boy?"
        // Tank : "Ready to roll out!"

        System.out.println("group1 이동 명령 : x-100, y-100 위치로 이동");
        for (int i = 0; i < group1.length; i++) {
            group1[i].move(100, 100);      // 세 유닛 모두 (100, 100) 위치로 move 명령
            // Marine (100, 100) 위치로 달려갑니다.
            // Tank (100, 100) 위치로 굴러갑니다.
            // DropShip (100, 100) 위치로 항해합니다.
        }


        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");

        System.out.println("group2 이동 명령 : x-40, y-59 위치로 이동");
        for (int i = 0; i < group2.length; i++) {
            group2[i].move(40, 59);        // 세 유닛 모두 (40, 59) 위치로 move 명령
            // Marine (40, 59) 위치로 달려갑니다.
            // Marine (40, 59) 위치로 달려갑니다.
            // Tank (40, 59) 위치로 굴러갑니다.
        }


        if (group1[0] instanceof Marine) {
            Marine marine = (Marine)group1[0];
            marine.stimPack();
            // 스팀팩 사용! 3초간 이동속도와 공격주기가 빨라집니다.
            // (3초 후)
            // 스팀팩 지속시간이 끝났습니다. 이동속도와 공격주기가 원래 상태로 되돌아옵니다.
        }

        if (group1[1] instanceof Tank) {
            Tank tank = (Tank) group1[1];
            tank.changeMode();          // 공성모드로 변환합니다. 공격 사거리 증가, 공격력 증가, 공격 주기 증가. 위치를 고정합니다.
            tank.move(60, 100);   // 공성모드입니다. 전차모드로 모드 변경을 한 후 이동명령을 내리세요.
            tank.changeMode();          // 전차모드로 변환합니다. 공격 사거리 감소, 공격력 감소, 공격 주기 감소. 이동할 수 있습니다.
            tank.move(60, 100);   // Tank (60, 100) 위치로 굴러갑니다.
            tank.changeMode();          // 공성모드로 변환합니다. 공격 사거리 증가, 공격력 증가, 공격 주기 증가. 위치를 고정합니다.
            tank.changeMode();          // 전차모드로 변환합니다. 공격 사거리 감소, 공격력 감소, 공격 주기 감소. 이동할 수 있습니다.
            tank.changeMode();          // 공성모드로 변환합니다. 공격 사거리 증가, 공격력 증가, 공격 주기 증가. 위치를 고정합니다.
        }

        if (group1[2] instanceof DropShip) {
            DropShip dropShip = (DropShip) group1[2];
            dropShip.load();    // 탑승
            dropShip.unload();  // 하차
        }
    }
}

