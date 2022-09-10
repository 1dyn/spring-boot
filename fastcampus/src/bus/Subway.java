package bus;

public class Subway {
    int lineNumber;
    int money;
    int passengerCount;

    public Subway(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public void take(int money) {
        this.money += money;
        passengerCount++;
    }

    public void showSubwayInfo() {
        System.out.println(lineNumber + "호선의 승객 수는 " + passengerCount + "명이고, 수입은" + money + "원 입니다.");
    }
}
