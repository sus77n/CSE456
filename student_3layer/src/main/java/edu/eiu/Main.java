package edu.eiu;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import edu.eiu.entity.Student;
import edu.eiu.service.StudentService;

/**
 * Main's mission:
 * <ol>
 *      <li>Declare real data, create student, let the service validate and save to DB</li>
 *      <li>Ask the service to retrieve information and display it to the console.</li>
 *      <li>Directly use the classes of the service</li>
 *  </ol>
 */
public class Main {
    public static void main(String[] args) {
        var std1 = new Student("2025071401", "Nguyen Van A", 2005, 8.5);
        var std2 = new Student("2025071402", "Nguyen Van B", 2005, 9.0);
        var std3 = new Student("2025071403", "Nguyen Van C", 2005, 7.5);
        //TIP Call service methods to save students
        var studentService = new StudentService();
        studentService.createStudent(std1);
        studentService.createStudent(std2);
        studentService.createStudent(std3);

        //TIP Retrieve and display all students
        System.out.println("List of students:");
        studentService.getAllStudents().forEach(System.out::println);

        //TIP Edit a student
        std1.setGpa(8.2);
        studentService.updateStudent(std1);
        System.out.println("After updating student 1: " + studentService.getStudentById(std1.getId()));

        var std4 = new Student("2025071404", "Nguyen Van D", 2005, 8.0);
        studentService.updateStudent(std4);
    }
}