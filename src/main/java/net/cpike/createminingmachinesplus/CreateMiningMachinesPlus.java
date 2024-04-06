package net.cpike.createminingmachinesplus;

import com.jozufozu.flywheel.core.PartialModel;
import com.mojang.logging.LogUtils;
import static com.simibubi.create.Create.REGISTRATE;

import com.simibubi.create.Create;
import com.tterrag.registrate.util.entry.BlockEntityEntry;
import net.cpike.createminingmachinesplus.block.ModBlocks;
import net.cpike.createminingmachinesplus.block.miningDrill.MiningDrillBlockEntity;
import net.cpike.createminingmachinesplus.block.miningDrill.MiningDrillRenderer;
import net.cpike.createminingmachinesplus.block.ore.OreBlockEntity;
import net.cpike.createminingmachinesplus.item.ModCreativeModeTab;
import net.cpike.createminingmachinesplus.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CreateMiningMachinesPlus.MODID)
public class CreateMiningMachinesPlus
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "createminingmachinesplus";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // Register Block Entity Types

    // Register Mining Drill Block Entity type
    public static final BlockEntityEntry<MiningDrillBlockEntity> MINING_DRILL_BLOCK_ENTITY = REGISTRATE
            .blockEntity("mining_drill", MiningDrillBlockEntity::new)
            //.instance(() -> MiningDrillBlockEntity::new, false)  // <- do we need this? what do it do? it giveth red squiggles...
            .validBlocks(ModBlocks.MINING_DRILL)
            .renderer(() -> MiningDrillRenderer::new)
            .register();

    // TODO: finish the ore block entity entry
    // notes: - no renderer needed as the block entity data can just be
    // hidden while the block is rendered as a normal block, maybe?

    // Register the Ore Block
    public static final BlockEntityEntry<OreBlockEntity> ORE_BLOCK_ENTITY = REGISTRATE
            .blockEntity("ore", OreBlockEntity::new)
            // .validBlocks()           // Valid ore blocks go here
            .register();

    // Register partial-model for Mining Drill Head
    public static final PartialModel MINING_DRILL_HEAD = new PartialModel(Create.asResource("block/mining_drill_head"));



    public CreateMiningMachinesPlus()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register items
        ModItems.register(modEventBus);

        // Register blocks
        ModBlocks.register(modEventBus);

        // Register creative mode tab
        ModCreativeModeTab.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
        LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.TEST);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            // Some client setup code
            LOGGER.info("HELLO FROM CLIENT SETUP");
            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        }
    }

}
