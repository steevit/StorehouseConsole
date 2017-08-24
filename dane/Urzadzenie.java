package magazyn.dane;

import magazyn.dane.Produkt;

public class Urzadzenie extends Produkt 
{
	private int gwarancja;
	
	public Urzadzenie()
	{
		this("bez_nazwy",0,0,0);
	}
	
	public Urzadzenie(String n, double c, double w, int gw)
	{
		super(n,c,w);
		gwarancja = gw;
	}
	
	public void setGwarancja(int gw)
	{
		gwarancja = gw;
	}
	
	public String toString()
	{
		return "Id: " + getId() + ", Kategoria: Urz¹dzenia, Nazwa: " + getNazwa() + ", Cena: " + getCena() + ", Waga: " + getWaga() + ", Gwarancja(msc): " + gwarancja;
	}
}
