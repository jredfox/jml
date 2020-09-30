package jml.parsing;

import java.util.HashSet;
import java.util.Set;

/**
 * Parse Strings into sections which will allow you to parse them into objects easier
 * @author jredfox
 */
public class Section {
	
	//parsing
	public String value = "";//the section's string value after parsing
	public Set<String> invalid;//built when a selection object is created
	
	//section properties
	public String start;
	public String end;
	public String lquote;
	public String rquote;
	public boolean req;//is the section required to be parsed every time
	public boolean evenBraces;//whether or not it should have the same number of open and closing braces for the section
	
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
		this(s, e, lq, rq, req, false);
	}
	
	public Section(String s, String e, String lq, String rq, boolean req, boolean eb)
	{
		this.start = s;
		this.end = e;
		this.lquote = lq;
		this.rquote = rq;
		this.req = req;
		this.evenBraces = eb;
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
					{
						sec.invalid.add(in.start);
					}
					else if(!in.end.isEmpty())
					{
						sec.invalid.add(in.end);
					}
					if(in.req)
					{
						break;//break the loop of building invalid chars if the section will happen
					}
				}
			}
		}
		
		int startingIndex = 0;//last known index
		boolean started = false;//has the section started
		for(Section sec : secs)
		{
			for(int currentIndex = startingIndex; currentIndex < str.length(); currentIndex++)
			{
				String s = str.substring(currentIndex, currentIndex + 1);
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
