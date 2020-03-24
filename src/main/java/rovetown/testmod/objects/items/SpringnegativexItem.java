package rovetown.testmod.objects.items;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import rovetown.testmod.util.helper.KeyboardHelper;

public class SpringnegativexItem extends Item
{

	public SpringnegativexItem(Properties properties)
	{
		super(properties);
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
	{
		if(KeyboardHelper.isHoldingShift())
		{
			tooltip.add(new StringTextComponent("Fly to negative x values!"));
			tooltip.add(new StringTextComponent("Just right click"));
		} else {
			tooltip.add(new StringTextComponent("Hold" + "\u00A75" + " SHIFT " + "\u00A75" + "for more Information"));
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
	{
		playerIn.addVelocity(-3, 2, 0);
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
}