package rovetown.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
//import net.minecraft.item.Item;
//import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
//import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rovetown.testmod.init.ItemInit;
import rovetown.testmod.world.gen.TestOreGen;

@Mod(TestMod.MODID)
@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Bus.MOD)
public class TestMod 
{
  public static final String MODID = "testmod";
  public static final Logger LOGGER = LogManager.getLogger(MODID);
  public static TestMod instance;
  
  public TestMod() 
  {
    final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::setup);
    //modEventBus.addListener(this::doClientStuff);
    modEventBus.addListener(this::clientRegistries);
    
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
  
  @SubscribeEvent
  public static void loadCompleteEvent(FMLLoadCompleteEvent event)
  {
	  TestOreGen.generateOre();
  }
  
  public static class TestModItemGroup extends ItemGroup
  {
	  public static final TestModItemGroup instance = new TestModItemGroup(ItemGroup.GROUPS.length, "testtab");
	  private TestModItemGroup(int index, String label) 
	  {
		  super(index, label);
	  }
	  
	  @Override
	  public ItemStack createIcon()
	  {
		  return new ItemStack(ItemInit.crystal_casing);
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