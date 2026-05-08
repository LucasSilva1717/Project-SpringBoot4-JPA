package application.Resource;

import java.util.List;
import application.services.ProductServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import application.entities.Product;



@RestController
@RequestMapping (value = "/Products")
public class ProductResource {
    
    @Autowired
    private ProductServices service;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id) {
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
