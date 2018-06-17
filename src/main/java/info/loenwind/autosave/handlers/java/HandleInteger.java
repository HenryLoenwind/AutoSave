package info.loenwind.autosave.handlers.java;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import info.loenwind.autosave.Registry;
import info.loenwind.autosave.handlers.IHandler;
import info.loenwind.autosave.util.NBTAction;
import info.loenwind.autosave.util.TypeUtil;
import net.minecraft.nbt.NBTTagCompound;

public class HandleInteger implements IHandler<Integer> {

  public HandleInteger() {
  }

  @Override
  public IHandler<Integer> getHandler(Type type) {
    return TypeUtil.isAssignable(Integer.class, type) || TypeUtil.isAssignable(int.class, type) ? this : null;
  }

  @Override
  public boolean store(@Nonnull Registry registry, @Nonnull Set<NBTAction> phase, @Nonnull NBTTagCompound nbt, @Nonnull String name,
      @Nonnull Integer object) throws IllegalArgumentException, IllegalAccessException {
    nbt.setInteger(name, object);
    return true;
  }

  @Override
  public Integer read(@Nonnull Registry registry, @Nonnull Set<NBTAction> phase, @Nonnull NBTTagCompound nbt, @Nullable Field field, @Nonnull String name,
      @Nullable Integer object) {
    return nbt.hasKey(name) ? nbt.getInteger(name) : object != null ? object : 0;
  }

}
