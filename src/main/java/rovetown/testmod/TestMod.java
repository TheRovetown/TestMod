package rovetown.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TestMod.MODID)
public class TestMod {
  public static final String MODID = "testmod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  
  public TestMod() {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
  }
  
  private void setup(final FMLCommonSetupEvent event) {
    LOGGER.info("Setup method registered.");
  }
  
  private void clientRegistries(final FMLClientSetupEvent event) {
    LOGGER.info("clientRegistries method registered.");
  }
}