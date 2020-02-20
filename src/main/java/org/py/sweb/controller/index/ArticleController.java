package org.py.sweb.controller.index;

import org.py.sweb.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/art")
public class ArticleController {
    @GetMapping({""})
    public String index(Article art) {
        return "index/article/index";
    }

    @PostMapping({""})
    public String action(@Valid Article art, Model model, BindingResult errors) {
        if(errors.hasErrors()) {
            System.out.println("验证时发生错误：");
            errors.getAllErrors().forEach(System.out::printlng);
            return "index/article/index";
        } else {
            model.addAttribute("icon", ":)");
            model.addAttribute("href", "index/article/index");
            model.addAttribute("msg", "保存文章成功！");
            return "msg";
        }
    }
}
