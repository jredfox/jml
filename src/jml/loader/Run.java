package jml.loader;

import jml.versioning.SemanticVersion;

public class Run {
	
	public static void main(String[] args)
	{
		SemanticVersion version = new SemanticVersion("1.22.3-pre-release.1+1099");
		System.out.println(version);
	}

}
