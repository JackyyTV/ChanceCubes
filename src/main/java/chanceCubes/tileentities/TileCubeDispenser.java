package chanceCubes.tileentities;

import chanceCubes.blocks.CCubesBlocks;
import chanceCubes.blocks.BlockCubeDispenser.DispenseType;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileCubeDispenser extends TileEntity
{
	private EntityItem entityItem;
	private DispenseType currentType = DispenseType.ChanceCube;

	public EntityItem getRenderEntityItem(DispenseType type)
	{
		if(entityItem == null)
			this.entityItem = new EntityItem(this.worldObj, super.getPos().getX(), super.getPos().getY(), super.getPos().getZ(), new ItemStack(CCubesBlocks.chanceCube, 1));
		if(this.currentType != type)
		{
			this.currentType = type;
			if(type == DispenseType.ChanceIcosahedron)
				this.entityItem.setEntityItemStack(new ItemStack(CCubesBlocks.chanceIcosahedron, 1));
			else if(type == DispenseType.CompactGaintCube)
				this.entityItem.setEntityItemStack(new ItemStack(CCubesBlocks.chanceCompactGiantCube, 1));
			else
				this.entityItem.setEntityItemStack(new ItemStack(CCubesBlocks.chanceCube, 1));
		}

		return this.entityItem;
	}

	public EntityItem getNewEntityItem(DispenseType type)
	{
		EntityItem ent;
		
		if(type == DispenseType.ChanceIcosahedron)
			ent = new EntityItem(this.worldObj, super.getPos().getX(), super.getPos().getY(), super.getPos().getZ(), new ItemStack(CCubesBlocks.chanceIcosahedron, 1));
		else if(type == DispenseType.CompactGaintCube)
			ent = new EntityItem(this.worldObj, super.getPos().getX(), super.getPos().getY(), super.getPos().getZ(), new ItemStack(CCubesBlocks.chanceCompactGiantCube, 1));
		else
			ent = new EntityItem(this.worldObj, super.getPos().getX(), super.getPos().getY(), super.getPos().getZ(), new ItemStack(CCubesBlocks.chanceCube, 1));

		return ent;
	}

	public Block getCurrentBlock(DispenseType type)
	{
		Block b = Blocks.air;
		if(entityItem == null || this.currentType != type)
		{
			if(type == DispenseType.ChanceIcosahedron)
				b = CCubesBlocks.chanceIcosahedron;
			else if(type == DispenseType.CompactGaintCube)
				b = CCubesBlocks.chanceCompactGiantCube;
			else
				b = CCubesBlocks.chanceCube;
		}

		return b;
	}
}