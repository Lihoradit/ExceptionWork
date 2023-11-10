package org.example;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();
        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Вы ввели меньше или больше данных, чем требуется.");
            return;
        }

        String surname = data[0];
        String name = data[1];
        String patronymic = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        char gender = data[5].charAt(0);

        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}") || !phoneNumber.matches("\\d+") || (gender != 'ж' && gender != 'м')) {
            System.out.println("Неверный формат данных.");
            return;
        }

        String fileName= "ExceptionWork";
        try (FileWriter writer = new FileWriter(fileName + ".txt", true)) {
            writer.write(surname + " "+name +" "+ patronymic + " " + birthDate + " " + phoneNumber + " " + gender + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}