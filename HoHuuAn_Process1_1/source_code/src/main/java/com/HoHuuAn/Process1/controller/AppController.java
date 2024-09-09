package com.HoHuuAn.Process1.controller;


import com.HoHuuAn.Process1.model.Product;
import com.HoHuuAn.Process1.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class AppController {
    @Autowired
    private ProductServiceImpl service;

    @GetMapping(value = "/")
    public String viewHomePage(Model model){
        return listByPage(model, 1, "name", "asc", "");
    }

    @GetMapping(value = "/page/{pageNumber}")
    public String listByPage(Model model, @PathVariable("pageNumber") int currentPage,
                             @Param("sortField") String sortField,
                             @Param("sortDir") String sortDir,
                             @Param("keyword") String keyword){
        Page<Product> page = service.listAll(currentPage, sortField, sortDir, keyword);
        Long totalItems = page.getTotalElements();
        int totalPages = page.getTotalPages();

        List<Product> listProducts = page.getContent();

        model.addAttribute("listProduct", listProducts);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("currentPage", currentPage);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);

        String reverseSortDir = sortDir.equals("asc")?"desc":"asc";
        model.addAttribute("reverseSortDir", reverseSortDir);

        return "index";
    }

    @GetMapping(value = "/new")
    public String showNewProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping(value = "/save")
    public String save(@ModelAttribute("product") Product product){
        service.addOrSave(product);
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String showEditProductPage(@PathVariable(name = "id") Long id, Model model) {
        Product product = service.getProductById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id) {
        service.deleteProductById(id);
        return "redirect:/";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/";
    }
}
