package RunescapeAPIInterface;

public class RunescapeSkill {
	String skillname;
	int rank;
	int level;
	int xp;
	
	public RunescapeSkill(String skillname) {
		this.skillname = skillname;
		this.rank = -1;
		this.level = -1;
		this.xp = -1;
	}
}
