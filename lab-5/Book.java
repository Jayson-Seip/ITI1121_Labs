public class Book {

    // Your variables declaration here
	private String author, title;
	private int year;

    public Book (String author, String title, int year) {
        this.author = author;
		this.title=title;
		this.year=year;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getTitle() {
        return this.title;
    }

    public int getYear() {
        return this.year;
    }

    public boolean equals(Object other) {
		if(other == null){
			return false;
		}
		if(this.getClass() != other.getClass()){
			return false;
		}
		Book b = (Book) other;
		if(b.author == null || b.title == null||this.author == null|| this.title == null){
			if(this.author == null && b.author == null){
				return true;
			}
			else if(this.title==null && b.title == null){
				return true;
			}
			return false;
		}
        return this.author.equals(b.author) && this.title.equals(b.title) && this.year == b.year;
    }

    public String toString() {
        String str = this.author+":"+this.title+"("+this.year+")";
		return str;
    }
}