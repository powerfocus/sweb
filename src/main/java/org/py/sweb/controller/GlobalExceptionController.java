package org.py.sweb.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = {"org.py.sweb.controller.index"})
public class GlobalExceptionController {
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception ex, Model model) {
        model.addAttribute("ex", ex);
        return "errorView";
    }
}
