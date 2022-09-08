package br.com.desafio.totalshake.controller;

import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable("id") Long id){
        return ResponseEntity.ok(pedidoService.buscarPorId(id));
    }

    @GetMapping("/pedidos")
    public ResponseEntity<List<Pedido>> buscarTodosPedidos(){
        return ResponseEntity.ok(pedidoService.buscarTodos());
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Pedido> salvarPedido(@RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvar(pedido));
    }

    @PutMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable("id") Long id, @RequestBody Pedido pedido){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(pedidoService.atualizar(id, pedido));
    }

    @DeleteMapping("/pedidos/{id}")
    public ResponseEntity<Pedido> excluirPedido(@PathVariable("id") Long id){
        pedidoService.excuirPorId(id);
        return ResponseEntity.noContent().build();
    }

}
