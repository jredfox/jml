package jml.versioning;

import jml.parsing.Section;

/**
 * format is major.minor.patch-pre.prebuild+build
 * major is what version of the api are you on
 * minor is making backwards compatibility
 * patch is bug fixes
 * pre is a pre release for your next api change
 * pre build is what build your on of your pre
 * the build is what commit/push you are on the entire semantic version as an integer but, isn't used for anything more then display
 */
public class SemanticVersion implements Comparable<SemanticVersion>{
	
	public int major;
	public int minor;
	public int patch;
	public int pre;
	public int build;
	
	public static final SemanticVersion anyVersion = null;//TODO:
	
	public SemanticVersion(int major, int minor, int patch)
	{
		this(major, minor, patch, 0);
	}
	
	public SemanticVersion(int major, int minor, int patch, int pre)
	{
		this(major, minor, patch, pre, 0);
	}
	
	public SemanticVersion(int major, int minor, int patch, int pre, int build)
	{
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.pre = pre;
		this.build = build;
	}
	
	/**
	 * parse a SemanticVersion from a string
	 */
	public SemanticVersion(String str)
	{
		Section major = new Section("", ".");
		Section minor = new Section("", ".");
		Section patch = new Section("", ".");
		Section pre = new Section("-","");
		Section build = new Section("+", "");
		Section.select(str, major, minor, patch, pre, build);
		
		//parse the main versioning
		this.major = Integer.parseInt(major.value);
		this.minor = Integer.parseInt(minor.value);
		this.patch = Integer.parseInt(patch.value);
		
		//parse the pre-release
		if(pre.value != null)
		{
			this.pre = Integer.parseInt(pre.value.substring(1));
		}
		
		if(build.value != null)
		{
			this.build = Integer.parseInt(build.value.substring(1));
		}
	}
	
	@Override
	public String toString()
	{
		return toString(true);
	}
	
	public String toString(boolean sbuilds)
	{
		return this.major + "." + this.minor + "." + this.patch + (this.pre > 0 ? "-" + DevState.pre + "." + this.pre : "") + (sbuilds ? "+" + this.build : "");
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof SemanticVersion))
			return false;
		SemanticVersion o = (SemanticVersion) other;
		return this.major == o.major && this.minor == o.minor && this.patch == o.patch && pre == o.pre;
	}
	
	@Override
	public int compareTo(SemanticVersion other)
	{
		return 0;//TODO:
	}
	
}
