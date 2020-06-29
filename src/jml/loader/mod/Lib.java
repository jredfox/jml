package jml.loader.mod;

import java.net.URL;

public class Lib {
	
	public URL download;
	public String path;//relative path from the jar to the actual file to check or dl and install the lib
	public String md5;//check the md5 to make sure it's modified if enabled by the mod loader
	public static boolean checkMD5 = true;

}
