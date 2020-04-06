package rovetown.testmod.world.gen;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import rovetown.testmod.init.BlockInit;

public class TestOreGen
{
	public static void generateOre() 
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			if(biome == Biomes.MOUNTAINS)
			{
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(18, 7, 2, 60));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.test_block.getDefaultState(), 20)).withPlacement(customConfig));
			} else if(biome == Biomes.OCEAN) {
				ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig(18, 7, 2, 60));
				biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.test_block.getDefaultState(), 20)).withPlacement(customConfig));
			}
		}
	}
}