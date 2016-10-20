package classes;

public class Artikel {
	
	private String artikelid;
	private String bezeichnung;
	private String beschreibung;
	private String preis;
	private String kategorie;
	
	
	public Artikel(String artikelid, String bezeichnung, String beschreibung, String preis, String kategorie) {
		super();
		this.artikelid = artikelid;
		this.bezeichnung = bezeichnung;
		this.beschreibung = beschreibung;
		this.preis = preis;
		this.kategorie = kategorie;
	}


	public String getArtikelid() {
		return artikelid;
	}


	public void setArtikelid(String artikelid) {
		this.artikelid = artikelid;
	}


	public String getBezeichnung() {
		return bezeichnung;
	}


	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}


	public String getBeschreibung() {
		return beschreibung;
	}


	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}


	public String getPreis() {
		return preis;
	}


	public void setPreis(String preis) {
		this.preis = preis;
	}


	public String getKategorie() {
		return kategorie;
	}


	public void setKategorie(String kategorie) {
		this.kategorie = kategorie;
	}
	
	
	

}
