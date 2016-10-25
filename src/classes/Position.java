package classes;

import java.util.UUID;

public class Position {

	private String positionid;
	private String artikelbezeichnung;
	private int menge;
	private double preis;

	/**
	 * 
	 * @param positionid
	 * @param artikelbezeichnung
	 * @param menge
	 * @param preis
	 * @throws Exception
	 */
	public Position(String positionid, String artikelbezeichnung, int menge, Double preis) throws Exception {
		super();
		this.positionid = UUID.randomUUID().toString();
		this.artikelbezeichnung = artikelbezeichnung;
		this.menge = menge;
		this.preis = preis;
	}

	/**
	 * 
	 * @return
	 */
	public String getPositionid() {
		return positionid;
	}

	/**
	 * 
	 * @param positionid
	 */
	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	/**
	 * 
	 * @return
	 */
	public String getArtikelbezeichnung() {
		return artikelbezeichnung;
	}

	/**
	 * 
	 * @param artikelbezeichnung
	 */
	public void setArtikelbezeichnung(String artikelbezeichnung) {
		this.artikelbezeichnung = artikelbezeichnung;
	}

	/**
	 * 
	 * @return
	 */
	public double getPreis() {
		return preis;
	}

	/**
	 * 
	 * @param preis
	 */
	public void setPreis(double preis) {
		this.preis = preis;
	}

	/**
	 * 
	 * @return
	 */
	public int getMenge() {
		return menge;
	}

	/**
	 * 
	 * @param menge
	 */
	public void setMenge(int menge) {
		this.menge = menge;
	}

}
