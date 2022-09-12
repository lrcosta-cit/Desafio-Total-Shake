package br.com.desafio.totalshake.dto.response;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.model.ItemPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PedidoDTOResponse {

    private Long id;

    private LocalDateTime dataHora;

    private Status status;

    private List<ItemPedidoDTOResponse> itensPedidoList;

}
