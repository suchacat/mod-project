package net.suchacat.firstmod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.suchacat.firstmod.FirstMod;

public final class BlockItems {
    public static final Block test = register(new Block(Block.Settings.create().strength(4.0f)), "test");

    private static Block register(Block block, String path) {
        Registry.register(Registries.BLOCK, Identifier.of("test", path), block);
        Registry.register(Registries.ITEM, Identifier.of("test", path), new BlockItem(block, new Item.Settings()));
        return block;
    }



    public static void initialize() {
        FirstMod.LOGGER.info("Registering Custom Block Item... " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(test);
        });
    }
}


