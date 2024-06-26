package net.cpike.createminingmachinesplus.block.ore;

import java.util.List;

import com.simibubi.create.content.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.item.SmartInventory;

import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.cpike.createminingmachinesplus.block.miningDrill.MiningDrillBlock;
import net.cpike.createminingmachinesplus.block.miningDrill.MiningDrillBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public class OreBlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

  /*
   * TODO: create entire class lol, basically the only NEEDED function is the
   * behaviour of ore. I think the easiest way to do this is by giving each ore
   * block a hidden "inventory" of sorts.
   */

  public OreInventory inputInventory;
  protected SmartInventory outputInventory;
  private boolean contentsChanged;
  private BlockPos expectedMiningDrillPosition = new BlockPos(worldPosition.getX(), worldPosition.getY(), worldPosition.getZ());

  public OreBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
    super(type, pos, state);
    // TODO Auto-generated constructor stub
  }

  @Override
  public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'addBehaviours'");
  }

  public void readOnlyItems(CompoundTag compound) {
    inputInventory.deserializeNBT(compound.getCompound("InputItems"));
    outputInventory.deserializeNBT(compound.getCompound("OutputItems"));
  }

  public void notifyChangeOfContents() {
    contentsChanged = true;
  }

  public boolean hasMiningDrillAbove() {
      if(level == null)
          return false;

      if(level.getBlockEntity(expectedMiningDrillPosition).getType() != CreateMiningMachinesPlus.MINING_DRILL_BLOCK_ENTITY.get())
          return false;


      return true;
  }
}
