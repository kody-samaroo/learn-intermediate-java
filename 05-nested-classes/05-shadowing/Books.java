class Book {
	String type = "Nonfiction";

	class Biography {
    String type = "Biography";

		public void print() {
      System.out.println(type);
			System.out.println(Book.this.type);
		}
	}
}

public class Books {
	public static void main(String[] args) {
		Book book = new Book();
		Book.Biography bio = book.new Biography();
		bio.print();
	}
}
