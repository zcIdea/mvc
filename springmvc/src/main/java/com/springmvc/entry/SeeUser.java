package com.springmvc.entry;

import java.io.Serializable;

/**
 * 
 */
public class SeeUser implements Serializable{
	
	private static final long serialVersionUID = -8970631659119042415L;
	
	private String id;
    private String ip;//用户的id
    private String seeTime;//用户访问的时间
    private int seeCount;//用户访问的次数

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getSeeTime() {
        return seeTime;
    }

    public void setSeeTime(String seeTime) {
        this.seeTime = seeTime;
    }

    public int getSeeCount() {
        return seeCount;
    }

    public void setSeeCount(int seeCount) {
        this.seeCount = seeCount;
    }
    
    @Override
    public String toString() {
    	
    	return "SeeUser[id:"+id+",ip:"+ip+",seeTime:"+seeTime+",seeCount:"+seeCount+"]";
    }
}