package com.bridgelabz;

import java.io.IOException;
import java.util.List;

public interface PayRollService {
    void writeData(List<EmployeePayRoll> employeePayRollList) throws IOException;
    void readData()throws IOException;
    long countEntries()throws IOException;
}
