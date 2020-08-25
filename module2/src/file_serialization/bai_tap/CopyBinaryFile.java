package file_serialization.bai_tap;

import java.io.*;
import java.util.Scanner;

public class CopyBinaryFile {
    public static void copyFile(File source, File des) throws IOException {
        try (InputStream in = new FileInputStream(source); OutputStream out = new FileOutputStream(des)) {
            byte[] buffer = new byte[1024];
            int length;
            int count=0;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
                count+=length;

            }
            System.out.println("amount of bytes:" +count);
        }

    }

    public static void countBytes(File source) throws IOException {
        InputStream in = new FileInputStream(source);
        int i = -1;
        try {
            while ((i = in.read()) != -1) {
                System.out.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter source file:");
        String sourcePath = scanner.nextLine();
        System.out.print("Enter destination file:");
        String destPath = scanner.nextLine();

        File sourceFile = new File(sourcePath);
        File destFile = new File(destPath);
        try {
            if (!sourceFile.exists())
                throw new IOException("The file is not exist");
            if (destFile.exists())
                throw new IOException("The file is already exist");
            copyFile(sourceFile, destFile);
            countBytes(sourceFile);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
