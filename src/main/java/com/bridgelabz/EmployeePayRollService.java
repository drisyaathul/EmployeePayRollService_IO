package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

    private List<EmployeePayRoll> employeePayRollList ;

    public EmployeePayRollService(List<EmployeePayRoll> employeePayRollList) {
        this.employeePayRollList = employeePayRollList;
    }
    public EmployeePayRollService() {
    }
    public void readEmployeePayRollData(Scanner scannerReader) {

        System.out.println("Enter the Employee Id: ");
        int id = scannerReader.nextInt();
        System.out.println("Enter the Employee Name: ");
        String name = scannerReader.next();
        System.out.println("Enter the Salary: ");
        double salary = scannerReader.nextDouble();

        employeePayRollList.add(new EmployeePayRoll(id,name,salary));
    }
    public void writeEmployeePayRollData() {

        System.out.println("Writing Employee Pay Roll Roaster to Console \n"+employeePayRollList);
    }
    public static void main(String[] args) {

        ArrayList<EmployeePayRoll> employeePayRollList = new ArrayList<>();
        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        Scanner scannerReader = new Scanner(System.in);
        employeePayRollService.readEmployeePayRollData(scannerReader);
        employeePayRollService.writeEmployeePayRollData();
    }
}

