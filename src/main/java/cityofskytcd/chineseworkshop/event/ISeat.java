package cityofskytcd.chineseworkshop.event;

import java.util.List;

import cityofskytcd.chineseworkshop.CW;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public interface ISeat {

	public Vec3d getSeat(IBlockState state);

	public static class Seat extends Entity {

		public Seat(World world, Vec3d pos) {
			this(world);
			setPosition(pos.xCoord, pos.yCoord + 0.001, pos.zCoord);
		}

		public Seat(World par1World) {
			super(par1World);
			setSize(0F, 0F);
		}

		@Override
		public void onUpdate() {
			super.onUpdate();

			// if (worldObj.isRemote) {
			BlockPos pos = getPosition();
			if (pos == null || !(getEntityWorld().getBlockState(pos).getBlock() instanceof ISeat)) {
				setDead();
				return;
			}

			List<Entity> passangers = getPassengers();
			CW.log(passangers);
			if (passangers.isEmpty())
				setDead();
			for (Entity e : passangers)
				if (e.isSneaking())
					setDead();
			// }
		}

		@Override
		protected void entityInit() {
		}

		@Override
		protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
		}

		@Override
		protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
		}
	}
}
