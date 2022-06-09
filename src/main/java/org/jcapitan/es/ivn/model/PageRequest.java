package org.jcapitan.es.ivn.model;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class PageRequest {
	@QueryParam ( "pageNum" ) 
    @DefaultValue ( "0" ) 
    private int pageNum; 
    @QueryParam ( "pageSize" ) 
    @DefaultValue ( "3" ) 
    private int pageSize;
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}  
    
    
}
