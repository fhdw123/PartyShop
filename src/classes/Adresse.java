package classes;

public class Adresse {
	
	private int adresseid;
	private String strasse;
	private String hausnummer;
    private String postleitzahl;
    private String ort;
    
    
	public Adresse(int adresseid, String strasse, String hausnummer, String postleitzahl, String ort) {
		super();
		this.adresseid = adresseid;
		this.strasse = strasse;
		this.hausnummer = hausnummer;
		this.postleitzahl = postleitzahl;
		this.ort = ort;
	}


	public int getAdresseid() {
		return adresseid;
	}


	public void setAdresseid(int adresseid) {
		this.adresseid = adresseid;
	}


	public String getStrasse() {
		return strasse;
	}


	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}


	public String getHausnummer() {
		return hausnummer;
	}


	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}


	public String getPostleitzahl() {
		return postleitzahl;
	}


	public void setPostleitzahl(String postleitzahl) {
		this.postleitzahl = postleitzahl;
	}


	public String getOrt() {
		return ort;
	}


	public void setOrt(String ort) {
		this.ort = ort;
	}
    
    
    

}
