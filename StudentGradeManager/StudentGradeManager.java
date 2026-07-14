
package com.sajnu.miniprojects.studentgrade;

import java.util.Scanner;

/**
 * Manages student records and allows users to
 * search for students by roll number.
 */
public class StudentGradeManager {

    static Student[] students;

    public static void main(String[] args) {
        int studentNo;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("******WELCOME TO STUDENT GRADE MANAGEMENT SYSTEM******");
            System.out.print("Enter the number of students you want to enroll: ");
            studentNo = scanner.nextInt();
            scanner.nextLine();
            if (studentNo > 0) {
                students = new Student[studentNo];
                for (int i = 0; i < studentNo; i++) {
                    System.out.print("Enter student's name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student's roll number: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter student's mark: ");
                    double mark = scanner.nextDouble();
                    scanner.nextLine();
                    students[i]= new Student(name, rollNo, mark);
                }
            } else {
                System.out.println("Student Number can not be zero!");
            }
            int rollNo;
            do {
                System.out.println();
                System.out.println("***************************************");
                System.out.println("-------------STUDENTS DETAILS-------------");
                System.out.print("Enter the roll number of the student [Enter 0 to quit]: ");
                rollNo = scanner.nextInt();
                if (rollNo == 0) {
                    System.out.println("Quitting...");
                    break;
                }
                Student student = findStudentByRollNo(rollNo);
                if (student != null) {
                    System.out.println("---------------------------");
                    student.displayDetails();
                    System.out.println("---------------------------");
                } else {
                    System.out.println("Sorry! There is no record of the student with Roll Number " + rollNo);
                }
            } while (rollNo != 0);
        }
    }

    private static Student findStudentByRollNo(int rollNo) {

        for (Student student : students) {
            if (student.getRollNo() == rollNo) {
                return student;
            }
        }
        return null;
    }

}
