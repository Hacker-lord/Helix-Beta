package me.helix.module.render;

import org.lwjgl.input.Keyboard;

import me.helix.Helix;
import me.helix.module.Category;
import me.helix.module.Module;

public class ClickGUI extends Module {

	public ClickGUI() {
		super("ClickGUI", "Allows you to enable and disable modules", Category.RENDER);
		this.setKey(Keyboard.KEY_RSHIFT);
	}
	
	@Override
	public void onEnable() {
		super.onEnable();
		mc.displayGuiScreen(Helix.instance.clickGui);
		this.setToggled(false);
	}
}
