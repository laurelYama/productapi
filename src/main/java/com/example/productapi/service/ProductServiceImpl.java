package com.example.productapi.service;

import com.example.productapi.exceptions.ProductNotExistException;
import com.example.productapi.modal.Category;
import com.example.productapi.modal.Product;
import com.example.productapi.modal.dto.ProductRequestDTO;
import com.example.productapi.modal.dto.ProductResponseDTO;
import com.example.productapi.modal.mapper.ProductMapper;
import com.example.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();

        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for (int i = 0; i<products.size();i++){
            ProductResponseDTO productResponseDTO = productMapper.getresponse(products.get(i));
            productResponseDTOS.add(productResponseDTO);
        }
        return productResponseDTOS;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        // Utilisation de Optional pour éviter les valeurs nulles
        Product product = productRepository.findById(id).orElse(null);

       return productMapper.getresponse(product);
    }

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {

        Category category= categoryServiceImpl.getCategoryRepository().findByName(productRequestDTO.getNomCategorie());
        Product product = productMapper.getrequest(productRequestDTO,category);
        Product productToSave = productRepository.save(product);
        return productMapper.getresponse(productToSave);
    }

    @Override
    public ProductResponseDTO updateProduct(Long id, ProductRequestDTO productRequestDTO) {
        Category category= categoryServiceImpl.getCategoryRepository().findByName(productRequestDTO.getNomCategorie());
        // Vérifie si le produit existe

        if (!productRepository.existsById(id)) {
            return null; // Ou lever une exception personnalisée
        }
        Product product = productMapper.getrequest(productRequestDTO,category);
        Product productUpdate = productRepository.save(product);

        return productMapper.getresponse(productUpdate);
    }

    @Override
    public void deleteProduct(Long id) {
        // Vérifie si le produit existe avant de le supprimer
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        }
    }

    @Override
    public Page<ProductResponseDTO> getAllProducts(Pageable pageable) {

        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> productResponseDTOS = new ArrayList<>();

        for (int i = 0; i<products.size();i++){
            ProductResponseDTO productResponseDTO = productMapper.getresponse(products.get(i));
            productResponseDTOS.add(productResponseDTO);
        }

        PageRequest pageRequest = PageRequest.of(pageable.getPageSize(), pageable.getPageNumber());

        int start = (int) pageRequest.getOffset();
        int end = Math.min(start + pageable.getPageSize(), products.size());

        List<ProductResponseDTO> pages = productResponseDTOS.subList(start, end);

        return new PageImpl<>(pages, pageRequest, pages.size());
    }
    @Override
    public ProductResponseDTO getProductByName(String name) {
        Product products =  productRepository.findByName(name);
        if (products == null) {
            throw  new ProductNotExistException("PRODUCT NOT FOUND","1000","Le product "+name+" n'existe pas ");
        }
        return productMapper.getresponse(products);
    }
}
