package jml.line.line;

/**
 * a line represents an object of data formed in one line
 * a line can have values associated with it
 * a line doesn't have to have meta
 * a line doesn't have to have values
 * a line has to have an id
 * a line meta data will be null if the line object doesn't support it
 * This is the basis of the line library 3.0 and should be fully extendible
 */
public interface ILine {
	
	public String getId();
	public Object[] getMetas();
	public Object[] getValues();
	
	public void setId(String id);
	public void setMeta(int index);
	public void setValues(Object... values);
	
	//TODO: find a solution so I don't always have to return an array of data for a single object
	//TODO: should lines only be compared equals with by their id?
}
