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
			
			oos.writeObject(list);//���� �Է��� ��Ģ�� ���� �ι� �� ����.
			oos.reset();
			oos.writeObject(list);
			oos.reset();
			
			System.out.println("����Ǿ����ϴ�.");
			
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

		System.out.println("�߰��� ������ ������ �Է��ϼ���.");
		
		System.out.print("���� : ");
		s.nextLine();
		title = s.nextLine();
		System.out.print("���� : ");
		author = s.nextLine();
		System.out.print("ISBN : ");
		isbn = s.nextLine();
		System.out.print("���ǻ� : ");
		publisher = s.nextLine();
		System.out.print("���ǳ⵵ : ");
		publishYear = s.nextInt();
		System.out.print("���� : ");
		price = s.nextInt();
		System.out.print("�α⵵(1~10) : ");
		pop = s.nextInt();
		
		list.add(new Book(isbn, title, author, price, publisher, publishYear, pop));
		System.out.println("=> �߰��Ǿ����ϴ�.");
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
				System.out.println("�˻��Ͻ� ������ ������ ������ �����ϴ�.");
				System.out.println();
				System.out.printf("%s: %s\n","����",list.get(i).getTitle());
				System.out.printf("%s: %s\n","����",list.get(i).getAuthor());
				System.out.printf("%s: %s\n","ISBN",list.get(i).getIsbn());
				System.out.printf("%s: %s\n","���ǻ�",list.get(i).getPublisher());
				System.out.printf("%s: %d\n","���ǳ⵵",list.get(i).getPublishYear());
				System.out.printf("%s: %d\n","����",list.get(i).getPrice());
				System.out.printf("%s: %d\n","�α⵵(1~10)",list.get(i).getPop());
				return i; 
			}
		}
		return -1;
	}
	
	public int inputCategory()
	{
		System.out.println("-----------------------------------");
		System.out.println("ī�װ��� ������ �ּ���. ");
		System.out.println("(1: ���� 2: ���� 3: ISBN 4: ���ǻ�)");
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
			System.out.println("1)�����߰� 2)�������� ���� 3)�������� 4)�����˻� 5)��ü ���� ���");
			System.out.print("6)�����б� 7)�������� 8)���� => ");
			menu=s.nextInt();
			System.out.println("=================================================================");

			if(menu == 8) 
			{
				System.out.println("=> ����Ǿ����ϴ�.");
				break;
			}
			else if(menu == 1) addBook();
			else if(menu == 2) 
			{
				printBook(list);
				System.out.println();
				System.out.println("������ ������ ��ȣ�� �Է��� �ּ���.");
				int no = s.nextInt();
				System.out.println("������ ������ ���� ������ �Է��� �ּ���.");
				category = inputCategory();
				System.out.println("������ ���� : ");
				s.nextLine();
				name = s.nextLine();
				setBook(no-1,category,name);
				System.out.println("=> �����Ǿ����ϴ�.");
			}
			else if(menu == 3)
			{
				printBook(list);
				System.out.println();
				System.out.println("������ ������ ��ȣ�� �Է��� �ּ���.");
				int no = s.nextInt();
				list.remove(no-1);
				System.out.println("=> �����Ǿ����ϴ�.");	
			}
			else if(menu == 4)
			{
				category = inputCategory();	
				System.out.println("�˻��� ������ ������ �Է��� �ּ���.");
				s.nextLine();
				name = s.nextLine();
				t= searchBook(category,name);	
				if(t== -1) System.out.println("�˻��� ������ �����ϴ�.");
			}
			else if(menu == 5)
			{
				System.out.println("��ü ���� ����� ������ �����ϴ�.");
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
		list.add(new Book("8972911399","���⵵�ϰ� �ƴ� ���⵵ �ϰ�","Hoffmann, Roald",21000,"��ġ�۹�",1996,6));
		list.add(new Book("9788990809177","�� ������ ������ ���ָ��°�?","Zieglar, Jeon",22000,"�����İ�",2007,3));
		list.add(new Book("8958620331","���̿� ���� �׸��� ����","���߱�",23000,"�޸ӴϽ�Ʈ",2005,7));
		list.add(new Book("9788971993828","���� �ں�����","illouz Eva",23000,"������",2010,5));
		list.add(new Book("8957090126","����","Thoreau, Henry David",16000,"�̷�",2004,4));
		list.add(new Book("8950905221","������ �ɸ���","Cialdini, Robert B",17000,"21����Ͻ�",2002,8));
		list.add(new Book("9788990062352","����� �ٴ�","�ְ�ö",20000,"��ó��",2009,4));
		list.add(new Book("9788993824605","�׸� �ƴ¸�ŭ ���δ�","��ö��",26000,"�����Ͽ콺",2011,9));
		list.add(new Book("8970131418","���� ����","Kupfer, Alexander",19000,"å����",2000,5));
		list.add(new Book("9788983719171","���� ��ź �����","Rhodes, Richard",25000,"���̾𽺺Ͻ�",2003,2));
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
