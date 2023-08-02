package json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) throws IOException {
        String file = "src/user.txt";
        String jsons = "src/user.json";

        List<User> users = redUserTxt(file);
        writeInJsonFil(users, jsons);

    }

    private static List<User> redUserTxt(String file) throws FileNotFoundException {
        List<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(new File(file));

        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
        while (scanner.hasNextLine()) {
            String[] parse = scanner.nextLine().split(" ");
            String name = parse[0];
            int age = Integer.parseInt(parse[1]);
            User user = new User(name, age);
            users.add(user);
        }
        scanner.close();
        return users;
    }

    private static void writeInJsonFil(List<User> users, String jsonFile) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writer = new FileWriter(jsonFile);
        writer.write(gson.toJson(users));
        writer.close();
    }


}
