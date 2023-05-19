package com.kinto2517.springsecondtask.Controller.Contract.Impl;

import com.kinto2517.springsecondtask.Controller.Contract.ProductControllerContract;
import com.kinto2517.springsecondtask.Dto.ProductDTO;
import com.kinto2517.springsecondtask.Dto.ProductSaveRequest;
import com.kinto2517.springsecondtask.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kinto2517.springsecondtask.Entity.Product;
import com.kinto2517.springsecondtask.Mapper.ProductMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductService productService;

    @Override
    public ProductDTO saveProduct(ProductSaveRequest productSaveRequest) {
        Product product = ProductMapper.INSTANCE.convertToProduct(productSaveRequest);
        Product savedProduct = productService.save(product);
        return ProductMapper.INSTANCE.convertToDTO(savedProduct);
    }

    @Override
    public List<ProductDTO> findAllProduct() {
        List<Product> productList = productService.findAll();
        return ProductMapper.INSTANCE.convertToDTOs(productList);
    }

    @Override
    public ProductDTO getProductById(Long id) {
        Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        return ProductMapper.INSTANCE.convertToDTO(product);
    }

    @Override
    public ProductDTO updateProduct(Double price, Long id) {
        Product updatedProduct = productService.update(price, id);
        return ProductMapper.INSTANCE.convertToDTO(updatedProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productService.deleteProductById(id);
    }
}
