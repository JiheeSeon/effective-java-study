package main.java.ch2.item1;

class Points {
    private Points() {
    }

    public static Point valueOf(int y, int x) {
        return SquarePoint.valueOf(y, x);
    }

    public static Point valueOf(int y, int x, int z) {
        return CubePoint.valueOf(y, x, z);
    }
}


