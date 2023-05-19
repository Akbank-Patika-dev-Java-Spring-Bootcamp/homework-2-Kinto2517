package com.kinto2517.springsecondtask.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.kinto2517.springsecondtask.Entity.Product;
import com.kinto2517.springsecondtask.Dto.ProductDTO;
import com.kinto2517.springsecondtask.Dto.ProductSaveRequest;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    Product convertToProduct(ProductSaveRequest productSaveRequest);
    ProductDTO convertToDTO(Product product);
    List<ProductDTO> convertToDTOs(List<Product> products);

}
