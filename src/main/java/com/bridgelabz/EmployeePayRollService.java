package com.bridgelabz;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmployeePayRollService {

    private List<EmployeePayRoll> employeePayRollList ;

    public EmployeePayRollService(List<EmployeePayRoll> employeePayRollList) {
        this.employeePayRollList = employeePayRollList;
    }
    public EmployeePayRollService() {
    }
    public PayRollService getPayrollService(IOService ioType) {

        PayRollService payrollService;
        if (IOService.FILE_IO.equals(ioType)) {
            payrollService = new FileIOImpl();
        } else if (IOService.DATABASE_IO.equals(ioType)) {
            payrollService = new DataBaseIOImpl();
        } else if (IOService.CONSOLE_IO.equals(ioType)) {
            payrollService = new ConsoleIOImpl();
        } else {
            payrollService = new CloudIOImpl();
        }
        return payrollService;
    }
    public void readData (IOService ioType) {

        PayRollService payrollService = getPayrollService(ioType);
        try {
            payrollService.readData();
        } catch (IOException e) {
            System.out.println("catch block");
        }
    }
    public void writeData(IOService ioType) {

        // Abstraction
        PayRollService payrollService = getPayrollService(ioType);
        try {
            payrollService.writeData(employeePayRollList);
        } catch (IOException e) {
            System.out.println("catch block");
        }
    }
    public Long countEntries(IOService ioType) {
        PayRollService payrollService = getPayrollService(ioType);
        try {
            return payrollService.countEntries();
        } catch (IOException e) {
            System.out.println("catch block");
        }
        return null;
    }
}

