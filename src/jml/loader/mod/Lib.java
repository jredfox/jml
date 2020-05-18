package jml.loader.mod;

import java.net.URL;

public class Lib {
	
	public URL download;
	public String path;//check if it's already downloaded
	public String md5;//check the md5 to make sure it's modified if enabled by the mod loader
	public static boolean checkMD5 = true;

}
