package net.cpike.createminingmachinesplus.block;

import static com.simibubi.create.Create.REGISTRATE;
import static com.simibubi.create.foundation.data.TagGen.axeOrPickaxe;
import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.ModelGen.customItemModel;
import static com.simibubi.create.AllMovementBehaviours.movementBehaviour;

import com.simibubi.create.content.kinetics.BlockStressDefaults;
import com.simibubi.create.content.processing.AssemblyOperatorBlockItem;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SharedProperties;
import com.simibubi.create.foundation.data.ModelGen;

import com.tterrag.registrate.util.entry.BlockEntry;

import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.cpike.createminingmachinesplus.item.ModItems;
import net.cpike.createminingmachinesplus.block.miningDrill.MiningDrillBlock;
import net.cpike.createminingmachinesplus.block.ore.OreBlock;
import net.cpike.createminingmachinesplus.block.ore.OreGenerator;
import net.cpike.createminingmachinesplus.block.ore.OreMovementBehaviour;

import net.minecraft.client.renderer.RenderType;
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
  public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
      CreateMiningMachinesPlus.MODID);

  public static final RegistryObject<Block> IRON_ORE_DEPOSIT = registerBlock("iron_ore_deposit",
      () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)));

  public static final BlockEntry<MiningDrillBlock> MINING_DRILL = REGISTRATE
      .block("mining_drill", MiningDrillBlock::new)
      .initialProperties(SharedProperties::stone)
      // TODO: figure out what properties are needed
      .properties(p -> p.noOcclusion().color(MaterialColor.STONE))
      .transform(axeOrPickaxe())
      .blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
      .transform(BlockStressDefaults.setImpact(4.0))
      .item(AssemblyOperatorBlockItem::new)
      .transform(customItemModel())
      .register();

  public static final BlockEntry<OreBlock> RE = REGISTRATE.block("ore", OreBlock::new)
      .initialProperties(SharedProperties::stone)
      // TODO: figure out what properties are needed
      .properties(p -> p.color(MaterialColor.COLOR_GRAY).sound(SoundType.NETHERITE_BLOCK))
      .transform(pickaxeOnly())
      .blockstate(new OreGenerator()::generate)
      // TODO: write OreMovementBehaviour to suit mining process
      // figure out inventory as well
      .onRegister(movementBehaviour(new OreMovementBehaviour()))
      .item()
      .transform(customItemModel("_", "block"))
      .register();

  // Helper methods

  // Registers a block
  private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
    RegistryObject<T> toReturn = BLOCKS.register(name, block);
    registerBlockItem(name, toReturn);
    return toReturn;
  }

  // Registers an item to be associated with the block
  private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
    return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
  }

  public static void register(IEventBus eventBus) {
    BLOCKS.register(eventBus);
  }
}
