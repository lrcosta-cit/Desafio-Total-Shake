package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.dto.request.PedidoDTORequest;
import br.com.desafio.totalshake.dto.response.ItemPedidoDTOResponse;
import br.com.desafio.totalshake.dto.response.PedidoDTOResponse;
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
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoMapper;

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDTOResponse> buscarPedidoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.buscarPorId(id)));
    }

    @GetMapping("/pedidos/{id}/itensPedido")
    public ResponseEntity<List<ItemPedidoDTOResponse>> buscarItemPedidoPorIdPedido(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.buscarPorId(id)).getItensPedidoList());
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<PedidoDTOResponse>> buscarTodosPedidos(){
        return ResponseEntity.ok(pedidoService.buscarTodos().stream()
                .map(p -> pedidoMapper.convertPedidoToPedidoDTOResponse(p)).collect(Collectors.toList()));
    }

    @PostMapping("/pedidos")
    public ResponseEntity<PedidoDTOResponse> salvarPedido(@Valid @RequestBody PedidoDTORequest pedidoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.salvar(pedidoMapper.convertPedidoDTOResquestToPedido(pedidoDTORequest))));
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDTOResponse> atualizarPedido(@PathVariable("id") Long id, @Valid @RequestBody PedidoDTORequest pedidoDTORequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoMapper.convertPedidoToPedidoDTOResponse(
                pedidoService.atualizar(id, pedidoMapper.convertPedidoDTOResquestToPedido(pedidoDTORequest))));
    }

    @PutMapping("/pedidos/{id}/itensPedido")
    public ResponseEntity<PedidoDTOResponse> atualizarListaItensPedido(@PathVariable("id") Long id, @Valid @RequestBody PedidoDTORequest pedidoDTORequest){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                pedidoMapper.convertPedidoToPedidoDTOResponse(pedidoService.atualizarItensPedido(id, pedidoMapper.convertPedidoDTOResquestToPedido(pedidoDTORequest))));
    }


    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<PedidoDTOResponse> excluirPedido(@PathVariable("id") Long id){
        pedidoService.excuirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
