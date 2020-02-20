package org.py.sweb.controller.index;

import org.py.sweb.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/art")
public class ArticleController {
    @GetMapping({""})
    public String index(@ModelAttribute Article article) {
        article.setArtLock(false);
        return "index/article/index";
    }

    @PostMapping({""})
    public String action(@Valid Article article, BindingResult result, Model model) {
        if(result.hasErrors()) {
            result.getAllErrors().forEach(System.out::println);
            return "index/article/index";
        }
        model.addAttribute("icon", ":)");
        model.addAttribute("msg", "操作成功！");
        model.addAttribute("target", "/art");
        return "msg";
    }
}
