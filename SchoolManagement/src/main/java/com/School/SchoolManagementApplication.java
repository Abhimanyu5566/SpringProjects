package com.School;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.School.Entity.Student;
import com.School.Repositroy.StudentRepository;

@SpringBootApplication
public class SchoolManagementApplication {
	
	

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SchoolManagementApplication.class, args);
		StudentRepository studentRepository = context.getBean(StudentRepository.class);
		
		System.out.println("Welcome to School Management simple Spring project");
		
		
		while (true) {
			
			System.out.println("press 1 to adding Student");
			System.out.println("press 2 to Finding Student");
			System.out.println("press 3 to Update Student");
			System.out.println("press 4 to Delete Student");
			System.out.println("press 5 to Find  all Students");
			
			Scanner scanner = new Scanner(System.in); 
			System.out.print("please enter given Option :- ");
			int op = scanner.nextInt();
			
			if (op <=5) {
				
				if (op==1) {
					
					System.out.println("adding Student");
					
					System.out.print("Enter Student Roll No :- ");
					int roll = scanner.nextInt();
					System.out.print("Enter Student Name :-");
					String name = scanner.next();
					System.out.print("Enter Student Standard :-");
					String std = scanner.next();
					
					addStudent(studentRepository,name, std, roll);
					
				}if (op == 2) {
					System.out.println("Find Student");
					System.out.println("Enter Student Roll no :- ");
					int rollNo = scanner.nextInt();
					retrieveStudent(studentRepository, rollNo);
					
					
				}if (op == 3) {
					
					System.out.println("Update Student");
					
					System.out.print("Enter Student Roll No :- ");
					int roll = scanner.nextInt();
					System.out.print("Enter Student Name :-");
					String name = scanner.next();
					System.out.print("Enter Student Standard :-");
					String std = scanner.next();
					
					updataStudent(studentRepository, roll, name, std);
					
				}if (op == 4) {
					System.out.println("Delete Student");
					System.out.println("Enter Student Roll no :- ");
					int rollNo = scanner.nextInt();
					retrieveStudent(studentRepository, rollNo);
					System.out.println("If you want Delete press 1 and if not 0");
					int check = scanner.nextInt();
					if (check <= 1 ) {
						
						if (check ==1) {
							
							deletingStudent(studentRepository, rollNo);
						}
					}else {
						System.out.println("Enter 1 only");
						break;
					}
					
					
					
				}if (op == 5) {
					System.out.println("List of  Students");
					retrieveAllStudent(studentRepository);
				}
				
			}else {
				System.out.println("Invaild entry");	
			}
			//break;
			
		}
		
//		addStudent(studentRepository, "Abhimanyu", "Ty BSc", 1);
//		addStudent(studentRepository, "Amit", "Ty BSc", 2);
//		retrieveStudent(studentRepository, 1);
//		retrieveAllStudent(studentRepository);
//		updataStudent(studentRepository, 13, "Sumit", "Sy BSc");
//		deletingStudent(studentRepository, 2);
		
		
		
		
			
	}
	
	public static void addStudent(StudentRepository studentRepository, String name, String std, int rollNo) {
		try {
			
			Student student = new Student();
			student.setStudentName(name);
			student.setStandard(std);
			student.setRollNo(rollNo);
			
			studentRepository.save(student);
			
		} catch (Exception e) {
		
			e.getStackTrace();
		
		}
		
	}

	public static void retrieveStudent( StudentRepository studentRepository, int rollNo) {
		
		Student students = studentRepository.findByRollNo(rollNo);
		if (students != null) {
			
			Optional<Student> retrieveStudent = studentRepository.findById(students.getStudentId());
			
			if (retrieveStudent != null) {
				
				Student printStudent = retrieveStudent.get();
				
				System.out.println("Student Id       :- "+printStudent.getStudentId());
				System.out.println("Student Name     :- "+printStudent.getStudentName());
				System.out.println("Student Roll no  :- "+printStudent.getRollNo());
				System.out.println("Student Standard :- "+printStudent.getStandard());
				
			} 
			
		}else {
			System.out.println("Entered Student Id is Not Found! "+ rollNo);
		}

	}

	public static void retrieveAllStudent(StudentRepository studentRepository) {
		
		List<Student> allStudents = studentRepository.findAll();
		
		for(Student student: allStudents) {
			System.out.println(allStudents);
		}
		
		
	}

	public static void updataStudent(StudentRepository studentRepository, int rollNo, String name, String std) {
		Student students = studentRepository.findByRollNo(rollNo);
		if (students != null) {
			
			Optional<Student> retrieveStudent = studentRepository.findById(students.getStudentId());
			
			if (retrieveStudent != null) {
				
				Student printStudent = retrieveStudent.get();
				
				printStudent.setRollNo(rollNo);
				printStudent.setStandard(std);
				printStudent.setStudentName(name);
				studentRepository.save(printStudent);
				
				System.out.println("Student Data has been update Successfully");
				
			}
			
		}else {
			System.out.println("Entered Student Id is Not Found! "+ rollNo);
		}
		
	}

	public static void deletingStudent(StudentRepository studentRepository, int rollNo) {
		Student students = studentRepository.findByRollNo(rollNo);
		if (students != null) {
			
			Optional<Student> studentDelete = studentRepository.findById(students.getStudentId());
			if (studentDelete.isPresent()) {
				
				Student st = studentDelete.get();
				
				studentRepository.deleteById(st.getStudentId());
				
				System.out.println("Student information deleted");
				
			}
			
		}else {
			System.out.println("Entered Student Id is Not Found! "+ rollNo);
		}
		
	}
}
