package rovetown.testmod.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import rovetown.testmod.TestMod;

import java.util.function.Supplier;

public class ModItemGroups extends ItemGroup{


        private final Supplier<ItemStack> iconSupplier;

        public ModItemGroups(final String name, final Supplier<ItemStack> iconSupplier) {
            super(name);
            this.iconSupplier = iconSupplier;
        }

        @Override
        public ItemStack createIcon() {
            return iconSupplier.get();
        }

        public static final ItemGroup MOD_ITEM_GROUP = new ModItemGroups(TestMod.MODID, () -> new ItemStack(Items.LIGHT_BLUE_BANNER));
    }
