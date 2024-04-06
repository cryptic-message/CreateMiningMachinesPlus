package net.cpike.createminingmachinesplus.block.miningDrill;

import com.jozufozu.flywheel.api.Instancer;
import com.jozufozu.flywheel.api.MaterialManager;
import com.simibubi.create.content.kinetics.base.SingleRotatingInstance;
import com.simibubi.create.content.kinetics.base.flwdata.RotatingData;
import net.cpike.createminingmachinesplus.CreateMiningMachinesPlus;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class MiningDrillInstance extends SingleRotatingInstance<MiningDrillBlockEntity> {
    public MiningDrillInstance(MaterialManager materialManager, MiningDrillBlockEntity blockEntity) {
        super(materialManager, blockEntity);
    }

    @Override
    protected Instancer<RotatingData> getModel() {
        BlockState referenceState = blockEntity.getBlockState();
        Direction facing = referenceState.getValue(BlockStateProperties.FACING);
        // TODO: create the mining drill head "partial model"
        return getRotatingMaterial().getModel(CreateMiningMachinesPlus.MINING_DRILL_HEAD, referenceState, facing);
    }

}
