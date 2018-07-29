package com.sainty.study.controller.home;

import com.sainty.study.domain.home.User;
import com.sainty.study.service.home.HomeService;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by cdyujing7 on 2018/7/27.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    private static final String PAGE_MODEL = "pageModel";
    @Resource
    private HomeService homeService;

    @RequestMapping("")
    public String home(Model model, String name) {
        User user = homeService.queryBloggerInfo(name);
        model.addAttribute(PAGE_MODEL, user);
        return "home/home";
    }
}
