package jml.file.llib.line;

import jml.parsing.Section;

/**
 * a line where key=value is only supported uses for example could be associated with option files or things like game lang files
 */
public class LineMap implements ILine{
	
	public String id;
	public String value;
	
	public LineMap(String key, String value)
	{
		this.id = key;
		this.value = value;
	}
	
	public LineMap(String str)
	{
		this.parse(str);
	}

	protected void parse(String str) 
	{
		Section id = new Section("", "", "", "", true);
		Section value = new Section("=","", "", "", true);
		Section.select(str, id, value);
		
		this.id = id.value;
		this.value = value.value;
	}

	@Override
	public String getId() 
	{
		return this.id;
	}

	@Override
	public Object[] getMetas() {return null;}

	@Override
	public Object[] getValues() 
	{
		return new Object[]{this.value};
	}

	@Override
	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public void setMeta(int index){}

	@Override
	public void setValues(Object... values) 
	{
		this.value = (String) values[0];
	}
	
	@Override
	public String toString()
	{
		return this.id + "=" + this.value;
	}
	
	@Override
	public int hashCode()
	{
		return this.id.hashCode();
	}
	
	@Override
	public boolean equals(Object o)
	{
		return this.id.equals(((LineMap)o).id);
	}

}
