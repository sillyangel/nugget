package dev.sillyangel.nuggetmod.block.custom;

import dev.sillyangel.nuggetmod.particle.ModParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;

public class NuggetCakeBlock extends CakeBlock {

    public NuggetCakeBlock(Properties properties) {
        super(properties);
    }

    protected static InteractionResult eat(LevelAccessor level, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.PASS;
        }

        // 🍗 custom particles
        if (level instanceof ServerLevel l) {
            l.sendParticles(
                    ModParticles.NUGGET_PARTICLE.get(), // replace with your custom particle if you have one
                    pos.getX() + 0.5,
                    pos.getY() + 0.5,
                    pos.getZ() + 0.5,
                    8,   // count
                    0.3, 0.3, 0.3, // spread
                    0.02 // speed
            );
        }

        player.awardStat(Stats.EAT_CAKE_SLICE);
        player.getFoodData().eat(2, 0.1F);

        int bites = state.getValue(BITES);
        level.gameEvent(player, GameEvent.EAT, pos);

        if (bites < MAX_BITES) {
            level.setBlock(pos, state.setValue(BITES, bites + 1), 3);
        } else {
            level.removeBlock(pos, false);
            level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
        }

        return InteractionResult.SUCCESS;
    }
}