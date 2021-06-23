package com.tuananh.paging;

import com.tuananh.sort.Sorter;

public class PageRequest implements Pageble{
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}

	@Override
	public Integer getPage() {
		// TODO Auto-generated method stub
		return page;
	}

	@Override
	public Integer getOffset() {
		if(this.page != null && this.maxPageItem != null) {
		return (page - 1) * maxPageItem;
		} else return null;
	}

	@Override
	public Integer getLimit() {
		// TODO Auto-generated method stub
		return maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		// TODO Auto-generated method stub
		return sorter;
	}

	

	

}
