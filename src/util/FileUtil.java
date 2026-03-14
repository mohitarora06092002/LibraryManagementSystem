package util;

import java.io.*;
import java.util.*;

public class FileUtil {

    public static List<String> readFile(String path) {

        List<String> data = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                data.add(line);
            }

            br.close();
        } catch (Exception e) {
            System.out.println("File read error");
        }

        return data;
    }

    public static void writeFile(String path, List<String> data) {

        try {

            BufferedWriter bw = new BufferedWriter(new FileWriter(path));

            for (String line : data) {
                bw.write(line);
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("File write error");
        }
    }
}