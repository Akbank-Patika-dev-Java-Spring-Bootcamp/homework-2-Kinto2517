package com.kinto2517.springsecondtask.Service;

import com.kinto2517.springsecondtask.Base.BaseEntityService;
import com.kinto2517.springsecondtask.Dao.ProductRepository;
import com.kinto2517.springsecondtask.Entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends BaseEntityService<Product, ProductRepository> {

    private final ProductRepository productRepository;
    public ProductService(ProductRepository repository, ProductRepository productRepository) {
        super(repository);
        this.productRepository = productRepository;
    }

    public Product update(Double price, Long id){
        Product productFromDB = findById(id).orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        productFromDB.setPrice(price);
        return save(productFromDB);
    }

    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found by id: " + id));
        productRepository.delete(product);
    }

}
