package jml.versioning;

import java.util.ArrayList;
import java.util.List;

public class DevState{
	
	public String state;
	public String shortened;
	
	public static final DevState alpha = new DevState("alpha", "a");
	public static final DevState beta = new DevState("beta", "b");
	public static final DevState rc = new DevState("pre-release", "rc");
	public static final DevState release = new DevState("release");
	public static final DevState omega = new DevState("omega","o");
	public static final List<DevState> states = new ArrayList<DevState>(7);
	
	static
	{
		alpha.insert(null);
		beta.insert(alpha);
		rc.insert(beta);
		release.insert(rc);
		omega.insert(release);
	}
	
	public DevState(String state)
	{
		this(state, state);
	}
	
	public DevState(String state, String shortened)
	{
		this.state = state;
		this.shortened = shortened;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof DevState))
		{
			return false;
		}
		return this.state.equals( ((DevState)other).state );
	}
	
	@Override
	public String toString()
	{
		return this.state;
	}
	
	/**
	 * inserts the state to after a specific state
	 */
	public void insert(DevState loc)
	{
		if(states.contains(this))
		{
			throw new RuntimeException("cannot add duplicate DevState to the registry!");
		}
		int index = states.indexOf(loc) + 1;
		states.add(index, this);
	}
	
	public int value()
	{
		return states.indexOf(this);
	}
}
