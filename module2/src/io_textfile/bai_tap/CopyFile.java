package io_textfile.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyFile {
    public static void copyfileNormal(File source, File des) {
        try {
            FileReader fileReader = new FileReader(source);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            FileWriter fileWriter = new FileWriter(des);
            String line;
            int count=0;
            while ((line = bufferedReader.readLine()) != null) {
                fileWriter.write(line);
                count+=line.length();
            }
            System.out.println(count);
            bufferedReader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source file:");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file:");
        String destPath = scanner.nextLine();
        File source = new File(sourcePath);
        File des = new File(destPath);
        if (!source.exists())
            throw new IOException("The file does not exist");
        if (des.exists())
            throw new IOException("The file is already exist");
        copyfileNormal(source, des);


    }

}
