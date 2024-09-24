package grey.controller;

import grey.ncs.management.api.purchaseOrder.PurchaseOrderManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/purchaseOrder")
public class PurchaseOrderController {

    @GetMapping("/query")
    public String query(){
        return PurchaseOrderManagement.findById();
    }
}
