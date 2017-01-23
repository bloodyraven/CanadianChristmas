package bean;

import java.util.ArrayList;

public class Family {

	private String nomFamille;
	private ArrayList<String> members;
	
	public Family() {
		members = new ArrayList<String>();
	}

	public ArrayList<String> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<String> members) {
		this.members = members;
	}
	
	public String[] getTabMembers() {
		return (String[]) members.toArray();
	}

	public String getNomFamille() {
		return nomFamille;
	}

	public void setNomFamille(String nomFamille) {
		this.nomFamille = nomFamille;
	}
	
}
