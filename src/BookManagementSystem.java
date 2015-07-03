import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

//load : input
//save : output

class BookManager {

	ArrayList <Book> list = new ArrayList<Book>();
	Scanner s = new Scanner(System.in);
	
	public void load()
	{
		FileInputStream fin = null;
		ObjectInputStream ois = null;

		try{
			fin = new FileInputStream("booklist.dat");
			ois = new ObjectInputStream(fin);
			
			ArrayList list1 = (ArrayList)ois.readObject();
			printBook(list1);
			ArrayList list2 = (ArrayList)ois.readObject();
			
			
		}catch(Exception ex){
		}finally{
			try{
				ois.close();
				fin.close();
			}catch(IOException ioe){}
		} // finally
	} // class end
	
	public void save()
	{

		FileOutputStream fout = null;
		ObjectOutputStream oos = null;
		 
		try
		{
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);//파일 입력의 법칙에 따라 두번 한 것임.
			oos.reset();
			oos.writeObject(list);
			oos.reset();
			
			System.out.println("저장되었습니다.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	}
	
	public void addBook()
	{
		String isbn;
		String title;
		String author;
		String publisher;
		
		int price;
		int publishYear;
		int pop;

		System.out.println("추가할 도서의 정보를 입력하세요.");
		
		System.out.print("제목 : ");
		s.nextLine();
		title = s.nextLine();
		System.out.print("저자 : ");
		author = s.nextLine();
		System.out.print("ISBN : ");
		isbn = s.nextLine();
		System.out.print("출판사 : ");
		publisher = s.nextLine();
		System.out.print("출판년도 : ");
		publishYear = s.nextInt();
		System.out.print("가격 : ");
		price = s.nextInt();
		System.out.print("인기도(1~10) : ");
		pop = s.nextInt();
		
		list.add(new Book(isbn, title, author, price, publisher, publishYear, pop));
		System.out.println("=> 추가되었습니다.");
	}
	
	public void setBook(int no, int n, String name)
	{
		if(n == 1) list.get(no).setTitle(name);
		else if(n == 2) list.get(no).setAuthor(name);
		else if(n == 3) list.get(no).setIsbn(name);
		else list.get(no).setPublisher(name);
	}
	
	public int searchBook(int n, String name)
	{
		String nameb;
		for(int i= 0; i<list.size(); i++)
		{
			if(n == 1) nameb= list.get(i).getTitle();
			else if(n == 2) nameb= list.get(i).getAuthor();
			else if(n == 3) nameb= list.get(i).getIsbn();
			else nameb= list.get(i).getPublisher();
		
			if(name.equals(nameb))
			{
				System.out.println("검색하신 도서의 정보는 다음과 같습니다.");
				System.out.println();
				System.out.printf("%s: %s\n","제목",list.get(i).getTitle());
				System.out.printf("%s: %s\n","저자",list.get(i).getAuthor());
				System.out.printf("%s: %s\n","ISBN",list.get(i).getIsbn());
				System.out.printf("%s: %s\n","출판사",list.get(i).getPublisher());
				System.out.printf("%s: %d\n","출판년도",list.get(i).getPublishYear());
				System.out.printf("%s: %d\n","가격",list.get(i).getPrice());
				System.out.printf("%s: %d\n","인기도(1~10)",list.get(i).getPop());
				return i; 
			}
		}
		return -1;
	}
	
	public int inputCategory()
	{
		System.out.println("-----------------------------------");
		System.out.println("카테고리를 선택해 주세요. ");
		System.out.println("(1: 제목 2: 저자 3: ISBN 4: 출판사)");
		int category = s.nextInt(); 
		System.out.println("---------------------------------- ");
		return category;
	}
	
	
	public void printBook(ArrayList u)
	{
		for(int i=0; i<u.size(); i++)
		{
			System.out.println((i+1) + ". "+ u.get(i).toString());
		}
	}
	
	public void start()
	{
		int menu, category, t;
		String name;
		
		while(true)
		{
			System.out.println("=================================================================");
			System.out.println("1)도서추가 2)도서정보 변경 3)도서삭제 4)도서검색 5)전체 도서 목록");
			System.out.print("6)파일읽기 7)파일저장 8)종료 => ");
			menu=s.nextInt();
			System.out.println("=================================================================");

			if(menu == 8) 
			{
				System.out.println("=> 종료되었습니다.");
				break;
			}
			else if(menu == 1) addBook();
			else if(menu == 2) 
			{
				printBook(list);
				System.out.println();
				System.out.println("변경할 도서의 번호를 입력해 주세요.");
				int no = s.nextInt();
				System.out.println("변경할 도서의 세부 정보를 입력해 주세요.");
				category = inputCategory();
				System.out.println("변경할 정보 : ");
				s.nextLine();
				name = s.nextLine();
				setBook(no-1,category,name);
				System.out.println("=> 수정되었습니다.");
			}
			else if(menu == 3)
			{
				printBook(list);
				System.out.println();
				System.out.println("삭제할 도서의 번호를 입력해 주세요.");
				int no = s.nextInt();
				list.remove(no-1);
				System.out.println("=> 삭제되었습니다.");	
			}
			else if(menu == 4)
			{
				category = inputCategory();	
				System.out.println("검색할 도서의 정보를 입력해 주세요.");
				s.nextLine();
				name = s.nextLine();
				t= searchBook(category,name);	
				if(t== -1) System.out.println("검색한 도서가 없습니다.");
			}
			else if(menu == 5)
			{
				System.out.println("전체 도서 목록은 다음과 같습니다.");
				printBook(list);
			}
			else if(menu == 6) load();
			else save();
		
			System.out.println();
		}
	}
	
	public void inputdata()
	{
		//isbn, title, author, price, publisher, publishYear, pop
		list.add(new Book("8972911399","같기도하고 아니 같기도 하고","Hoffmann, Roald",21000,"까치글방",1996,6));
		list.add(new Book("9788990809177","왜 세계의 절반은 굶주리는가?","Zieglar, Jeon",22000,"갈라파고스",2007,3));
		list.add(new Book("8958620331","놀이와 예술 그리고 상상력","진중권",23000,"휴머니스트",2005,7));
		list.add(new Book("9788971993828","감정 자본주의","illouz Eva",23000,"돌베개",2010,5));
		list.add(new Book("8957090126","월든","Thoreau, Henry David",16000,"이레",2004,4));
		list.add(new Book("8950905221","설득의 심리학","Cialdini, Robert B",17000,"21세기북스",2002,8));
		list.add(new Book("9788990062352","문명과 바다","주경철",20000,"산처럼",2009,4));
		list.add(new Book("9788993824605","그림 아는만큼 보인다","손철주",26000,"오픈하우스",2011,9));
		list.add(new Book("8970131418","신의 독약","Kupfer, Alexander",19000,"책세상",2000,5));
		list.add(new Book("9788983719171","원자 폭탄 만들기","Rhodes, Richard",25000,"사이언스북스",2003,2));
	}
}

public class BookManagementSystem
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManager bm = new BookManager();
		bm.inputdata();
		bm.start();
	}
}
