import java.io.Serializable;

public class Book implements Serializable {// �ø���(����)<->pararell(����)��ų �� �ִ� �������̽��� �ִٴ� �ǹ�.
	private String isbn;//���� ������ ��򰡿� ���۽�ų �� �ʿ��ϴ�. ������ �׳� �Ϸķ� �� ���� �� �ִٴ� �ǹ�.
	private String title;
	private String author;
	private String publisher;
	
	private int price;
	private int publishYear;
	private int pop;
	
	public Book(String isbn, String title, String author, int price, String publisher, int publishYear, int pop){//������Ŭ������ ���� ���� �׳� ������
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.price = price;
		this.publisher = publisher;
		this.publishYear = publishYear;
		this.pop = pop;
	}

	public String getAuthor() {
		return author;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}
	
	public String getPublisher() {
		return publisher;
	}
	
	public int getPublishYear() {
		return publishYear;
	}
	
	public int getPop() {
		return pop;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public void setPublishYear(int publishYear) {
		this.publishYear = publishYear;
	}
	
	public void setPop(int pop) {
		this.pop = pop;
	}
	
	public String toString(){// ������Ʈ�� �޼ҵ� toString�̹Ƿ� �������̵� ����
		return "["+getIsbn() + "/" + getTitle() + "/" + getAuthor() + "/" + getPublisher()
				+ "/" + getPublishYear() + "/" + getPrice() +"/" + getPop() + "]";
	}
}
