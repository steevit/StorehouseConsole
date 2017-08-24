package magazyn.aplikacja;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;
import java.util.Scanner;

import magazyn.dane.Ksiazka;
import magazyn.dane.Produkt;
import magazyn.dane.Urzadzenie;

public class Magazyn
{
	public static final int DODAJ_PRODUKT = 1;
	public static final int USUN_PRODUKT = 2;
	public static final int PRZEGLADAJ_PRODUKTY = 3;
	public static final int WYJSCIE = 0;

	public static final int KSIAZKA = 1;
	public static final int URZADZENIE = 2;
	public static final int PRODUKT = 3;
	public static final int POWROT = 0;

	private static List<Produkt> asortyment;

	public static void main(String[] args) {
		asortyment = new ArrayList<>();
		Scanner skaner = new Scanner(System.in);
		int menu = 0;
		int menu2 = 0;

		do{
			wczytajMenu();
			try {
				menu = skaner.nextInt();
				skaner.nextLine();
			} catch(InputMismatchException exc) {
				skaner.nextLine();
				System.out.println("---------------");
				System.out.println("Dane w nieprawid³owym formacie.");
				continue;
			}

			switch(menu) {
			case DODAJ_PRODUKT:
				wczytajMenu2();
				try {
					menu2 = skaner.nextInt();
					skaner.nextLine();
				} catch(InputMismatchException exc) {
					skaner.nextLine();
					System.out.println("---------------");
					System.out.println("Dane w nieprawid³owym formacie.");
					continue;
				}
				
				try {
					switch(menu2) {
					case PRODUKT:
						dodajProdukt(skaner);
						break;
					case KSIAZKA:
						dodajKsiazke(skaner);
						break;
					case URZADZENIE:
						dodajUrzadzenie(skaner);
						break;
					case POWROT:
						break;
					}
				} catch(InputMismatchException e) {
					skaner.nextLine();
					System.out.println("-----------------");
					System.out.println("B³¹d odczytu danych");
				} catch(ArrayIndexOutOfBoundsException e) {
					System.out.println("------------------");
					System.out.println(e.getMessage());
				}
				break;
				/*case KSIAZKA:
					try {
						dodajKsiazke(skaner);
					} catch(InputMismatchException e) {
						skaner.nextLine();
						System.out.println("-----------------");
						System.out.println("B³¹d odczytu danych");
					} catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("------------------");
						System.out.println(e.getMessage());
					}
					break;
				case URZADZENIE:
					try {
						dodajUrzadzenie(skaner);
					} catch(InputMismatchException e) {
						skaner.nextLine();
						System.out.println("-----------------");
						System.out.println("B³¹d odczytu danych");
					} catch(ArrayIndexOutOfBoundsException e) {
						System.out.println("------------------");
						System.out.println(e.getMessage());
					}
					break;
				case POWROT:
					break;
				}
				break; */
			case USUN_PRODUKT:
				usunProdukt(skaner);
				break;
			case PRZEGLADAJ_PRODUKTY:
				wyswietlProdukty();
				break;
			case WYJSCIE:
				break;
				}
			}while(menu!=WYJSCIE);
		}

		private static void wyswietlProdukty() {
			System.out.println("---------------------------");
			System.out.println("Lista produktów: ");
			for(Produkt p: asortyment) {
				System.out.println(p);
			}
	}

		private static void dodajProdukt(Scanner sc) throws InputMismatchException {
				Produkt produkt = new Produkt();
				System.out.println("------------------");
				System.out.println("Dodawanie nowego produktu: ");
				System.out.println("Nazwa: ");
				produkt.setNazwa(sc.nextLine());
				System.out.println("Cena: ");
				produkt.setCena(sc.nextDouble());
				sc.nextLine();
				System.out.println("Waga: ");
				produkt.setWaga(sc.nextDouble());
				sc.nextLine();

				asortyment.add(produkt);
			}

		private static void dodajKsiazke(Scanner sc) throws InputMismatchException {
			Ksiazka ksiazka = new Ksiazka();
			System.out.println("------------------");
			System.out.println("Dodawanie nowej ksi¹¿ki: ");
			System.out.println("Autor: ");
			ksiazka.setAutor(sc.nextLine());
			System.out.println("Nazwa: ");
			ksiazka.setNazwa(sc.nextLine());
			System.out.println("Cena: ");
			ksiazka.setCena(sc.nextDouble());
			System.out.println("Waga: ");
			ksiazka.setWaga(sc.nextDouble());

			asortyment.add(ksiazka);
		}

		private static void dodajUrzadzenie(Scanner sc) throws InputMismatchException {
			Urzadzenie urzadzenie = new Urzadzenie();
			System.out.println("------------------");
			System.out.println("Dodawanie nowego urz¹dzenia: ");
			System.out.println("Nazwa: ");
			urzadzenie.setNazwa(sc.nextLine());
			System.out.println("Cena: ");
			urzadzenie.setCena(sc.nextDouble());
			System.out.println("Waga: ");
			urzadzenie.setWaga(sc.nextDouble());
			System.out.println("Gwarancja (w msc): ");
			urzadzenie.setGwarancja(sc.nextInt());

			asortyment.add(urzadzenie);
		}

		private static void usunProdukt(Scanner sc) throws InputMismatchException {
			System.out.println("------------------");
			System.out.println("Usuwanie produktu: ");
			System.out.println("Podaj ID produktu: ");
			int idDelete;
			int idPom;
			idDelete = sc.nextInt();
			sc.nextLine();
			for(Produkt p: asortyment) {
				idPom = p.getId();
				if(idPom==idDelete)
				{
					asortyment.remove(p);
					break;
				}
			}
			System.out.println("Produkt zosta³ usuniêty.");

		}

		private static void wczytajMenu()
		{
			System.out.println("-----------------");
			System.out.println("Dostêpne opcje: ");
			System.out.println(DODAJ_PRODUKT + " - Dodaj produkt");
			System.out.println(USUN_PRODUKT + " - Usuñ produkt");
			System.out.println(PRZEGLADAJ_PRODUKTY + " - Wyœwietl produkty");
			System.out.println(WYJSCIE + " - Wyjœcie z programu");
			System.out.println("Wybierz opcjê: ");
		}

		private static void wczytajMenu2()
		{
			System.out.println("-----------------");
			System.out.println("Dostêpne typy produktu: ");
			System.out.println(KSIAZKA + " - Ksi¹¿ka");
			System.out.println(URZADZENIE + " - Urz¹dzenie");
			System.out.println(PRODUKT + " - Inny");
			System.out.println(POWROT + " - Powrót");
		}
}
