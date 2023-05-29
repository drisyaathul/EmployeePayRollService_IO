package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class EmployeePayRollServiceTest {

    private static String HOME = System.getProperty("user.home");
    private static String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {
            // Check File Exists
            Path homepath = Paths.get(HOME);
            Assert.assertTrue(Files.exists(homepath));

            // Delete File and Check File Not Exist
            Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
            if (Files.exists(playPath))
                FileUtils.deleteFiles(playPath.toFile());
            Assert.assertTrue(Files.notExists(playPath));

            // Create Directory
            Files.createDirectories(playPath);
            Assert.assertTrue(Files.exists(playPath));

            //  Create Empty File
            IntStream.range(1, 10).forEach(cntr -> {
                Path tempFile = Paths.get(playPath + "/temp" + cntr);
                Assert.assertTrue(Files.notExists(tempFile));
                try {
                    Files.createFile(tempFile);
                } catch (IOException e) {
                    System.out.println("Catch");
                }
                Assert.assertTrue(Files.exists(tempFile));
            });

            //List Files, Directories as well as Files with Extension
            Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
            Files.newDirectoryStream(playPath).forEach(System.out::println);
            Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp")).forEach(System.out::println);
        }
    @Test
    public void givenThreeEmployeeWhenWriteToFileAndReadShouldReturnCount() {

        EmployeePayRoll employee1 = new EmployeePayRoll(1,"Drisya",450000);
        EmployeePayRoll employee2 = new EmployeePayRoll(2,"Athul",650000);
        EmployeePayRoll employee3 = new EmployeePayRoll(3,"Edhas",800000);

        List<EmployeePayRoll> employeePayRollList = new ArrayList<>();
        employeePayRollList.add(employee1);
        employeePayRollList.add(employee2);
        employeePayRollList.add(employee3);

        EmployeePayRollService employeePayRollService = new EmployeePayRollService(employeePayRollList);
        employeePayRollService.writeData(IOService.FILE_IO);
        employeePayRollService.readData(IOService.FILE_IO);
        long count = employeePayRollService.countEntries(IOService.FILE_IO);
        Assertions.assertEquals(3,count);
    }
}
