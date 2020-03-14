package rovetown.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
//import net.minecraft.item.Item;
//import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(TestMod.MODID)
public class TestMod 
{
  public static final String MODID = "testmod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static TestMod instance;
  
  public TestMod() 
  {
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    //FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
    FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
    
    instance = this;
    MinecraftForge.EVENT_BUS.register(this);
  }
  
  private void setup(final FMLCommonSetupEvent event) 
  {
    LOGGER.info("Setup method registered.");
  }
  
  private void clientRegistries(final FMLClientSetupEvent event) 
  {
    LOGGER.info("clientRegistries method registered.");
  }
  
  @SubscribeEvent
  public void onServerStarting(FMLServerStartingEvent event) 
  {
	  
  }
  
  /*public static class TestModItemGroup extends ItemGroup
  {
	  private TestModItemGroup(int index, String label) 
	  {
		  super(index, label);
	  }
	  
	  @Override
	  public ItemStack createIcon() 
	  {
		  return new ItemStack()
	  }
	}
  }
  
  /*@Mod.EventBusSubscriber(bus=Bus.MOD)
  public static class RegistryEvents
  {
	  @SubscribeEvent
	  public static void onBlockRegistry(final RegistryEvent.Register<Item> itemRegistryEvent) 
	  {
		  
	  }
  }*/
}