package net.cpike.createminingmachinesplus.block.ore;

import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.SpecialBlockStateGen;
import com.tterrag.registrate.providers.DataGenContext;
import com.tterrag.registrate.providers.RegistrateBlockstateProvider;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.ModelFile;

public class OreGenerator extends SpecialBlockStateGen {

  @Override
  protected int getXRotation(BlockState state) {
    return 0;
  }

  @Override
  protected int getYRotation(BlockState state) {
    return horizontalAngle(state.getValue(OreBlock.FACING));
  }

  @Override
  public <T extends Block> ModelFile getModel(DataGenContext<Block, T> ctx, RegistrateBlockstateProvider prov,
      BlockState state) {
    if (state.getValue(OreBlock.FACING).getAxis().isVertical())
      return AssetLookup.partialBaseModel(ctx, prov);
    return AssetLookup.partialBaseModel(ctx, prov, "directional");
  }

}
