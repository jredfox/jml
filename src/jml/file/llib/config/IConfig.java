package jml.file.llib.config;

import java.util.List;

import jml.file.llib.comment.IComment;
import jml.file.llib.line.ILine;

public interface IConfig {
	
	public void load();
	public void save();//the file should be cached inside of the config object when constructed
	public ILine parse(String line);//a ILine as a string object without the comments
	public List<ILine> getLines();//return a modifiable array of lines
	public List<IComment> getHeadComments();
	public List<IComment> getFootComments();

}
