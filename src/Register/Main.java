package Register;

import Validation.Information;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Information student = new Information();

        System.out.print("Enter first name: ");
        student.setFirstName(scanner.nextLine());

        System.out.print("Enter last name: ");
        student.setLastName(scanner.nextLine());

        System.out.print("Enter birthday (yyyy/MM/dd): ");
        student.setBirthday(scanner.nextLine());

        System.out.print("Enter course: ");
        student.setCourse(scanner.nextLine());

        System.out.print("Enter email: ");
        student.setEmail(scanner.nextLine());

        System.out.println(student.getStudentNumber());

        scanner.close();
    }
}