package jml.parsing;

/**
 * Parse Strings into sections in which you define making it easier to parse shit
 * @author jredfox
 */
public class Section {
	
	public String value;//the section's string value
	public String invalid;//built when a selection object is created
	
	public String start;
	public String end;
	public String lquote;
	public String rquote;
	
	public Section(String s, String e)
	{
		this(s, e, "", "");
	}
	
	public Section(String s, String e, String lq, String rq)
	{
		this.start = s;
		this.end = e;
		this.lquote = lq;
		this.rquote = rq;
	}

	/**
	 * clears all sections to default values
	 */
	public void clear() 
	{
		this.invalid = null;
		this.value = null;
	}
	
	public void build()
	{
		
	}
	
	public static void select(String str, Section... secs)
	{
		for(Section sec : secs)
		{
			sec.build();
		}
	}
}
