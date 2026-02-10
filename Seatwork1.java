mport java.util.Scanner;

public class Seatwork_1sem2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("How many grades (1 to 5)? ");
        int count = input.nextInt();

        double total = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = input.nextDouble();
            total += grade;
        }

        double average = total / count;
        System.out.println("Average: " + average);

        char letter;
        if (average >= 90) {
            letter = 'A';
        } else if (average >= 80) {
            letter = 'B';
        } else if (average >= 70) {
            letter = 'C';
        } else if (average >= 60) {
            letter = 'D';
        } else {
            letter = 'F';
        }

        System.out.println("Letter grade: " + letter);

        input.close();
    }
}
