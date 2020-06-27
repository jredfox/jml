package jml.versioning;

public class PreRelease {
	
	public int build;
	public static final PreRelease defaultPre = new PreRelease(0);
	
	public PreRelease(int build)
	{
		this.build = build;
	}
	
	public PreRelease(String str) 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString()
	{
		return DevState.pre + (this.build > 0 ? "." + this.build : "");
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof PreRelease))
			return false;
		PreRelease o = (PreRelease) other;
		return this.build == o.build;
	}

}
