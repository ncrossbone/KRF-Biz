package com.ce.krf.biz.controller;

import java.util.HashMap;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ce.krf.KrfBizApplication;
import com.ce.krf.biz.base.BaseController;
import com.ce.krf.biz.model.BookmarkVO;
import com.ce.krf.biz.service.BookmarkService;

@RestController
@RequestMapping("/bookmark")
public class BookmarkController extends BaseController {
	private final Logger logger = LoggerFactory.getLogger(KrfBizApplication.class);

	@Autowired
	public BookmarkService bookmarkService;

	@RequestMapping(value = "/getBookmark", produces = "text/html; charset=euc-kr")
	public String getBookmark(@ModelAttribute BookmarkVO param) {
		try {
			return getEuckrString((HashMap) bookmarkService.getBookmark(param.getUserId()), false);
		} catch (Exception e) {
			return "error";
		}
	}
	
	@RequestMapping(value = "/putBookmark", method = RequestMethod.POST)
	public String putBookmark(@RequestParam String param, @RequestParam String userId) {
		return bookmarkService.putBookmark(param,userId);
	}
	
	@RequestMapping(value = "/deleteBookmark", method = RequestMethod.POST)
	public String deleteBookmark(@RequestParam String userId, @RequestParam String sn) {
		return bookmarkService.deleteBookmark(userId,sn);
	}
}
