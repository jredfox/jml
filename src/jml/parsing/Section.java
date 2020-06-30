package jml.parsing;

import java.util.HashSet;
import java.util.Set;

/**
 * Parse Strings into sections which will allow you to parse them into objects easier
 * @author jredfox
 */
public class Section {
	
	public String value = "";//the section's string value
	public Set<String> invalid;//built when a selection object is created
	
	public String start;
	public String end;
	public String lquote;
	public String rquote;
	public boolean req;//is the section required to be parsed every time
	public boolean started;
	
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
		this.req = req;
		this.invalid = new HashSet<String>(6);
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
		this.value = "";
		this.invalid.clear();
		this.started = false;
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
		
		if(str == null || str.isEmpty())
		{
			throw new IllegalArgumentException("cannot select an empty or null string");
		}
		
		int index = 0;
		Section sec = secs[index++];
		for(int i = 0; i < str.length(); i++)
		{
			String s = str.substring(i, i + 1);
			
			//detect if the section should end and if it's a blank ending then append last char
			if(!sec.end.isEmpty() && sec.end.contains(s) || !sec.invalid.isEmpty() && sec.invalid.contains(nxtChar(str, i)))
			{
				if(sec.end.isEmpty())
				{
					sec.value += s;
				}
				sec = secs[index++];
				continue;
			}
			
			//detect if a section has started and if so append last char if it's empty
			if(!sec.started && sec.canStart(s))
			{
				sec.started = true;
				if(sec.start.isEmpty())
				{
					sec.value += s;
				}
				continue;
			}
			
			//Append chars to the value
			if(sec.started)
			{
				sec.value += s;
			}
		}
	}

	private static String nxtChar(String str, int i)
	{
	  String s = i + 2 <= str.length() ? str.substring(i + 1, i + 2) : null;
	  return s;
	}

	private boolean canStart(String s)
	{
		return this.start.isEmpty() || this.start.equals(s);
	}
	
	//TODO: add a section select with no inheritance option and they define the invalid chars each section is allowed to have or none if they strictly rely on start/end
	//TODO: add section function to have something like start/end or invalid chars a-z regex or something
}
