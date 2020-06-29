package jml.parsing;

import java.util.HashSet;
import java.util.Set;

/**
 * Parse Strings into sections which will allow you to parse them into objects easier
 * @author jredfox
 */
public class Section {
	
	public String value;//the section's string value
	public Set<String> invalid;//built when a selection object is created
	
	public String start;
	public String end;
	public String lquote;
	public String rquote;
	public boolean req = false;//is the section required to be parsed every time
	
	public Section(String s, String e)
	{
		this(s, e, false);
	}
	
	public Section(String s, String e, boolean req)
	{
		this(s, e, "", "", req);
	}
	
	public Section(String s, String e, String lq, String rq, boolean req)
	{
		this.start = s;
		this.end = e;
		this.lquote = lq;
		this.rquote = rq;
		this.invalid = new HashSet<String>(10);
	}
	
	public void setReq(boolean req)
	{
		this.req = req;
	}

	/**
	 * clears all sections to default values
	 */
	public void clear() 
	{
		this.value = null;
		this.invalid.clear();
	}
	
	public static void select(String str, Section... secs)
	{
		//build the inheritance
		for(int i = 0; i < secs.length; i++)
		{
			Section sec = secs[i];
			sec.clear();
			if(sec.end.isEmpty())
			{
				for(int j = i + 1; j < secs.length; j++)
				{
					Section in = secs[j];
					if(!in.start.isEmpty())
						sec.invalid.add(in.start);
					else if(!in.end.isEmpty())
						sec.invalid.add(in.end);
				}
			}
		}
		
	}
	
	//TODO: add a section select with no inheritance option and they define the invalid chars each section is allowed to have or none if they strictly rely on start/end
	//TODO: add section function to have something like start/end or invalid chars a-z regex or something
}
