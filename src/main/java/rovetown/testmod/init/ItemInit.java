package rovetown.testmod.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import rovetown.testmod.TestMod;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Bus.MOD)
@ObjectHolder(TestMod.MODID)
public class ItemInit 
{
	public static final Item steel_ingot = null;
	public static final Item test_item = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("test_item"));
		event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MATERIALS)).setRegistryName("steel_ingot"));
	}
}
