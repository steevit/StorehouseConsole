package magazyn.dane;

public class Produkt {
	private String nazwa;
	private double cena;
	private double waga;
	private int id;
	private static int nextId;

	public Produkt()
	{
		this("bez_nazwy");
	}
	
	public Produkt(String n)
	{
		this(n,0,0);
	}
	
	public Produkt(String n, double c, double w)
	{
		id = nextId;
		nextId++;
		nazwa = n;
		cena = c;
		waga = w;
	} 
	
	public String getNazwa()
	{
		return nazwa;
	}
	
	public double getCena()
	{
		return cena;
	}
	
	public double getWaga()
	{
		return waga;
	}
	
	public void setNazwa(String n)
	{
		nazwa = n;
	}
	
	public void setCena(double c)
	{
		cena = c;
	}
	
	public void setWaga(double w)
	{
		waga = w;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String toString()
	{
		return "Id: " + id + ", Kategoria: Inne, Nazwa: " + nazwa + ", Cena: " + cena + ", Waga: " + waga;
	}
	
	static
	{
		nextId=1;
	}
}
