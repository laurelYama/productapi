package com.example.productapi.service;

import com.example.productapi.exceptions.ProductNotExistException;
import com.example.productapi.modal.Category;
import com.example.productapi.modal.Product;
import com.example.productapi.modal.dto.CategoryRequestDTO;
import com.example.productapi.modal.dto.CategoryResponseDTO;
import com.example.productapi.modal.dto.ProductResponseDTO;
import com.example.productapi.modal.mapper.CategoryMapper;
import com.example.productapi.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryResponseDTO> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec ID : " + id));
        return categoryMapper.toDto(category);
    }

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryMapper.toEntity(categoryRequestDTO);
        Category savedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(savedCategory);
    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée avec ID : " + id));
        category.setName(categoryRequestDTO.getName());
        Category updatedCategory = categoryRepository.save(category);
        return categoryMapper.toDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Catégorie non trouvée avec ID : " + id);
        }
        categoryRepository.deleteById(id);
    }

    public CategoryResponseDTO categoryResponseDTO(String name) {
        Category category =  categoryRepository.findByName(name);
        if (category == null) {
            throw  new ProductNotExistException("PRODUCT NOT FOUND","1000","Le product "+name+" n'existe pas ");
        }
        return productMapper.getresponse(category);
    }
}
