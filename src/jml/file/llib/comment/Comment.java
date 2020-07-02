package jml.file.llib.comment;

public class Comment implements IComment{
	
	public String start = null;
	public String end = null;
	public String comment;
	
	public Comment(String c)
	{
		this.comment = c;
	}
	
	public Comment(String s, String c)
	{
		this(s, null, c);
	}

	public Comment(String s, String e, String c)
	{
		this.start = s;
		this.end = e;
		this.comment = c;
	}
	
	@Override
	public String getComment()
	{
		return this.comment;
	}

	@Override
	public void setComment(String s)
	{
		this.comment = s;
	}
	
	@Override
	public String toString()
	{
		return (this.start != null ? this.start : "") + this.comment + (this.end != null ? this.end : "");
	}
	
	@Override
	public boolean equals(Object other)
	{
		return this.comment.equals(((Comment)other).comment);
	}
	
	@Override
	public int hashCode()
	{
		return this.comment.hashCode();
	}

}
