package net.cpike.createminingmachinesplus.item;

import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid= CreateMiningMachinesPlus.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, CreateMiningMachinesPlus.MODID);

    public static final RegistryObject<CreativeModeTab> CREATEMININGMACHINESPLUS_TAB = CREATIVE_MODE_TABS.register("createminingmachinesplus_tab",
            () -> CreativeModeTab.builder().icon(()-> new ItemStack(ModItems.TEST.get()))
                    .title(Component.translatable("creativetab.createminingmachinesplus_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.TEST.get());
                        pOutput.accept(ModItems.DRILLHEAD.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
