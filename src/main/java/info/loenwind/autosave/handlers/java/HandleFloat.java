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

public class HandleFloat implements IHandler<Float> {

  public HandleFloat() {
  }

  @Override
  public IHandler<Float> getHandler(Type type) {
    return TypeUtil.isAssignable(Float.class, type) || TypeUtil.isAssignable(float.class, type) ? this : null;
  }

  @Override
  public boolean store(@Nonnull Registry registry, @Nonnull Set<NBTAction> phase, @Nonnull NBTTagCompound nbt, @Nonnull String name, @Nonnull Float object)
      throws IllegalArgumentException, IllegalAccessException {
    nbt.setFloat(name, object);
    return true;
  }

  @Override
  public Float read(@Nonnull Registry registry, @Nonnull Set<NBTAction> phase, @Nonnull NBTTagCompound nbt, @Nullable Field field, @Nonnull String name,
      @Nullable Float object) {
    return nbt.hasKey(name) ? nbt.getFloat(name) : object != null ? object : 0f;
  }

}
