package classes;

import java.util.UUID;

public class Kategorie {
	
	private SqlConnection jdbc;
	private String kategorieid;
	private String bezeichnung;
	
	/**
	 * 
	 * @param bezeichnung
	 * @throws Exception
	 */
	public Kategorie(String bezeichnung) throws Exception {
		super();
		this.kategorieid = UUID.randomUUID().toString();
		this.bezeichnung = bezeichnung;
		
		jdbc = new SqlConnection();
	}
	
	
	/**
	 * 
	 * @param kategorieid
	 * @param bezeichnung
	 * @throws Exception
	 */
	public Kategorie(String kategorieid, String bezeichnung) throws Exception {
		super();
		this.kategorieid = kategorieid;
		this.bezeichnung = bezeichnung;
		
		jdbc = new SqlConnection();
	}


	/**
	 * 
	 * @return
	 */
	public String getKategorieid() {
		return kategorieid;
	}


	/**
	 * 
	 * @param kategorieid
	 */
	public void setKategorieid(String kategorieid) {
		this.kategorieid = kategorieid;
	}


	/**
	 * 
	 * @return
	 */
	public String getBezeichnung() {
		return bezeichnung;
	}


	/**
	 * 
	 * @param bezeichnung
	 */
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void createKategorie() throws Exception
	{
		jdbc.createKategorie(kategorieid, bezeichnung);
	}
	
	
	/**
	 * 
	 * @throws Exception
	 */
	public void updateKategorie() throws Exception
	{
		jdbc.updateKategorie(kategorieid, bezeichnung);
	}
	
	
	

}
