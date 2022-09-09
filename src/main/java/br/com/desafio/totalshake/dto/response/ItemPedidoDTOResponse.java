package br.com.desafio.totalshake.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ItemPedidoDTOResponse {

    private Long id;

    private Integer quantidade;

    private String descricao;

    private Long pedidoId;

}
