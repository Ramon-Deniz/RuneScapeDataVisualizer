package RunescapeAPIInterface;

public class RunescapeHighscoresResponse {
	
	String username;
	
	int overall_rank;
	int overall_level;
	int overall_xp;
	
	RunescapeSkill attack = new RunescapeSkill("Attack");
	RunescapeSkill defence = new RunescapeSkill("Defence");
	RunescapeSkill strength = new RunescapeSkill("Strength");
	RunescapeSkill hitpoints = new RunescapeSkill("Hitpoints");
	RunescapeSkill ranged = new RunescapeSkill("Ranged");
	RunescapeSkill prayer = new RunescapeSkill("Prayer");
	RunescapeSkill magic = new RunescapeSkill("Magic");
	RunescapeSkill cooking = new RunescapeSkill("Cooking");
	RunescapeSkill woodcutting = new RunescapeSkill("Woodcutting");
	RunescapeSkill fletching = new RunescapeSkill("Fletching");
	RunescapeSkill fishing = new RunescapeSkill("Fishing");
	RunescapeSkill firemaking = new RunescapeSkill("Firemaking");
	RunescapeSkill crafting = new RunescapeSkill("Crafting");
	RunescapeSkill smithing = new RunescapeSkill("Smithing");
	RunescapeSkill mining = new RunescapeSkill("Mining");
	RunescapeSkill herblore = new RunescapeSkill("Herblore");
	RunescapeSkill agility = new RunescapeSkill("Agility");
	RunescapeSkill thieving = new RunescapeSkill("Thieving");
	RunescapeSkill slayer = new RunescapeSkill("Slayer");
	RunescapeSkill farming = new RunescapeSkill("Farming");
	RunescapeSkill runecraft = new RunescapeSkill("Runecraft");
	RunescapeSkill hunter = new RunescapeSkill("Hunter");
	RunescapeSkill construction = new RunescapeSkill("Construction");
	
	// Minigames
	RunescapeMinigame clueScrollsEasy;
	RunescapeMinigame clueScrollsMedium;
	RunescapeMinigame clueScrollsAll;
	RunescapeMinigame bountyHunter_Rogue;
	RunescapeMinigame bountyHunter_Hunter;
	RunescapeMinigame clueScrollsHard;
	RunescapeMinigame clueScrollsElite;
	
	public RunescapeHighscoresResponse(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		// Username
		builder.append(String.format("Username: %s\n", username));
		
		// Overall
		String overallFormat = "%15s %10d %10d %10d\n";
		builder.append(String.format("%15s %10s %10s %10s\n", "", "Rank", "Level", "XP"));
		builder.append(String.format(overallFormat + "\n", "Overall", overall_rank, overall_level, overall_xp));
		
		// Skills
		String skillStrFormat = "%15s %10d %10d %10d\n";
		builder.append(String.format(skillStrFormat, attack.skillname, attack.rank, attack.level, attack.xp));
		builder.append(String.format(skillStrFormat, defence.skillname, defence.rank, defence.level, defence.xp));
		builder.append(String.format(skillStrFormat, strength.skillname, strength.rank, strength.level, strength.xp));
		builder.append(String.format(skillStrFormat, hitpoints.skillname, hitpoints.rank, hitpoints.level, hitpoints.xp));
		builder.append(String.format(skillStrFormat, ranged.skillname, ranged.rank, ranged.level, ranged.xp));
		builder.append(String.format(skillStrFormat, prayer.skillname, prayer.rank, prayer.level, prayer.xp));
		builder.append(String.format(skillStrFormat, magic.skillname, magic.rank, magic.level, magic.xp));
		builder.append(String.format(skillStrFormat, cooking.skillname, cooking.rank, cooking.level, cooking.xp));
		builder.append(String.format(skillStrFormat, woodcutting.skillname, woodcutting.rank, woodcutting.level, woodcutting.xp));
		builder.append(String.format(skillStrFormat, fletching.skillname, fletching.rank, fletching.level, fletching.xp));
		builder.append(String.format(skillStrFormat, fishing.skillname, fishing.rank, fishing.level, fishing.xp));
		builder.append(String.format(skillStrFormat, firemaking.skillname, firemaking.rank, firemaking.level, firemaking.xp));
		builder.append(String.format(skillStrFormat, crafting.skillname, crafting.rank, crafting.level, crafting.xp));
		builder.append(String.format(skillStrFormat, smithing.skillname, smithing.rank, smithing.level, smithing.xp));
		builder.append(String.format(skillStrFormat, mining.skillname, mining.rank, mining.level, mining.xp));
		builder.append(String.format(skillStrFormat, herblore.skillname, herblore.rank, herblore.level, herblore.xp));
		builder.append(String.format(skillStrFormat, agility.skillname, agility.rank, agility.level, agility.xp));
		builder.append(String.format(skillStrFormat, thieving.skillname, thieving.rank, thieving.level, thieving.xp));
		builder.append(String.format(skillStrFormat, slayer.skillname, slayer.rank, slayer.level, slayer.xp));
		builder.append(String.format(skillStrFormat, farming.skillname, farming.rank, farming.level, farming.xp));
		builder.append(String.format(skillStrFormat, runecraft.skillname, runecraft.rank, runecraft.level, runecraft.xp));
		builder.append(String.format(skillStrFormat, hunter.skillname, hunter.rank, hunter.level, hunter.xp));
		builder.append(String.format(skillStrFormat, construction.skillname, construction.rank, construction.level, construction.xp));
		
		return builder.toString();
	}
}
