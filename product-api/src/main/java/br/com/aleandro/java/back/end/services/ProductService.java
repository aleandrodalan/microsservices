package br.com.aleandro.java.back.end.services;

import br.com.aleandro.java.back.end.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;
}
