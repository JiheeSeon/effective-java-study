package main.java.ch2.item3;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis(1);
    public final int number;

    private Elvis(int number){
        this.number = number;
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis1 :: I'm going out");
    }

    // 싱글턴임을 보장해주는 readResolve 메서드
    private Object readResolve() {
        return INSTANCE;
    }
}

enum ElvisEnum{
    INSTANCE;

    public void leaveTheBuilding() {
        System.out.println("Elvis1 :: I'm going out");
    }
}