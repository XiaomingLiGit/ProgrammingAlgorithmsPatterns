package ca.qc.vc.week4.lesson11;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        try
        {
            File file = new File("first.txt");

            if (file.exists()) {
                System.out.println("Name:"  + file.getName());
                System.out.println("Size:"  + file.length());
                System.out.println("Last Modified:"  + file.lastModified());
                System.out.println("Path:"  + file.getAbsolutePath());
            }
            else
            {
//                System.out.println("File does not exist");
                throw new IOException("File does not exist");
            }

        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

}
