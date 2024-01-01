package br.com.aleandro.java.back.end.dtos;

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
}
