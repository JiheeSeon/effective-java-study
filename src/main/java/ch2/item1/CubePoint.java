package main.java.ch2.item1;

public class CubePoint implements Point {
    private int y = 0;
    private int x = 0;
    private int z = 0;
    private static final CubePoint cubeCenter = new CubePoint(0, 0, 0);

    private CubePoint(int y, int x, int z) {
        this.y = y;
        this.x = x;
        this.z = z;
    }

    @Override
    public String toString() {
        return "this point's y : " + y + " and x : " + x + " and z : " + z + " ";
    }

    public static Point valueOf(int y, int x, int z) {
        return x == 0 && y == 0 && z == 0 ?  cubeCenter:  new CubePoint(y, x, z);
    }

    @Override
    public double average() { return (x + y + z) / 3.0;}
}