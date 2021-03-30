package main.java.ch2.item1;

class StaticMethodExample {
    public static void main(String[] args) {
        Point ex1 = Points.valueOf(2, 1);
        Point ex2 = Points.valueOf(3, 2, 5);
        Point ex3 = Points.valueOf(3, 2);
        // 주석처리한 부분 코드는 에러가 난다.
//         Point ex4 = new Point(3, 2);

        System.out.println(ex1);
        System.out.println(ex2);
        System.out.println(ex3);

        System.out.print("ex2 is instance of CubePoint : ");
        System.out.println(ex2 instanceof CubePoint);

        System.out.print("ex2 is instance of Point : ");
        System.out.println(ex2 instanceof Point);
    }
}