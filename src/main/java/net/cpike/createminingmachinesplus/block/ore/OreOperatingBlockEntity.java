package net.cpike.createminingmachinesplus.block.ore;

import java.util.List;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.simple.DeferralBehaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

public abstract class OreOperatingBlockEntity extends KineticBlockEntity {

  public DeferralBehaviour oreChecker;

  public OreOperatingBlockEntity(BlockEntityType<?> typeIn, BlockPos pos, BlockState state) {
    super(typeIn, pos, state);
  }

  // TODO: implement relevant oreOperatingBlockEntity stuff

  @Override
  public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    super.addBehaviours(behaviours);

    // FIX: ↓
    oreChecker = new DeferralBehaviour(this, this::updateOre);
    behaviours.add(oreChecker);
  }

  private DeferralBehaviour updateOre() {
    // TODO: implement this function

    // ↓ from basin
    /*
     * if (!isSpeedRequirementFulfilled())
     * return true;
     * if (getSpeed() == 0)
     * return true;
     * if (isRunning())
     * return true;
     * if (level == null || level.isClientSide)
     * return true;
     * Optional<BasinBlockEntity> basin = getBasin();
     * if (!basin.filter(BasinBlockEntity::canContinueProcessing)
     * .isPresent())
     * return true;
     * 
     * List<Recipe<?>> recipes = getMatchingRecipes();
     * if (recipes.isEmpty())
     * return true;
     * currentRecipe = recipes.get(0);
     * startProcessingBasin();
     * sendData();
     * return true;
     */

    return null;
  }

}
