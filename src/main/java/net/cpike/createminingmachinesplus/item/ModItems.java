package net.cpike.createminingmachinesplus.item;

import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.cpike.createminingmachinesplus.item.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CreateMiningMachinesPlus.MODID);


    //  to add a new item:
    //      1. first add entry here (see test entry)
    //      2. in CreateMiningMachinesPlus.java, add a 'event.accept' call to the addCreative function.
    //      3. go to resources/lang/en_us.json and add an entry to translate for the game
    //      4. go to /models/item and add a <name>.json file, note that <name> must be the 'name:' specified in the RegistryObject<Item> instance.
    //          5. in <name>.json, copy the test example or do other things
    //      6. go to /textures/item and add a sprite for the item
    //      7. add to the .displayItems line in ModCreativeModeTab.java

    // test entry begin
    public static final RegistryObject<Item> TEST = ITEMS.register("test",
            () -> new Item( new Item.Properties() )
    );
    // end of test entry



    public static void register (IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
