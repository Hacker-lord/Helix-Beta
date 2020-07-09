package me.helix.module.misc;

import org.lwjgl.input.Keyboard;

import me.helix.Helix;
import me.helix.module.Category;
import me.helix.module.Module;

public class SelfDestruct extends Module {

	public SelfDestruct() {
		super("SelfDestruct", "Destructs", Category.MISC);
		//this.setKey(Keyboard.KEY_P);
	}

	@Override
	public void onEnable() {
		Helix.instance.onDestruct();
	}
}
