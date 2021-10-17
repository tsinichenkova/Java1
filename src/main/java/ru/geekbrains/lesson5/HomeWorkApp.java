package ru.geekbrains.lesson5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) throws Exception {

        Employee[] employees = new Employee[5];
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee(getRandomStringFromFile("/lesson5/fullName.txt"),
                    getRandomStringFromFile("/lesson5/postition.txt"),
                    getRandomStringFromFile("/lesson5/email.txt"),
                    getRandomPhoneNumber(),
                    getRandomNumber(50000),
                    getRandomNumber(100));
        }

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfo();
                System.out.println();
            }
        }
    }

    public static String getRandomPhoneNumber() {
        String s = "0123456789";
        StringBuilder phoneNumber = new StringBuilder();

        for(int i = 0; i < 9; ++i) {
            phoneNumber.append(s.charAt((new Random()).nextInt(s.length())));
        }

        return "+79" + phoneNumber.toString();
    }

    public static int getRandomNumber (int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }

    public static String getRandomStringFromFile (String path) throws Exception {
        List<String> array = new ArrayList();
        BufferedReader br = new BufferedReader(new InputStreamReader(HomeWorkApp.class.getResourceAsStream(path), "UTF8"));

        String line;
        while((line = br.readLine()) != null) {
            array.add(line);
        }
        br.close();

        Random random = new Random();
        return array.get(random.nextInt(array.size()));
    }

}

