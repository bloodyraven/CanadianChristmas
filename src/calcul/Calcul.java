package calcul;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import bean.Data;
import bean.Family;

public class Calcul {
	
	public Calcul(Data data) {
		HashMap<String, String> map;
		ArrayList<String> listeNoms = new ArrayList<String>();
		for (Family family : data.getFamilies()) {
			for (String nom : family.getMembers()) {
				listeNoms.add(nom);
			}
		}
		
		boolean flag;
		
		do{
			flag=true;
			Collections.shuffle(listeNoms);
			map = new HashMap<String, String>();
			for (int i = 0; i < listeNoms.size() ; i++) {
				try {
					map.put(listeNoms.get(i), listeNoms.get(i+1));
				} catch (Exception e) {
					map.put(listeNoms.get(i), listeNoms.get(0));
				}
				
			}
			Iterator<Entry<String, String>> it = map.entrySet().iterator();
			while(it.hasNext()) {
				Entry<String, String> entry = it.next();
				for (Family fam : data.getFamilies()) {
					if(fam.getMembers().contains(entry.getKey())) {
						for (String nom : fam.getMembers()) {
							if(nom.equals(entry.getValue())) {
								flag = false;
							}
						}
					}
				}
			}
			System.out.println(flag+" "+map.toString());
		}while(!flag);
		
	}

}
