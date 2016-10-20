package classes;

public class Position {

	
	private String positionid;
	private Artikel artikel;
	private int menge;
	
	
	
	
	
	public Position(String positionid, Artikel artikel, int menge) {
		super();
		this.positionid = positionid;
		this.artikel = artikel;
		this.menge = menge;
	}
	
	
	public String getPositionid() {
		return positionid;
	}
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}
	public Artikel getArtikel() {
		return artikel;
	}
	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	
	
	
	
	
}
