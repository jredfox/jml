package jml.versioning;

/**
 * format is major.minor.patch-rc.rcBuild+build
 * major is what version of the api are you on
 * minor is making backwards compatibility
 * patch is bug fixes
 * rc is a pre release for your next api change
 * rc build is what build your on of your rc
 * the build is an integer value and describes what commit you have released either to github or the public and is display only as the semantic versioning is what is realy used here
 */
public class SemanticVersion implements Comparable<SemanticVersion>{
	
	public int major;
	public int minor;
	public int patch;
	public PreRelease rc;
	public int build;
	public static boolean showBuilds = true;
	
	public SemanticVersion(int major, int minor, int patch)
	{
		this(major, minor, patch, null, 0);
	}
	
	public SemanticVersion(int major, int minor, int patch, PreRelease rc)
	{
		this(major, minor, patch, rc, 0);
	}
	
	public SemanticVersion(int major, int minor, int patch, int build)
	{
		this(major, minor, patch, null, build);
	}
	
	public SemanticVersion(int major, int minor, int patch, PreRelease rc, int build)
	{
		this.major = major;
		this.minor = minor;
		this.patch = patch;
		this.rc = rc;
		this.build = build;
	}
	
	/**
	 * parse a SemanticVersion from a string
	 */
	public SemanticVersion(String str)
	{
		String[] vs = str.split("\\.", 3);
		this.major = Integer.parseInt(vs[0]);
		this.minor = Integer.parseInt(vs[1]);
		this.patch = Integer.parseInt(vs[2]);
		System.out.println(vs[2]);
	}
	
	@Override
	public String toString()
	{
		return this.major + "." + this.minor + "." + this.patch + (this.rc != null ? "-" + this.rc : "") + (SemanticVersion.showBuilds ? "+" + this.build : "");
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof SemanticVersion))
			return false;
		SemanticVersion o = (SemanticVersion) other;
		boolean pr = this.rc != null && this.rc.equals(o.rc);
		return this.major == o.major && this.minor == o.minor && this.patch == o.patch && pr;
	}
	
	@Override
	public int compareTo(SemanticVersion other)
	{
		return 0;
	}
	
}
