package de.dataport.cottonwar.RMI;

import java.io.Serializable;

public class LpGoldExp implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer exp;
	Integer exp2;
	Integer gold;
	Integer gold2;
	Integer lp;
	Integer lp2;





	public LpGoldExp(Integer exp, Integer exp2, Integer gold, Integer gold2, Integer lp, Integer lp2) {
		super();
		this.exp = exp;
		this.exp2 = exp2;
		this.gold = gold;
		this.gold2 = gold2;
		this.lp = lp;
		this.lp2 = lp2;
	}





	@Override
	public String toString() {
		return "LpGoldExp exp=" + exp + ", exp2=" + exp2 + ", gold=" + gold + ", gold2=" + gold2 + ", Lp=" + lp + ", Lp2=" + lp2;
	}

	
}