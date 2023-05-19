package com.kinto2517.springsecondtask.Controller;

import com.kinto2517.springsecondtask.Controller.Contract.ProductControllerContract;
import com.kinto2517.springsecondtask.Dto.ProductDTO;
import com.kinto2517.springsecondtask.Dto.ProductSaveRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductControllerContract productControllerContract;

    @GetMapping("/all")
    public ResponseEntity<List<ProductDTO>> getAllProduct() {
        List<ProductDTO> productDTOList = productControllerContract.findAllProduct();
        return ResponseEntity.ok(productDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        ProductDTO productDTO = productControllerContract.getProductById(id);
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestParam("price") Double price,@PathVariable Long id) {
        ProductDTO productDTO = productControllerContract.updateProduct(price, id);
        return ResponseEntity.ok(productDTO);
    }

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductSaveRequest productSaveRequest) {
        ProductDTO productDTO1 = productControllerContract.saveProduct(productSaveRequest);
        return ResponseEntity.ok(productDTO1);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<ProductDTO>> deleteProductById(@PathVariable Long id) {
        productControllerContract.deleteProductById(id);
        return ResponseEntity.ok().build();
    }

}
