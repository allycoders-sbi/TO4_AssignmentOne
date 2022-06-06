package books.models;

public class Book {
	int bookId;
	String bookTitle,bookAuthor;
	double bookPrice;
	int numberOfPages;
	int bookEdition;
	
	int noOfCopies;

	public Book(int bookId, String bookTitle, String bookAuthor, double bookPrice, int numberOfPages, int bookEdition,
			int noOfCopies) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
		this.numberOfPages = numberOfPages;
		this.bookEdition = bookEdition;
		this.noOfCopies = noOfCopies;
	}
}
