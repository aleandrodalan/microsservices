package br.com.aleandro.java.back.end.dtos;

import br.com.aleandro.java.back.end.models.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {

    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String nome;

    @NotBlank
    private String descricao;

    @NotNull
    private Float preco;

    private CategoryDTO categoryDTO;

    public static ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setNome(product.getNome());
        productDTO.setPreco(product.getPreco());
        productDTO.setProductIdentifier(
                product.getProductIdentifier());
        productDTO.setDescricao(product.getDescricao());
        if (product.getCategory() != null) {
            productDTO.setCategoryDTO(
                    CategoryDTO.convert(product.getCategory()));
        }
        return productDTO;
    }
}
