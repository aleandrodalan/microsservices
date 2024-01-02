package br.com.aleandro.java.back.end.models;

import br.com.aleandro.java.back.end.dtos.ProductDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private Float preco;
    private String descricao;
    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDTO productDTO) {
        Product product = new Product();
        product.setNome(productDTO.getNome());
        product.setPreco(productDTO.getPreco());
        product.setProductIdentifier(productDTO.getProductIdentifier());
        product.setDescricao(productDTO.getDescricao());

        if (productDTO.getCategoryDTO() != null) {
            product.setCategory(
                    Category.convert(productDTO.getCategoryDTO()));
        }
        return product;
    }
}
