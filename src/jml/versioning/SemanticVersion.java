package jml.versioning;

/**
 * format is prefix + major.minor.patch-prerelease+build more info found at https://semver.org/
 * @author jredfox
 */
public class SemanticVersion extends Version{
	
	public int major;
	public int minor;
	public int patch;
	public Dev pre = Dev.stable;
	public int preBuild;//pre-release build
	public int build;//semantic version as integer an actual build number
	
	public SemanticVersion(int major, int minor, int patch)
	{
		this.major = major;
		this.minor = minor;
		this.patch = patch;
	}
	
	public SemanticVersion(int major, int minor, int patch, Dev dev)
	{
		this(major, minor, patch);
		this.pre = dev;
	}
	
	/**
	 * parse a semantic version from a string
	 */
	public SemanticVersion(String str)
	{
		
	}
	
	@Override
	public String toString()
	{
		return this.major + "." + this.minor + "." + this.patch + "-" + this.pre + "." + this.preBuild + "+" + this.build;
	}

	public static class Dev
	{
		public String state;
		public String shortened;
		public byte value;
		
		public static final Dev alpha = new Dev("alpha", "a", 0);
		public static final Dev beta = new Dev("beta", "b", 10);
		public static final Dev prerelease = new Dev("pre-release", "rc", 20);
		public static final Dev stable = new Dev("stable", 30);//1.0+ stage
		public static final Dev omega = new Dev("omega","o", 40);//finished / final stage of dev where you are no longer going to update unless needed
		
		public Dev(String dev, int b)
		{
			this(dev, dev, b);
		}
		
		public Dev(String dev, String shortened, int b)
		{
			this.state = dev;
			this.shortened = shortened;
			this.value = (byte) b;
		}
		
		@Override
		public String toString()
		{
			return this.state;
		}
	}
}
