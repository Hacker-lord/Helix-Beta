import me.helix.Helix;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "Metastrokes", version = "1.0.0")
public class Main {

    @EventHandler
    public void init(FMLInitializationEvent event) {
    	Helix.instance = new Helix();
    	Helix.instance.init();
    	System.out.println("");
    	System.out.println("MetaStrokes Started.");
    	System.out.println("");
    }
}
