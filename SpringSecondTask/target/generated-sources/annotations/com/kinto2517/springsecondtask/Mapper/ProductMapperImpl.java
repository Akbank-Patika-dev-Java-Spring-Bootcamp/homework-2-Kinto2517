package com.kinto2517.springsecondtask.Mapper;

import com.kinto2517.springsecondtask.Dto.ProductDTO;
import com.kinto2517.springsecondtask.Dto.ProductSaveRequest;
import com.kinto2517.springsecondtask.Entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-19T11:46:26+0300",
    comments = "version: 1.5.1.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product convertToProduct(ProductSaveRequest productSaveRequest) {
        if ( productSaveRequest == null ) {
            return null;
        }

        Product product = new Product();

        product.setName( productSaveRequest.name() );
        product.setPrice( productSaveRequest.price() );
        product.setQuantity( productSaveRequest.quantity() );

        return product;
    }

    @Override
    public ProductDTO convertToDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        double price = 0.0d;
        int quantity = 0;

        id = product.getId();
        name = product.getName();
        price = product.getPrice();
        quantity = product.getQuantity();

        ProductDTO productDTO = new ProductDTO( id, name, price, quantity );

        return productDTO;
    }

    @Override
    public List<ProductDTO> convertToDTOs(List<Product> products) {
        if ( products == null ) {
            return null;
        }

        List<ProductDTO> list = new ArrayList<ProductDTO>( products.size() );
        for ( Product product : products ) {
            list.add( convertToDTO( product ) );
        }

        return list;
    }
}
