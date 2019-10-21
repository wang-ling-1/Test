package com.wl.www.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PageEntity {
	private Map queryParam = new HashMap();
	private List pageData = new ArrayList();
	private Map gotoPage = new HashMap();

	public PageEntity(Map queryParam, List pageData, Map gotoPage) {
		this.queryParam = queryParam;
		this.pageData = pageData;
		this.gotoPage = gotoPage;
	}

	public PageEntity() {
	}

	public Map getQueryParam() {
		return queryParam;
	}

	public void setQueryParam(Map queryParam) {
		this.queryParam = queryParam;
	}

	public List getPageData() {
		return pageData;
	}

	public void setPageData(List pageData) {
		this.pageData = pageData;
	}

	public Map getGotoPage() {
		return gotoPage;
	}

	public void setGotoPage(Map gotoPage) {
		this.gotoPage = gotoPage;
	}
}
