package main.java.ch2.item1;

class SquarePoint implements Point {
    private int y = 0;
    private int x = 0;
    private static final SquarePoint squareCenter = new SquarePoint(0, 0);

    private SquarePoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public static Point valueOf(int y, int x) {
        return x == 0 && y == 0 ? squareCenter : new SquarePoint(y, x);
    }

    @Override
    public String toString() {
        return "this point's y : " + y + " and x : " + x;
    }

    @Override
    public double average() { return (x + y) / 2.0; }
}
