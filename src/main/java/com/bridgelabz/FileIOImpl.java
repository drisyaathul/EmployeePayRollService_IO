package com.bridgelabz;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileIOImpl implements PayRollService {

    static String filePath = "C:\\Users\\drisy\\IdeaProjects\\RFP272_EmployeePayRoll_IO\\src\\main\\java\\com\\bridgelabz\\PayRollService.txt";

    @Override
    public void writeData(List<EmployeePayRoll>employeePayRollList) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        employeePayRollList.stream().forEach(employeePayRoll -> {
            String empString = employeePayRoll.toString().concat("\n");
            stringBuffer.append(empString);
        });
        //variable Arguments
        Files.write(Path.of(filePath),stringBuffer.toString().getBytes());
    }

    @Override
    public void readData() throws IOException {
        Files.lines(Path.of(filePath)).forEach(empData -> {
            System.out.println(empData);
        });
    }

    @Override
    public long countEntries() throws IOException{
        return Files.lines(Path.of(filePath)).count();
    }
}
