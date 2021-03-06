package lab11;
 
public class CD implements Media {

	Integer id;
	String artist;
	String title;
	int year;
	

	
	public CD(Integer id, String artist,  String title, int year) 
	{
		this.artist = artist;
		this.id = id;
		this.title = title;
		this.year = year;
	}

	@Override
	public String getCreator() 
	{
		return artist;
	}

	@Override
	public <T> Comparable<T> getId() 
	{
		return (Comparable<T>) id;
	}

	@Override
	public String getTitle() 
	{
		return title;
	}

	@Override
	public int getYear() 
	{
		return year;
	}

}
