package jml.loader;

import jml.line.line.ILine;
import jml.line.line.LineMap;

public class Run {
	
	public static void main(String[] args)
	{
//		SemanticVersion version = new SemanticVersion("1.22.3-pre-release.1+1099");
//		System.out.println(version);
//		Line line = new Line("\"modid:block \" <22> {nbt:true} = 1");
		ILine line = new LineMap("tile.stone.furnace=Furnace");
		System.out.println(line.getValues()[0]);
	}

}
