import java.io.Serializable;

public class Book implements Serializable {// 시리얼(직렬)<->pararell(병렬)시킬 수 있는 인터페이스가 있다는 의미.
	private String isbn;//직렬 병렬은 어딘가에 전송시킬 때 필요하다. 직렬은 그냥 일렬로 줄 세울 수 있다는 의미.
	private String title;
	private String author;
	private String publisher;
	
	private int price;
	private int publishYear;
	private int pop;
	
	public Book(String isbn, String title, String author, int price, String publisher, int publishYear, int pop){//데이터클래스라 메인 없이 그냥 생성자
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
	
	public String toString(){// 오브젝트의 메소드 toString이므로 오버라이드 가능
		return "["+getIsbn() + "/" + getTitle() + "/" + getAuthor() + "/" + getPublisher()
				+ "/" + getPublishYear() + "/" + getPrice() +"/" + getPop() + "]";
	}
}
