package jml.versioning;

import jml.versioning.SemanticVersion.Dev;

/**
 * what minecraft vanilla uses not recommended and is incompatible with Semantic version but, they can both be compared with
 * the main difference between the two is DevStateVersioning can be above 1.0 in the state of dev so the game is alpha but, it's past 1.0
 * and it's compared by gamestate.major.minor.patch in that ordering
 */
public class DevStateVersion extends Version{
	
	public Dev state;
	public SemanticVersion version;
	
	public DevStateVersion(Dev state, SemanticVersion version)
	{
		
	}

}
