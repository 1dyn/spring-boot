package bus;

public class TakeTransTest {

    public static void main(String[] args) {
        Student studentJ = new Student("James", 5000);
        Student studentT = new Student("Tomas", 10000);

        Bus bus77 = new Bus(77);
        Bus bus10 = new Bus(10);

        studentJ.takeBus(bus77);

        Subway greenSubway = new Subway(2);
        studentT.takeSubway(greenSubway);

        studentJ.showInfo();
        studentT.showInfo();

        bus77.showBusInfo();
        greenSubway.showSubwayInfo();
    }

}
