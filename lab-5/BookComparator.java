import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    // Implement the comparator method for books.
	public int compare(Book a, Book b){
		if(a.getAuthor().compareTo(b.getAuthor())<0){
			return -1;
		}
		if(a.getAuthor().equals(b.getAuthor())){
			if(a.getTitle().compareTo(b.getTitle())<0){
				return -1;
			}
		}
		if(a.getAuthor().equals(b.getAuthor()) && a.getTitle().equals(b.getTitle())){
			if(a.getYear() < b.getYear()){
				return -1;
			}
		}
		return 1;
	}

}