package jml.loader.mod;

import jml.versioning.SemanticVersion;

public class ModInfo {
	
	public String id;//must be alphanumeric no spaces
	public String name;
	public SemanticVersion version;
	public int build;//every time you compile MDK this increments by one
	public String description;
	public String[] authors;
	public static String logo = "logo.png";

}
