package jml.loader.mod;

import java.io.File;

public class Manifest {
	
	public String mcversion;//won't load if the mc version doesn't match
	public String mod;//mod class path
	public String coremod;//coremod classpath
	public String at;//acess transformer
	public boolean jarmod;//if true has classes to be replaced in memory not recommended
	
	public Manifest()
	{
		
	}
	
	public Manifest(String mcversion, String mod, String coremod, String at, boolean jarmod)
	{
		this.mcversion = mcversion;
		this.mod = mod;
		this.coremod = coremod;
		this.at = at;
		this.jarmod = jarmod;
	}
}
