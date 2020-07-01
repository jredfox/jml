package jml.line.line;

import jml.parsing.Section;

public class Line implements ILine{
	
	public String id;
	public Object meta;
	public String nbt;
	public Object value;
	
	public Line(String str)
	{
		this.parse(str);
	}

	protected void parse(String str)
	{
		Section id = new Section("","","\"","\"", true);
		Section meta = new Section("<", ">", "\"", "\"", false);
		Section nbt = new Section("{", "}", "\"", "\"", false, true);
		Section nbtarr = new Section("[", "]", "\"", "\"", false, true);
		Section value = new Section("=", "");
		Section.select(str, id, meta, nbt, nbtarr, value);
		
		this.id = id.value;
		this.meta = Integer.parseInt(meta.value);
		this.nbt = nbt.value;
		this.value = Integer.parseInt(value.value.trim());
	}
	
	public Number meta()
	{
		return (Number) this.meta;
	}
	
	public String metaString()
	{
		return (String) this.meta;
	}
	
	public String nbt()
	{
		return this.nbt;
	}
	
	public Number value()
	{
		return (Number) this.value;
	}
	
	public boolean isMetaString()
	{
		return this.meta instanceof String;
	}
	
	public boolean isValueString()
	{
		return this.value instanceof String;
	}
	
	@Override
	public String toString()
	{
		return this.id + "<" + this.meta + "> " + "{" + this.nbt + "}" + " = " + this.value;
	}
	
	@Override
	public boolean equals(Object other)
	{
		if(!(other instanceof Line))
			return false;
		Line o = (Line) other;
		return this.id.equals(other) && this.meta.equals(o.meta) && this.nbt.equals(o.nbt) && this.value.equals(o.value);
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object[] getMetas() {
		return null;//TODO:
	}

	@Override
	public Object[] getValues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setId(String id) 
	{
		this.id = id;
	}

	@Override
	public void setMeta(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setValues(Object... values) {
		// TODO Auto-generated method stub
		
	}

}
