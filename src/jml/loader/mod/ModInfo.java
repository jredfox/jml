package jml.loader.mod;

import jml.versioning.SemanticVersion;

public class ModInfo {
	
	public String id;//must be alphanumeric no spaces
	public String name;
	public SemanticVersion version;
	public String description;
	public String[] authors;
	public static final String logo = "logo.png";

}
