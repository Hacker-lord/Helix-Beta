package me.helix.module.combat;

import me.helix.Helix;
import me.helix.module.Category;
import me.helix.module.Module;
import me.helix.settings.Setting;

public class Reach extends Module {

	public Reach() {
		super("Reach", "Gives you extra reach.", Category.COMBAT);
		Helix.instance.settingsManager.rSetting(new Setting("Combat Reach", this, 3, 3, 5, true));
		Helix.instance.settingsManager.rSetting(new Setting("Normal Reach", this, 3, 3, 10, true));
	}
	
}