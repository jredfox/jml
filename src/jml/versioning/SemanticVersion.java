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
	
	public static final SemanticVersion anyVersion = null; // new SemanticVersion("*");//TODO:
	
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
		if(major < 0 || minor < 0 || patch < 0 || pre < 0 || build < 0)
			throw new IllegalArgumentException("SemanticVersion Must contains postive integers!");
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
		Section major = new Section("", ".", true);
		Section minor = new Section("", ".", true);
		Section patch = new Section("", "", true);
		Section pre = new Section("-","");
		Section build = new Section("+", "");
		Section.select(str, major, minor, patch, pre, build);
		
		System.out.println(major.value);
		System.out.println(minor.value);
		System.out.println(patch.value);
		System.out.println(pre.value);
		System.out.println(build.value);
		
		//parse the main versioning
//		this.major = Integer.parseInt(major.value);
//		this.minor = Integer.parseInt(minor.value);
//		this.patch = Integer.parseInt(patch.value);
//		
//		//parse the pre-release
//		if(!pre.value.isEmpty())
//		{
//			this.pre = Integer.parseInt(pre.value.split("\\.")[1]);
//		}
//		
//		if(!build.value.isEmpty())
//		{
//			this.build = Integer.parseInt(build.value);
//		}
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
		return this.major == o.major && this.minor == o.minor && this.patch == o.patch && this.pre == o.pre;
	}
	
	@Override
	public int compareTo(SemanticVersion other)
	{
		return 0;//TODO:
	}
	
}
