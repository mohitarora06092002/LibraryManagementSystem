package service;

import java.util.*;
import model.Book;
import util.FileUtil;

public class LibraryService {

    List<Book> books = new ArrayList<>();
    String filePath = "data/books.txt";

    public LibraryService() {
        loadBooks();
    }

    private void loadBooks() {

        List<String> data = FileUtil.readFile("data/books.txt");

        for (String line : data) {

            String[] p = line.split(",");

            Book b = new Book(
                    Integer.parseInt(p[0]),
                    p[1],
                    p[2],
                    Boolean.parseBoolean(p[3])
            );

            books.add(b);
        }
    }

    private void saveBooks() {

        List<String> data = new ArrayList<>();

        for (Book b : books) {
            data.add(b.toString());
        }

        FileUtil.writeFile("data/books.txt", data);
    }

    public void addBook(Book b) {
        books.add(b);
        saveBooks();
        System.out.println("Book Added Successfully");
    }

    public void showBooks() {

        for (Book b : books) {

            System.out.println(
                    b.getId() + " | " +
                    b.getTitle() + " | " +
                    b.getAuthor() + " | Issued: " +
                    b.isIssued()
            );
        }
    }

    public void searchBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                System.out.println("Book Found: " + b.getTitle());
                return;
            }
        }

        System.out.println("Book Not Found");
    }

    public void issueBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                if (!b.isIssued()) {

                    b.setIssued(true);
                    saveBooks();

                    System.out.println("Book Issued");

                } else {

                    System.out.println("Book already issued");
                }

                return;
            }
        }
    }

    public void returnBook(int id) {

        for (Book b : books) {

            if (b.getId() == id) {

                b.setIssued(false);
                saveBooks();

                System.out.println("Book Returned");

                return;
            }
        }
    }

    public void deleteBook(int id) {

        books.removeIf(b -> b.getId() == id);

        saveBooks();

        System.out.println("Book Deleted");
    }
}