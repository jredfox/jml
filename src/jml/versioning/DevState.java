package jml.versioning;

import java.util.ArrayList;
import java.util.List;

public class DevState{
	
	public String name;
	public String ab;//Abbreviation
	
	public static final DevState alpha = new DevState("alpha", "a");
	public static final DevState beta = new DevState("beta", "b");
	public static final DevState pre = new DevState("pre-release", "pre");
	public static final DevState release = new DevState("release", "r");
	public static final DevState omega = new DevState("omega","o");
	public static final List<DevState> states = new ArrayList<DevState>(7);
	
	static
	{
		alpha.insert(null);
		beta.insert(alpha);
		pre.insert(beta);
		release.insert(pre);
		omega.insert(release);
	}
	
	public DevState(String name)
	{
		this(name, name);
	}
	
	public DevState(String name, String abbreviation)
	{
		this.name = name;
		this.ab = abbreviation;
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

	public boolean isReleased() 
	{
		return this.value() >= release.value();
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof DevState))
		{
			return false;
		}
		return this.name.equals( ((DevState)other).name );
	}
	
	@Override
	public String toString()
	{
		return this.name;
	}
}
