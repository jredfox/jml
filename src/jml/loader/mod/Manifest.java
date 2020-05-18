package jml.loader.mod;

import java.io.File;

public class Manifest {
	
	public String mcversion;//mc version it's assigned to
	public String mod;//mod class path
	public String coremod;//core mod classpath
	public String at;//accesstransformer
	public boolean jarmod;//whether or not the jar contains classes to replace in memory
	
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
