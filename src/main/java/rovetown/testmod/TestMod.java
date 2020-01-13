package rovetown.testmod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import rovetown.testmod.lists.ItemList;


@Mod("testmod")
public class TestMod
{
	public static TestMod instance;
	
	public static final String modid = "testmod";
	private static final Logger logger = LogManager.getLogger(modid);
	
	public TestMod()
	{
		instance = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		logger.info("Setup method registered.");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("clientRegistries method registered.");
	}
	
	@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents
	{
		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) 
		{
			event.getRegistry().registerAll
			(
					ItemList.test_item = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(new ResourceLocation(modid, "test_item"))
			);
			
			logger.info("items registered");
		}
		
		/*private static ResourceLocation location(String name) 
		{
			return new ResourceLocation(modid, name);
		}*/
	}
}