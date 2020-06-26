package jml.versioning;

public class PreRelease {
	
	public DevState state;
	public int build;
	
	public PreRelease(DevState state, int build)
	{
		if(state.value() >= DevState.release.value())
		{
			throw new IllegalArgumentException("A Pre-Release cannot be in a released state!");
		}
		this.state = state;
		this.build = build;
	}
	
	@Override
	public String toString()
	{
		StringBuilder b = new StringBuilder();
		b.append(this.state);
		if(this.build > 0)
		{
			b.append(".");
			b.append(this.build);
		}
		return b.toString();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof PreRelease))
			return false;
		PreRelease o = (PreRelease) other;
		return this.state.equals(o.state) && this.build == o.build;
	}

}
