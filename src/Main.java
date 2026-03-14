import model.Book;
import service.LibraryService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        LibraryService library = new LibraryService();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Library Management System =====");

            System.out.println("1 Add Book");
            System.out.println("2 Show Books");
            System.out.println("3 Search Book");
            System.out.println("4 Issue Book");
            System.out.println("5 Return Book");
            System.out.println("6 Delete Book");
            System.out.println("7 Exit");

            System.out.print("Enter Choice: ");

            int ch = sc.nextInt();

            switch (ch) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author, false));

                    break;

                case 2:
                    library.showBooks();
                    break;

                case 3:

                    System.out.print("Enter Book ID: ");
                    library.searchBook(sc.nextInt());

                    break;

                case 4:

                    System.out.print("Enter Book ID: ");
                    library.issueBook(sc.nextInt());

                    break;

                case 5:

                    System.out.print("Enter Book ID: ");
                    library.returnBook(sc.nextInt());

                    break;

                case 6:

                    System.out.print("Enter Book ID: ");
                    library.deleteBook(sc.nextInt());

                    break;

                case 7:

                    System.exit(0);
            }
        }
    }
}