package lab9.task2;

import java.util.*;

public class Category {
    private List<Book> listBook;

    public Category(List<Book> listBook) {
        this.listBook = listBook;
    }

    //Câu 9
    public int sumPrice() {
        int result = 0;
        for (Book book : listBook) {
            result += book.getPrice();
        }
        return result;
    }

    //Câu 10
    public Book getMaxChapRefBook() {
        Book result = null;
        int maxChap = 0;
        for (Book book : listBook) {
            if (book.getMaxChap() > maxChap) {
                maxChap = book.getMaxChap();
                result = book;
            }
        }
        return result;
    }

    //Câu 11
    public boolean isMagazineHaveName(String name) {
        for (Book book : listBook) {
            if (book.isMagazineHaveName(name)) return true;
        }
        return false;
    }

    //Câu 12
    public List<Book> getBooksWithYear(int year) {
        List<Book> result = new ArrayList<>();
        for (Book book : listBook) {
            if (book.isSameYear(year)) result.add(book);
        }
        return result;
    }

    //Câu 13
    public void sortBook() {
        listBook.sort(new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                if (o1.getTitle().compareTo(o2.getTitle()) == 0) {
                    return o2.getYear() - o1.getYear();
                }
                else return o1.getTitle().compareTo(o2.getTitle());
            }
        });
    }

    //Câu 14
    public Map<Integer, Integer> getBookByYear() {
        Map<Integer, Integer> result = new HashMap<>();
        for (Book book : listBook) {
            result.put(book.getYear(), result.getOrDefault(book.getYear(), 0) + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Book b1 = new Magazine("A", 100, 2021, "ABC", 5000, "AAAA");
        Book b2 = new Magazine("B", 100, 2022, "ABC", 5000, "BBBB");
        Book b3 = new Magazine("C", 100, 2023, "BCD", 5000, "CCCC");

        Chapter c1 = new Chapter("S", 30);
        Chapter c2 = new Chapter("T", 40);
        Chapter c3 = new Chapter("U", 50);
        Chapter c4 = new Chapter("V", 20);
        Chapter c5 = new Chapter("W", 10);
        Chapter c6 = new Chapter("X", 60);

        List<Chapter> lc1 = new ArrayList<>();
        lc1.add(c1); lc1.add(c2);

        List<Chapter> lc2 = new ArrayList<>();
        lc1.add(c3); lc2.add(c4);

        List<Chapter> lc3 = new ArrayList<>();
        lc3.add(c5); lc3.add(c6);

        Book b4 = new RefBook("C", 121, 2021, "BCD", 5000, "CCCC", lc1);
        Book b5 = new RefBook("E", 200, 2021, "BCD", 5000, "DDDD", lc2);
        Book b6 = new RefBook("F", 300, 2022, "BCD", 5000, "EEEE", lc3);

        List<Book> list = new ArrayList<>();
        list.add(b1); list.add(b2); list.add(b3); list.add(b4); list.add(b5); list.add(b6);

        Category category = new Category(list);

        //C6
        System.out.println(b1.typeOfBook());
        //C7
        System.out.println(b2.checkTypeAndYear(2032));
        System.out.println(b5.checkTypeAndYear(2032));
        //C8
        System.out.println(b1.isSameTypeAndAuthor(b2));
        //C9
        System.out.println(category.sumPrice());
        //C10
        System.out.println(category.getMaxChapRefBook());
        //C11
        System.out.println(category.isMagazineHaveName("AAAA"));
        System.out.println(category.isMagazineHaveName("OMG"));
        //C12
        System.out.println(Arrays.toString(category.getBooksWithYear(2021).toArray()));
        //C13
        category.sortBook();
        System.out.println(Arrays.toString(category.listBook.toArray()));
        //C14
        System.out.println(category.getBookByYear());

    }
}

