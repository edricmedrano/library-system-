public class Book {

    private String title;
    private boolean borrowed;

    public Book(String title) {
        this.title = title;
        borrowed = false;
    }

    public void borrowBook() {
        if (borrowed == false) {
            borrowed = true;
            System.out.println("You borrowed " + title);
        } else {
            System.out.println("Already taken");
        }
    }

    public void returnBook() {
        if (borrowed == true) {
            borrowed = false;
            System.out.println(title + " returned");
        } else {
            System.out.println("Wasn't borrowed");
        }
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }
}
