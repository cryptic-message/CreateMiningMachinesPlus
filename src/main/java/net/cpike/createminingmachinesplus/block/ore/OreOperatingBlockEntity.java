package net.cpike.createminingmachinesplus.block.ore;

import java.util.List;
import java.util.Optional;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.blockEntity.behaviour.simple.DeferralBehaviour;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;


public abstract class OreOperatingBlockEntity extends KineticBlockEntity {

  public DeferralBehaviour oreChecker;
  public boolean oreRemoved;
  protected Recipe<?> currentRecipe;

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

  private boolean updateOre() {
    // TODO: implement updateOre() (started)

    if (getSpeed() == 0)
        return true;
    else if (level == null || level.isClientSide() )
        return true;

    // TODO: implement getMatchingOreRecipe()
    currentRecipe = getMatchingOreRecipe();

    if (currentRecipe == null)
        return true;

    // TODO: implement startProcessingOre();
    startProcessingOre();
    sendData();

    return true;

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
  }

  private void startProcessingOre() {
      // this will do whatever is needed to process/generate ore from the deposit

  }

  protected Recipe<?> getMatchingOreRecipe() {
      // TODO: implement getMatchingOreRecipe() - this will check the ore deposit type and return a Recipe object
      if(getOreBlock().map(OreBlockEntity::hasMiningDrillAbove).orElse(true))
          return null;

      return null;
  }

  protected Optional<OreBlockEntity> getOreBlock(){
      // TODO: implement getOreBlock()

      return null;
  }

}
