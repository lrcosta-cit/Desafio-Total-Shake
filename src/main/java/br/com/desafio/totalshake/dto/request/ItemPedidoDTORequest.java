package br.com.desafio.totalshake.dto.request;

import br.com.desafio.totalshake.model.Pedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedidoDTORequest {

    @NotBlank
    private Integer quantidade;
    @NotBlank
    private String descricao;

    private Pedido pedido;

}