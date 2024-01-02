package br.com.aleandro.java.back.end.services;

import br.com.aleandro.java.back.end.dtos.ProductDTO;
import br.com.aleandro.java.back.end.models.Product;
import br.com.aleandro.java.back.end.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDTO> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> getProductByCategoryId(
            Long categoryId) {
        List<Product> products =
                productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(ProductDTO::convert)
                .collect(Collectors.toList());
    }
    public ProductDTO findByProductIdentifier(
            String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDTO.convert(product);
        }
        return null;
    }
    public ProductDTO save(ProductDTO productDTO) {
        Product product =
                productRepository.save(Product.convert(productDTO));
        return ProductDTO.convert(product);
    }
    public void delete(long productId) {
        Optional<Product> product =
                productRepository.findById(productId);
        product.ifPresent(value -> productRepository.delete(value));
    }
}
