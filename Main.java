package com.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Добавить книгу\n2. Взять книгу\n3. Вернуть книгу\n4. Показать доступные\n5. Выход");
            System.out.print("Выбор: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> {
                        System.out.print("Название: "); String t = scanner.nextLine();
                        System.out.print("Автор: "); String a = scanner.nextLine();
                        System.out.print("ISBN: "); String i = scanner.nextLine();
                        library.addBook(new Book(t, a, i));
                        System.out.println("Добавлено.");
                    }
                    case "2" -> {
                        System.out.print("ISBN: ");
                        library.borrowBook(scanner.nextLine());
                        System.out.println("Взято.");
                    }
                    case "3" -> {
                        System.out.print("ISBN: ");
                        library.returnBook(scanner.nextLine());
                        System.out.println("Возвращено.");
                    }
                    case "4" -> {
                        var books = library.listAvailableBooks();
                        if (books.isEmpty()) {
                            System.out.println("Нет доступных книг.");
                        } else {
                            books.forEach(System.out::println);
                        }
                    }
                    case "5" -> {
                        System.out.println("До свидания!");
                        return;
                    }
                    default -> System.out.println("Неверный ввод.");
                }
            } catch (Exception e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}