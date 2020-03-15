package rovetown.testmod.init;

import java.util.function.Supplier;

import net.minecraft.item.AxeItem;
import net.minecraft.item.Food;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import rovetown.testmod.TestMod;
import rovetown.testmod.TestMod.TestModItemGroup;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Bus.MOD)
@ObjectHolder(TestMod.MODID)
public class ItemInit 
{
	//Items
	public static final Item steel_ingot = null;
	public static final Item crystal_casing = null;
	public static final Item crystal_casing_with_flow_control = null;
	public static final Item test_item = null;
	
	//Tools
	public static final Item test_hoe = null;
	public static final Item test_sword = null;
	public static final Item test_axe = null;
	public static final Item test_shovel = null;
	public static final Item test_pickaxe = null;
	
	//Food
	public static final Item test_food = null;
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> event) 
	{
		//Items
		event.getRegistry().register(new Item(new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("steel_ingot"));
		event.getRegistry().register(new Item(new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("crystal_casing"));
		event.getRegistry().register(new Item(new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("crystal_casing_with_flow_control"));
		event.getRegistry().register(new Item(new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_item"));
		
		//Tools
		event.getRegistry().register(new SwordItem(ModItemTier.TEST, 7, 2.2F, new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_sword"));
		event.getRegistry().register(new PickaxeItem(ModItemTier.TEST, 4, 1.2F, new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_pickaxe"));
		event.getRegistry().register(new AxeItem(ModItemTier.TEST, 10, 1.0F, new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_axe"));
		event.getRegistry().register(new ShovelItem(ModItemTier.TEST, 4, 1.2F, new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_shovel"));
		event.getRegistry().register(new HoeItem(ModItemTier.TEST, 1.2F, new Item.Properties().group(TestModItemGroup.instance)).setRegistryName("test_hoe"));
		
		//Food
		event.getRegistry().register(new Item(new Item.Properties().group(TestModItemGroup.instance).food(new Food.Builder().hunger(7).saturation(1.1f).meat().effect(new EffectInstance(Effects.JUMP_BOOST, 500, 2), 0.8f).build())).setRegistryName("test_food"));
	}
	
	public enum ModItemTier implements IItemTier
	{
		TEST(4, 1200, 12.0F, 6.0F, 20, () -> {
			return Ingredient.fromItems(ItemInit.test_item);
		});
		
		private final int harvestLevel;
		private final int maxUses;
		private final float efficiency;
		private final float attackDamage;
		private final int enchantability;
		private final LazyValue<Ingredient> repairMaterial;
		
		private ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) 
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = attackDamage;
			this.enchantability = enchantability;
			this.repairMaterial = new LazyValue<>(repairMaterial);
		}

		@Override
		public int getMaxUses()
		{
			return this.maxUses;
		}

		@Override
		public float getEfficiency()
		{
			return this.efficiency;
		}

		@Override
		public float getAttackDamage()
		{
			return this.attackDamage;
		}

		@Override
		public int getHarvestLevel()
		{
			return this.harvestLevel;
		}

		@Override
		public int getEnchantability()
		{
			return this.enchantability;
		}

		@Override
		public Ingredient getRepairMaterial()
		{
			return this.repairMaterial.getValue();
		}
	}
}
