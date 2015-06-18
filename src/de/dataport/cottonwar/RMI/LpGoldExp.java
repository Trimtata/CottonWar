package de.dataport.cottonwar.RMI;

import java.io.Serializable;
import java.util.List;

import de.dataport.cottonwar.objekte.Einheit;

public class LpGoldExp implements Serializable {

	private static final long serialVersionUID = 1L;

	public int exp;
	public int exp2;
	public Integer gold;
	public int gold2;
	public int lp;
	public int lp2;
	
	public boolean evolutionClient;
	public boolean evolutionServer;
	public List<Einheit> einheitenClient;
	public List<Einheit> einheitenServer;

	public LpGoldExp(int exp, int exp2, Integer gold, int gold2, int lp, int lp2, List<Einheit> einheitenClient, List<Einheit> einheitenServer, boolean evolutionClient, boolean evolutionServer) {
		super();
		this.exp = exp;
		this.exp2 = exp2;
		this.gold = gold;
		this.gold2 = gold2;
		this.lp = lp;
		this.lp2 = lp2;
		this.einheitenClient = einheitenClient;
		this.einheitenServer = einheitenServer;
		this.evolutionClient = evolutionClient;
		this.evolutionServer = evolutionServer;
	}

	@Override
	public String toString() {
		return "LpGoldExp exp=" + exp + ", exp2=" + exp2 + ", gold=" + gold + ", gold2=" + gold2 + ", Lp=" + lp + ", Lp2=" + lp2;
	}

}