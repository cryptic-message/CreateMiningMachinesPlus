package net.cpike.createminingmachinesplus.block.ore;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.foundation.block.IBE;

import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class OreBlock extends Block implements IBE<OreBlockEntity> {

  public static final DirectionProperty FACING = BlockStateProperties.FACING_HOPPER;

  public OreBlock(Properties p_i48440_1_) {
    super(p_i48440_1_);
    registerDefaultState(defaultBlockState().setValue(FACING, Direction.DOWN));
  }

  @Override
  public Class<OreBlockEntity> getBlockEntityClass() {
    return OreBlockEntity.class;
  }

  @Override
  public BlockEntityType<? extends OreBlockEntity> getBlockEntityType() {
    // TODO: make ORE class thing like in Basin (which is my inspo) this is located
    // in the allBlockEntity.java file
    return AllBlockEntityTypes.ORE.get();
  }

}
