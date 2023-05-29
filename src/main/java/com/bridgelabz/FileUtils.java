package com.bridgelabz;

import java.io.File;

public class FileUtils {

    public static boolean deleteFiles(File contentsToDelete) {
        File[] allContent = contentsToDelete.listFiles();
        if (allContent != null) {
            for (File file : allContent) {
                deleteFiles(file);
            }

        }
        return contentsToDelete.delete();
    }
}
