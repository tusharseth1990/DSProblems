package array.comparatorandcomparable;

class Book //implements Comparable<Book>
{
    public String getTitle() {
        return title;
    }

    public int getPrice() {
        return price;
    }

    private String title;
    private String author;
    private int price;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book(String title, String author, int price)
    { this.title = title;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() { return "Book [title=" + title + ", author=" + author + ", price=" + price + "]"; }
    // the old way to implement CompareTo method to compare // object by multiple fields, you'll learn new way as well
    /*@Override
    public int compareTo(Book b)
    {
        int i = this.title.compareTo(b.title);
        if (i != 0) return i;
        i = this.author.compareTo(b.author);
        if (i != 0) return i;
        return Integer.compare(this.price, b.price);
    }*/
 }

