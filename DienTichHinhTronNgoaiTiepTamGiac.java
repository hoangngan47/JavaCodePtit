import java.util.*;

public class DienTichHinhTronNgoaiTiepTamGiac {
    static class Point {
        double x, y;
        public Point(double a, double b) {
            x = a;
            y = b;
        }
        static Point nextPoint(Scanner sc) {
            return new Point(sc.nextDouble(), sc.nextDouble());
        }
    }

    static double dis(Point a, Point b) {
        return Math.hypot(a.x - b.x, a.y - b.y); 
    }

    static class Triangle {
        double A, B, C;
        public Triangle(Point a, Point b, Point c) {
            A = dis(a, b);
            B = dis(b, c);
            C = dis(c, a);
        }
        public boolean valid() {
            return A + B > C && A + C > B && B + C > A;
        }
        public String getCircumcircleArea() {
            double p = (A + B + C) / 2;
            double area = Math.sqrt(p * (p - A) * (p - B) * (p - C)); // Heron
            double R = A * B * C / (4 * area);
            double circleArea = Math.PI * R * R;
            return String.format("%.3f", circleArea);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Triangle tri = new Triangle(
                Point.nextPoint(sc), 
                Point.nextPoint(sc), 
                Point.nextPoint(sc) );

            if (!tri.valid()) {
                System.out.println("INVALID");
            } else {
                System.out.println(tri.getCircumcircleArea());
            }
        }
    }
}
