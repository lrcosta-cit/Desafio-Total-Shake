package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.request.ItemPedidoDTORequest;
import br.com.desafio.totalshake.dto.response.ItemPedidoDTOResponse;
import br.com.desafio.totalshake.dto.response.PedidoDTOResponse;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.model.mapper.PedidoMapper;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/pedidos")
public class ItemPedidoController {

    @Autowired
    PedidoService pedidoService;

    @Autowired
    PedidoMapper pedidoMapper;

    @GetMapping("/{id}/itens")
    public ResponseEntity<List<ItemPedidoDTOResponse>> todosItensPedido(@PathVariable("id") Long id){
        List<ItemPedidoDTOResponse> itens = pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.buscarPorId(id)).getItensPedidoList();
        return ResponseEntity.ok(itens);
    }

    @PostMapping("/{id}/itens")
    public ResponseEntity<PedidoDTOResponse> adicionarItensPedido(@PathVariable("id") Long id, @Valid @RequestBody List<ItemPedidoDTORequest> itens){
        Pedido pedido = pedidoService.buscarPorId(id);

        for (ItemPedidoDTORequest item : itens) {
            item.setPedido(pedido);
        }
        pedido.setItensPedidoList(itens.stream().map(i -> pedidoMapper.convertItemPedidoDTOResquestToItemPedido(i)).collect(Collectors.toList()));

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.salvar(pedido)));

    }


}
