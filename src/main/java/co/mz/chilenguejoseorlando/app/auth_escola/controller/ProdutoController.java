package co.mz.chilenguejoseorlando.app.auth_escola.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProdutoController {

    @GetMapping("/")
    @PreAuthorize("hasRole(USER)")
    public String list(){
        return ":listando produtos";
    }


    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public String create (){
        return ":cadastrando produto";
    }

}
