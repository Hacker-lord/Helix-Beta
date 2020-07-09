package me.helix.module.combat;

import me.helix.Helix;
import me.helix.module.Category;
import me.helix.module.Module;
import me.helix.settings.Setting;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity extends Module {

	public Velocity() {
		super("Velocity", "Reduces knockback", Category.COMBAT);
		Helix.instance.settingsManager.rSetting(new Setting("Horizontal", this, 90, 0, 100, true));
		Helix.instance.settingsManager.rSetting(new Setting("Vertical", this, 100, 0, 100, true));
	}
	
	@SubscribeEvent
	public void onLivingUpdate(LivingUpdateEvent e) {
		if (Helix.instance.destructed) {
			return;
		}
		if (mc.thePlayer == null) {
			return;
		}
		float horizontal = (float) Helix.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
		float vertical = (float) Helix.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();
		
		if (mc.thePlayer.hurtTime == mc.thePlayer.maxHurtTime && mc.thePlayer.maxHurtTime > 0) {
			mc.thePlayer.motionX *= (float) horizontal / 100;
			mc.thePlayer.motionY *= (float) vertical / 100;
			mc.thePlayer.motionZ *= (float) horizontal / 100;
		}
	}
}
