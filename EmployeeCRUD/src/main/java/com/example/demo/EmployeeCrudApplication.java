package com.example.demo;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Employee;

@SpringBootApplication
public class EmployeeCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCrudApplication.class, args);

		int ch;
		int id;
		String name, dept;
		float salary;
		Scanner sc = new Scanner(System.in);
		var emp = new ArrayList<Employee>();

		while (true) {

			System.out.println("""
					1. Insert
					2. Dispay
					3. Update
					4. Delete
					5. Exit
					Enter A Choice :
					""");
			ch = sc.nextInt();
			switch (ch) {
			case 1 -> {
				System.out.println("Enter A Id :");
				id = sc.nextInt();
				System.out.println("Enter A Name :");
				name = sc.next();
				System.out.println("Enter A Department :");
				dept = sc.next();
				System.out.println("Enter A Salary :");
				salary = sc.nextFloat();

				emp.add(new Employee(id, name, dept, salary));
			}
			case 2 -> {
				for (Employee x : emp) {
					System.out.println("Display Successfully !!");
					System.out.println(x);
				}

			}
			case 3 -> {
				System.out.println("Enter ID to update:");
				id = sc.nextInt();
				boolean found = false;

				for (Employee x : emp) {
					if (x.getId() == id) {
						System.out.println("Enter new Name:");
						name = sc.next();
						System.out.println("Enter new Department:");
						dept = sc.next();
						System.out.println("Enter new Salary:");
						salary = sc.nextFloat();

						x.setName(name);
						x.setDept(dept);
						x.setSalary(salary);
						found = true;
						System.out.println("Employee updated successfully.");
						break;
					}
				}
				if (!found) {
					System.out.println("Employee with ID " + id + " not found.");
				}

			}
			case 4 -> {
				System.out.println("Enter  A Id : ");
				id = sc.nextInt();
				emp.remove(new Employee(id, null, null, 0));
				System.out.println("Deleted Successfully !!");
			}
			default -> throw new IllegalArgumentException("Unexpected value :" + ch);

			}
		}
	}

}
