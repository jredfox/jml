package jml.loader.mod;

import java.io.File;

public class Manifest {
	
	public String game;//the name of the game the mod is suppose to load into
	public String gameVersion;//not all game builds are semantic versions so we keep it as a string
	public String mod;//mod class path
	public String coremod;//coremod classpath
	public String at;//access transformer
	public boolean jarmod;//if true has classes to be replaced in memory not recommended
	
	public Manifest()
	{
		
	}
	
	public Manifest(String gameVersion, String mod, String coremod, String at, boolean jarmod)
	{
		this.gameVersion = gameVersion;
		this.mod = mod;
		this.coremod = coremod;
		this.at = at;
		this.jarmod = jarmod;
	}
}
