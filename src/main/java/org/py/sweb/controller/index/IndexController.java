package org.py.sweb.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping({"", "index"})
    public String index(Model view) {
        view.addAttribute("title", "站点首页");
        return "index/index/index";
    }
}
