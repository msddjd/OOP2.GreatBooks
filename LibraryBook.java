public class LibraryBook
{
	private String Title;
	private String Author; //author's name, last name, first name
	private int Copyright;
	private double Price;
	private String Genre;

	public LibraryBook(String Title,String Author,int Copyright,double Price,String Genre)
	{
	this.Title = Title;
	this.Author = Author;
	this.Copyright = Copyright;
	this.Price = Price;
	this.Genre = Genre;
	}

	public String getTitle()
	{
	return Title;
	}	

	
	public String getAuthor()
	{
	return Author;
	}	

	
	public int getCopyright()
	{
	return Copyright;
	}
	
	public double getPrice()
	{
	return Price;
	}
	
	public String getGenre()
	{
	return Genre;
	}

}
