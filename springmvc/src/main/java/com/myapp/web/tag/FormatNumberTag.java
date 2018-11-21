package com.myapp.web.tag;
 
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
 
/**
 * 自定义标签
 * @author zhangChuan
 *
 */
public class FormatNumberTag extends TagSupport {
	private static final long serialVersionUID = 5924250884998811495L;
	private String value = "";
	private String type = "";
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 
	 */
	public FormatNumberTag() {
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("static-access")
	public int doStartTag()
	{
		return super.SKIP_BODY;
	}
	@SuppressWarnings("static-access")
	public int doEndTag() throws JspException
	{
		JspWriter writer=pageContext.getOut();
		try {
			
			if(this.type.equals("number")){
				writer.print("number："+Integer.parseInt(value));
			}else if(this.type.equals("String")){
				writer.print("String：<font color='red'>"+value+"</font>");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return super.EVAL_PAGE;
	}
}
