package br.com.desafio.totalshake.service;

import br.com.desafio.totalshake.enums.Status;
import br.com.desafio.totalshake.exception.PedidoNotFoundException;
import br.com.desafio.totalshake.model.Pedido;
import br.com.desafio.totalshake.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    private PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository){
        this.pedidoRepository = pedidoRepository;
    }

    public Pedido buscarPorId(Long id){
        return pedidoRepository.findById(id).orElseThrow(() -> new PedidoNotFoundException("Pedido não encontrado."));
    }

    public List<Pedido> buscarTodos(){
      return pedidoRepository.findAll();
    }

    public Pedido salvar(Pedido pedido){
        pedido.setId(null);
        pedido.setDataHora(LocalDateTime.now());
        pedido.setStatus(Status.REALIZADO);
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizar(Long id, Pedido pedidoNovo){
        Pedido pedidoAtual = buscarPorId(id);

        pedidoAtual.setStatus(pedidoNovo.getStatus());

        return pedidoRepository.save(pedidoAtual);
    }

    public void excuirPorId(Long id){
        buscarPorId(id);
        pedidoRepository.deleteById(id);
    }



}
