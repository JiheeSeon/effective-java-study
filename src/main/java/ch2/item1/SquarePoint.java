package main.java.ch2.item1;

class SquarePoint implements Point {
    private int y = 0;
    private int x = 0;
    private static SquarePoint squareCenter = new SquarePoint(0, 0);

    private SquarePoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static SquarePoint valueOf(int y, int x) {
        return y == 0 && x == 0 ? squareCenter : new SquarePoint(y, x);
    }

    @Override
    public String toString() {
        return "this point's y : " + y + " and x : " + x;
    }
}
