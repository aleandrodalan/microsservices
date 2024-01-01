package br.com.aleandro.java.back.end.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryDTO {

    @NotNull
    private Long id;

    @NotBlank
    private String nome;
}
