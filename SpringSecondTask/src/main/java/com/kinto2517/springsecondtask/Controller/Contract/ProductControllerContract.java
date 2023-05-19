package com.kinto2517.springsecondtask.Controller.Contract;

import com.kinto2517.springsecondtask.Dto.PersonDTO;
import com.kinto2517.springsecondtask.Dto.PersonSaveRequest;
import com.kinto2517.springsecondtask.Dto.ProductDTO;
import com.kinto2517.springsecondtask.Dto.ProductSaveRequest;
import com.kinto2517.springsecondtask.Entity.Product;

import java.util.List;

public interface ProductControllerContract {
    ProductDTO saveProduct(ProductSaveRequest productSaveRequest);
    List<ProductDTO> findAllProduct();
    ProductDTO getProductById(Long id);
    ProductDTO updateProduct(Double price, Long id);
    void deleteProductById(Long id);
}
