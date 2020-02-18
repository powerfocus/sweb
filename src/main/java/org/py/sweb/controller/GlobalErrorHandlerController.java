package org.py.sweb.controller;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/")
public class GlobalErrorHandlerController implements ErrorController {
    @Override
    public String getErrorPath() {
        return "errorView";
    }
    @RequestMapping({"error"})
    public String errorHandler(HttpServletRequest request, HttpServletResponse response, Model model) {
        switch(response.getStatus()) {
            case 404:
                model.addAttribute("ex", new IllegalStateException("你访问的页面不存在！"));
                break;
            case 403:
                model.addAttribute("ex", new IllegalStateException("你的请求被服务器拒绝！"));
                break;
            case 500:
                model.addAttribute("ex", new IllegalStateException("服务器出现内部错误！系统将终止。"));
                break;
            default:
                model.addAttribute("ex", new IllegalStateException("服务器发生错误，即将终止！"));
                break;
        }
        return "errorView";
    }
}
