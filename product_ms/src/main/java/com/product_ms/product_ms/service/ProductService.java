package com.product_ms.product_ms.service;

import com.product_ms.product_ms.dto.ProductDto;
import com.product_ms.product_ms.entity.ProductEntity;
import com.product_ms.product_ms.repository.ProductRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j @Data
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductDto createProduct(ProductDto productDto){
        ProductEntity productEntity = modelMapper.map(productDto, ProductEntity.class);
        productRepository.save(productEntity);
        log.info("Product created success");
        return modelMapper.map(productEntity, ProductDto.class);
    }

    public List<ProductDto> getAllProducts(Pageable pageable){
        return  productRepository.findAll().stream().map(product -> modelMapper.map(product, ProductDto.class)).toList();
    }

}
