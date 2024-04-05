package net.cpike.createminingmachinesplus.block.miningDrill;

import com.simibubi.create.AllBlockEntityTypes;
import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import com.simibubi.create.foundation.block.IBE;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;

public class MiningDrillBlock extends KineticBlock implements IBE<MiningDrillBlockEntity>, ICogWheel {

  public MiningDrillBlock(Properties properties) {
    super(properties);
  }

  @Override
  public Axis getRotationAxis(BlockState state) {
    return Axis.Y;
  }

  @Override
  public BlockEntityType<? extends MiningDrillBlockEntity> getBlockEntityType() {
    // TODO: create entry for Mechanical Drill
    return AllBlockEntityTypes.MECHANICAL_DRILL.get();
  }

  @Override
  public boolean isPathfindable(BlockState state, BlockGetter reader, BlockPos pos, PathComputationType type) {
    return false;
  }

  @Override
  public Class<MiningDrillBlockEntity> getBlockEntityClass() {
    return MiningDrillBlockEntity.class;
  }

}
