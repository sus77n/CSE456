package edu.eiu;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import edu.eiu.entity.Student;
import edu.eiu.entity.Major;
import edu.eiu.entity.School;
import edu.eiu.service.StudentService;
import edu.eiu.service.MajorService;
import edu.eiu.service.SchoolService;
import java.time.LocalDate;

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
        SchoolService schoolService = new SchoolService();
        MajorService majorService = new MajorService();
        StudentService studentService = new StudentService();

        // Create School
        School school = new School("S01", "Engineering School", "Campus A");
        schoolService.createSchool(school);

        // Create Major
        Major major = new Major("M01", "Computer Science", school);
        majorService.createMajor(major);

        // Create Student
        Student student = new Student(1001, "Alice Smith", LocalDate.of(2002, 5, 15), 3.8, 2020, school, major);
        studentService.createStudent(student);

        // Update Student
        student.setGpa(3.9);
        studentService.updateStudent(student);

        // Find Student by ID
        Student foundStudent = studentService.getStudentById("1001");
        System.out.println("Found Student: " + foundStudent);

        // List all Students
        System.out.println("All Students: " + studentService.getAllStudents());


        // Delete Student
//        studentService.deleteStudent(student);

        // List all Students after deletion
        System.out.println("All Students after deletion: " + studentService.getAllStudents());
    }
}