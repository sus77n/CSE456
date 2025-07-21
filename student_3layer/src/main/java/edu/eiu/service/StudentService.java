package edu.eiu.service;

import edu.eiu.entity.Student;
import edu.eiu.reposibility.StudentRepo;

import java.util.List;

/**
 * Responsibilities of the service class:
 * <ol>
 *     <li>Acts as an intermediary to receive data from the UI, validate, process, and pass it to the repository</li>
 *     <li>Receives data from the repository and sends it to the UI for user display</li>
 * </ol>
 * Directly uses the repository class.
 * Methods closely related to the user should be named clearly and understandably. Typical methods include:
 * <ol>
 *     <li>Create a new student: createStudent()</li>
 *     <li>Update student information: updateStudent()</li>
 *     <li>Get student information: getStudentById(), getAllStudent(), ...</li>
 *     <li>Delete a student: deleteStudentById(), deleteStudent()</li>
 * </ol>
 */
public class StudentService {
    /**
     * Create a new student.
     */
    public void createStudent(Student student) {
        //TIP Validate the student object before saving
        StudentRepo.save(student);
    }

    /**
     * Update an existing student's information.
     */
    public void updateStudent(Student student) {
        //TIP Validate the student object before updating
        StudentRepo.update(student);
    }

    /**
     * Delete a student.
     */
    public void deleteStudent(Student student) {
        //TIP Validate the student object before deleting
//        StudentRepo.remove(student);
        StudentRepo.removeById(student.getStudentId());
    }

    /**
     * Get a student by ID.
     */
    public Student getStudentById(String studentId) {
        //TIP Validate the studentId before fetching
        return StudentRepo.findById(studentId);
    }

    public List<Student> getAllStudents() {
        //TIP Fetch all students from the repository
        return StudentRepo.findAll();
    }

    /**
     * Find students by name.
     */
    public List<Student> findStudentsByName(String name) {
        //TIP Validate the name before searching
        return StudentRepo.findByName(name);
    }

}
