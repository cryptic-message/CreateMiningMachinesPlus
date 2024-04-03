package net.cpike.createminingmachinesplus.block;

import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.cpike.createminingmachinesplus.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, CreateMiningMachinesPlus.MODID);

    public static final RegistryObject<Block> DENSE_IRON_ORE_BLOCK = registerBlock("dense_iron_ore_block",
            ()-> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE))
            );


    // Helper methods

    // Registers a block
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    // Registers an item to be associated with the block
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
