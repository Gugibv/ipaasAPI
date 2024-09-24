package grey.controller;

import grey.ncs.management.api.product.productManagemet_new;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @GetMapping("/query")
    public String query(){
        return   productManagemet_new.findById();
    }
}