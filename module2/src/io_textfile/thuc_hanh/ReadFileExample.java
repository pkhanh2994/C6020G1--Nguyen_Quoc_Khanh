package io_textfile.thuc_hanh;

import java.io.*;
import java.util.Scanner;

public class ReadFileExample {
    public static  void readFileText(String filePath){
        try {
            File file=new File(filePath);
            if(!file.exists()){
                throw new FileNotFoundException();
            }
            FileReader fileReader=new FileReader(file);
            BufferedReader bufferedReader=new BufferedReader(fileReader);
            String line;
            int sum=0;
            while ((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                sum+=Integer.parseInt(line);
            }
            bufferedReader.close();
            System.out.println("Sum is: "+sum);
        } catch (Exception e){
            System.out.println("File does not exist or the content has an error");
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the path of the file");
        String filePath=scanner.nextLine();
        readFileText(filePath);
    }
}
