package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/file.txt";
        namber(file);
    }

    private static void namber(String file) throws FileNotFoundException {
        Scanner s = new Scanner(new File(file));
        String phoneRegex = "^\\(\\d{3}\\) \\d{3}-\\d{4}$|^\\d{3}-\\d{3}-\\d{4}$";
        Pattern pattern = Pattern.compile(phoneRegex);

        while (s.hasNextLine()) {
            String line = s.nextLine().trim();
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                System.out.println(line);
            }
        }
        s.close();
    }
}