package bean;

import java.util.ArrayList;

public class Data {

	ArrayList<Family> families = new ArrayList<Family>();
	
	public Data() {}
	
	public ArrayList<Family> getFamilies() {
		return families;
	}

	public void setFamilies(ArrayList<Family> families) {
		this.families = families;
	}
}
