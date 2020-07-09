package me.helix;

import org.lwjgl.input.Keyboard;

import me.helix.autosave.SaveLoad;
import me.helix.clickgui.ClickGui;
//import me.helix.event.EventManager;
import me.helix.module.Module;
import me.helix.module.ModuleManager;
import me.helix.settings.Setting;
import me.helix.settings.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraft.util.Session;

public class Helix
{
    public static Helix instance;
    public ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public ClickGui clickGui;
    public SaveLoad saveLoad;
    
    public boolean destructed = false;
    
    public void init() {
    	MinecraftForge.EVENT_BUS.register(this);
    	settingsManager = new SettingsManager();
    	moduleManager = new ModuleManager();
    	clickGui = new ClickGui();
    	saveLoad = new SaveLoad();
    }
    
    @SubscribeEvent
    public void key(KeyInputEvent e) {
    	if (Minecraft.getMinecraft().theWorld == null || Minecraft.getMinecraft().thePlayer == null)
    		return; 
    	try {
             if (Keyboard.isCreated()) {
                 if (Keyboard.getEventKeyState()) {
                     int keyCode = Keyboard.getEventKey();
                     if (keyCode <= 0)
                    	 return;
                     for (Module m : moduleManager.modules) {
                    	 if (m.getKey() == keyCode && keyCode > 0) {
                    		 m.toggle();
                    	 }
                     }
                 }
             }
         } catch (Exception q) { q.printStackTrace(); }
    }
    
    public void onDestruct() {
    	if (Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().thePlayer != null) {
    		Minecraft.getMinecraft().thePlayer.closeScreen();
    	}
    	destructed = true;
    	MinecraftForge.EVENT_BUS.unregister(this);
    	for (int k = 0; k < this.moduleManager.modules.size(); k++) {
    		Module m = this.moduleManager.modules.get(k);
    		MinecraftForge.EVENT_BUS.unregister(m);
    		this.moduleManager.getModuleList().remove(m); 
    	}
    	this.moduleManager = null;
    	this.clickGui = null;
    }
	public static Helix getInstance(){
		if(instance == null){
			instance = new Helix();
		}
		return instance;
	}
	/*
	public EventManager getEventManager(){
		if(eventManager == null){
			eventManager = new EventManager();
		}
		return eventManager;
	}
	public boolean isEnabled(){
		return enabled;
	}
	*/
}
