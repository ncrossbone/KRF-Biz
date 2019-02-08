package com.ce.krf.biz.service;

import java.io.Serializable;
import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ce.krf.biz.mapper.BookmarkMapper;

@Component
public class BookmarkService implements Serializable{


	/**
	 * 
	 */
	private static final long serialVersionUID = 8190592946817068162L;

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public BookmarkMapper bookmarkMapper;
	
	
	public HashMap getBookmark(String userId) {
		HashMap res = new HashMap<String, Object>();
		res.put("data", bookmarkMapper.getBookmark(userId));
		return res;
	}
	
	public String putBookmark(HashMap<String, Object> param) {
		return bookmarkMapper.putBookmark(param)+"";
	}
	
	public String deleteBookmark(String userId, String sn) {
		return bookmarkMapper.deleteBookmark(userId,sn)+"";
	}
	
	
}
