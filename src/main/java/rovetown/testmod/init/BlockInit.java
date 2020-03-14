package rovetown.testmod.init;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import rovetown.testmod.TestMod;

@ObjectHolder(TestMod.MODID)
@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Bus.MOD)
public class BlockInit 
{
	public static final Block test_block = null;
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> event) 
	{
		event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(1.4f, 15.0f).sound(SoundType.STONE).harvestTool(ToolType.PICKAXE)).setRegistryName("test_block"));
	}
	
	@SubscribeEvent
	public static void registerBlockItems(final RegistryEvent.Register<Item> event) 
	{
		event.getRegistry().register(new BlockItem(test_block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("test_block"));
	}
}
