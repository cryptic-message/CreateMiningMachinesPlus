package net.cpike.createminingmachinesplus.block.miningDrill;

import com.simibubi.create.content.kinetics.base.KineticBlock;
import com.simibubi.create.content.kinetics.simpleRelays.ICogWheel;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.state.BlockState;

public class MiningDrillBlock extends KineticBlock implements ICogWheel {


    public MiningDrillBlock(Properties properties) {
        super(properties);
    }

    @Override
    public Axis getRotationAxis(BlockState state) {
        return Axis.Y;
    }

//    @Override
//    public SpeedLevel getMinimumRequiredSpeed() {
//        return SpeedLevel.MEDIUM;
//    }

}
