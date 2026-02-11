public class ShapeAreaCalculator{

    // Method for square
    public int calculateArea(int side) {
        return side * side;
    }

    // Method for rectangle (overloaded)
    public double calculateArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        ShapeAreaCalculator calc = new ShapeAreaCalculator();

        int square = calc.calculateArea(5);        // sample value
        double rectangle = calc.calculateArea(4, 3); // sample value

        System.out.println("Area of Square: " + square);
        System.out.println("Area of Rectangle: " + rectangle);
    }
}