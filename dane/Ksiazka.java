package magazyn.dane;

import magazyn.dane.Produkt;

public class Ksiazka extends Produkt
{
	private String autor;
	
	public Ksiazka()
	{
		this("brak_autora");
	}
	
	public Ksiazka(String a)
	{
		this(a,"bez_nazwy",0,0);
	}
	
	public Ksiazka(String a, String n, double c, double w)
	{
		super(n,c,w);
		autor = a;
	}
	
	public void setAutor(String a)
	{
		autor = a;
	}
	
	public String toString()
	{
		return "Id: " + getId() + ", Kategoria: Ksi¹¿ki, Autor: " + autor + ", Nazwa: " + getNazwa() + ", Cena: " + getCena() + ", Waga: " + getWaga();
	}

}

