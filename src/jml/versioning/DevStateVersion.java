package jml.versioning;

/**
 * @author jredfox
 * Format is gamestate.major.minor.patch_subpatch-pre.preBuild+build
 * If the api is stable >= 1.0
 * The versioning resets every time a DevState increments and if the program is stable it's 1.0
 * This versioning system is copied from minecraft's versioning system
 */
public class DevStateVersion implements Comparable<DevStateVersion>{
	
	public DevState state;
	public int subpatch;
	public SemanticVersion version;
	
	public static boolean subchars = false;//make _002 > b or something whenever possible
	public static boolean showBuilds = true;
	
	public DevStateVersion(DevState state, SemanticVersion version)
	{
		this(state, version, 0);
	}
	
	public DevStateVersion(DevState state, SemanticVersion version, int subpatch)
	{
		this.state = state;
		this.version = version;
		this.subpatch = subpatch;
	}
	
	@Override
	public int compareTo(DevStateVersion o) 
	{
		return -1;//TODO:
	}
	
	@Override
	public String toString()
	{
		return this.state.ab + "." + this.version;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof DevStateVersion))
			return false;
		//TODO:
		return false;
	}
	
}
