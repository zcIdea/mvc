package com.myapp.web.tag;
 
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
 
/**
 * @author zhangChuan
 *
 */
public class DemoViewTag extends TagSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String northTitle = "";
	private String westTitle = "";
	
	public String getNorthTitle() {
		return northTitle;
	}
	public void setNorthTitle(String northTitle) {
		this.northTitle = northTitle;
	}
	public String getWestTitle() {
		return westTitle;
	}
	public void setWestTitle(String westTitle) {
		this.westTitle = westTitle;
	}
	/**
	 * 
	 */
	public DemoViewTag() {
		// TODO Auto-generated constructor stub
	}
	public int doStartTag()
	{
		return super.SKIP_BODY;
	}
	public int doEndTag() throws JspException
	{
		JspWriter writer=pageContext.getOut();
		try {
			writer.print("这是我的标签示例<br/>westTitle："+this.westTitle+"<br/>northTitle:"+this.northTitle);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return super.EVAL_PAGE;
	}
}
