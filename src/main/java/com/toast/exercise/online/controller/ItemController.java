package com.toast.exercise.online.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.toast.exercise.base.BaseController;

@Controller
public class ItemController extends BaseController {
	@RequestMapping(value = "/itemList")
	public String itemPage() {
		return "itemList";
	}
}
