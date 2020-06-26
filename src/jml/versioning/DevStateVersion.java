package jml.versioning;

/**
 * Format is gamestate.major.minor.patch-prerelease-(build)+build
 */
public class DevStateVersion {
	
	public DevState state;//what state is the game/program running in
	public int major;//an api changes or major update
	public int minor;//more then a patch update
	public int patch;//release a patch
	public int subpatch;//when your patch number doesn't increment since the changes were too minor
	public int build;//what push is this?
	
	public DevStateVersion(DevState state, int major, int minor, int patch, int subpatch, int build)
	{
		this.state = state;
	}
	
}
