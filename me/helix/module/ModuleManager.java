package me.helix.module;

import java.util.ArrayList;

import me.helix.module.combat.AntiBot;
import me.helix.module.combat.AutoClicker;
import me.helix.module.combat.Reach;
import me.helix.module.combat.Velocity;
import me.helix.module.misc.SelfDestruct;
import me.helix.module.movement.Speedbridge;
import me.helix.module.movement.Sprint;
import me.helix.module.render.ClickGUI;
import me.helix.module.render.HUD;

public class ModuleManager {

	public ArrayList<Module> modules;
	
	public ModuleManager() {
		(modules = new ArrayList<Module>()).clear();
		this.modules.add(new ClickGUI());
		this.modules.add(new HUD());
		this.modules.add(new Sprint());
		this.modules.add(new AutoClicker());
		this.modules.add(new Velocity());
		this.modules.add(new AntiBot());
		this.modules.add(new SelfDestruct());
		this.modules.add(new Reach());
		this.modules.add(new Speedbridge());
	}
	
	public Module getModule(String name) {
		for (Module m : this.modules) {
			if (m.getName().equalsIgnoreCase(name)) {
				return m;
			}
		}
		return null;
	}
	
	public ArrayList<Module> getModuleList() {
		return this.modules;
	}
	
	public ArrayList<Module> getModulesInCategory(Category c) {
		ArrayList<Module> mods = new ArrayList<Module>();
		for (Module m : this.modules) {
			if (m.getCategory() == c) {
				mods.add(m);
			}
		}
		return mods;
	}
}
