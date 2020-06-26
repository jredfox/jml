package jml.parsing;

/**
 * a generic api for parsing strings into sections. Once the string is split it's pretty easy to parse into java objects.
 * Simply build your Sections from left to right and once you got all the sections that are there then Make a Selection Object and call select
 * @author jredfox
 */
public class Selection {
	
	public Section[] sections;
	
	public Selection(Section... sections)
	{
		this.sections = sections;
		this.clear();
	}

	/**
	 * clears all sections to default values
	 */
	public void clear() 
	{
		for(Section sec : this.sections)
		{
			sec.invalid = null;
			sec.value = null;
		}
	}

	public static class Section
	{
		public String value;
		public String start;
		public String end;
		public String lquote;
		public String rquote;
		public String invalid;//built when a selection object is created
		
		public Section(String s, String e, String lq, String rq)
		{
			this.start = s;
			this.end = e;
			this.lquote = lq;
			this.rquote = rq;
		}
	}
	
	public String[] select()
	{
		return null;
	}
}
