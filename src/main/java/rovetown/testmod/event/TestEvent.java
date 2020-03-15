package rovetown.testmod.event;

/*import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
//import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;*/
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import rovetown.testmod.TestMod;
//import rovetown.testmod.init.BlockInit;

@Mod.EventBusSubscriber(modid = TestMod.MODID, bus = Bus.FORGE)
public class TestEvent
{
	/*@SubscribeEvent
	public static void testEvent(LivingJumpEvent event)
	{
		TestMod.LOGGER.info("testJumpEvent fired");
		LivingEntity livingEntity = event.getEntityLiving();
		//World world = livingEntity.getEntityWorld();
		//world.setBlockState(livingEntity.getPosition().add(0, 2, 0), BlockInit.test_block.getDefaultState());
		livingEntity.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 500, 2));
		livingEntity.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 500, 19));
		//livingEntity.applyOrientationToEntity(livingEntity);
		livingEntity.addVelocity(3, 1, 2);
		livingEntity.canBeRiddenInWater();
		livingEntity.canPassengerSteer();
		//livingEntity.setNoGravity(true);
		//livingEntity.setGlowing(true);
	}*/
}
