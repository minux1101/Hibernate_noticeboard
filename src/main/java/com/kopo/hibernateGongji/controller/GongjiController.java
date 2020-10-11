package com.kopo.hibernateGongji.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kopo.hibernateGongji.model.Gongji;
import com.kopo.hibernateGongji.server.GongjiService;

@Controller
public class GongjiController {

	@Autowired
	GongjiService gongjiService;

	SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd");

	@RequestMapping(value = "/gongji", method = RequestMethod.GET, headers = "Accept=application/json")
	public String getItems(Model model) {

		List<Gongji> gongjiList = gongjiService.selectAll();
		model.addAttribute("gongji", new Gongji());
		model.addAttribute("gongjiList", gongjiList);
		return "gongji_list";
	}

	// oneView
	@RequestMapping(value = "/view", method = RequestMethod.GET, headers = "Accept=application/json")
	public String view(@RequestParam int id, Model model) throws Exception {

		Gongji gongji = gongjiService.selectOne(id);
		model.addAttribute("oneView", gongji);

		return "gongji_view";
	}

	// insert
	@RequestMapping(value = "/insert", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
	public String insert(HttpServletRequest request, Model model) throws Exception {

		Gongji gongji = new Gongji();
		LocalDate now = LocalDate.now();
		String format = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Date date = sdt.parse(format);
		gongji.setDate(date);
		model.addAttribute("insertGongji", gongji);

		return "gongji_insert";
	}

	// result
	@RequestMapping(value = "/result", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
	public String result(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		Gongji gongji = new Gongji();

		if (request.getParameter("title").equals("") || request.getParameter("title") == null || request.getParameter("content").equals("") || request.getParameter("content") == null) {
			return "gongji_insert";
		} else {
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			LocalDate now = LocalDate.now();
			String format = now.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			Date date = sdt.parse(format);

			gongji.setDate(date);
			gongji.setTitle(title);
			gongji.setContent(content);
			model.addAttribute("resultGongji", gongji);
			gongjiService.insert(gongji); // memberServiceImpl		

			return "gongji_result";
		}
	}

	// delete
	@RequestMapping(value = "/delete", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
	public String delete(@RequestParam int id, Model model) throws Exception {

		Gongji gongji = gongjiService.selectOne(id);
		model.addAttribute("del", gongji);
		gongjiService.delete(id);

		return "gongji_delete";
	}

	@RequestMapping(value = "/update", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
	public String update(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		Gongji item = gongjiService.selectOne(id);
		model.addAttribute("updateGongji", item);

		return "gongji_update";
	}

	// write
	@RequestMapping(value = "/write", method = { RequestMethod.GET, RequestMethod.POST }, headers = "Accept=application/json")
	public String write(HttpServletRequest request, Model model) throws Exception {

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));

		Gongji item = gongjiService.selectOne(id);
		model.addAttribute("writeGongji", item);

		if (request.getParameter("title").equals("") || request.getParameter("title") == null || request.getParameter("content").equals("") || request.getParameter("content") == null) {
			return "gongji_update";
		} else {
			String title = request.getParameter("title");
			String content = request.getParameter("content");

			item.setTitle(title);
			item.setContent(content);
			gongjiService.update(item); // memberServiceImpl		

			return "gongji_write";
		}
	}

}