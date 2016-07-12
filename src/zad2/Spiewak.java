/**
 *
 *  @author Idziak Marek S14453
 *
 */

package zad2;


public abstract class Spiewak{
	private String surname;
	private int startNumber;
	public static int index=0;
	public Spiewak(String surname){
		this.surname=surname;
		this.startNumber=++index;		
	}
	public abstract String spiewaj();
	public String toString(){
		return "("+startNumber+") "+surname+": "+spiewaj();
	}
	public static Spiewak najglosniej(Spiewak [] tab){
		int [] tabD=new int[tab.length];
		for(int i=0; i<tab.length; i++){
			String tekst = tab[i].spiewaj().substring(0,tab[i].spiewaj().length()-1);
			tekst=tekst.toLowerCase();
			int countDuze=0;
				for(int j=0; j<tekst.length(); j++){
					if(tab[i].spiewaj().charAt(j)!=tekst.charAt(j)){
						countDuze++;
					}
				}
				tabD[i]=countDuze;
		}
		Spiewak najglosniejszy=tab[0];
		int najwiecej=tabD[0];
			for(int i=0; i<tabD.length; i++){
				for(int j=i+1; j<tabD.length; j++){
					if(tabD[j]>najwiecej){
						najwiecej=tabD[j];
						najglosniejszy=tab[j];
					}
				}
			}
		return najglosniejszy;
	}
}
