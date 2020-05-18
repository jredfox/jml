package jml.loader.mod;

import java.io.File;

import net.minecraft.util.ResourceLocation;

public abstract class ModContainer {
	
	public File modFile;
	public Manifest manifest;
	public ModInfo info;
	public Dependant[] dependants;
	public Lib[] libs;

}
