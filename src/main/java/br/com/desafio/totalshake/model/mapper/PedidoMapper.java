package br.com.desafio.totalshake.model.mapper;

import br.com.desafio.totalshake.dto.request.ItemPedidoDTORequest;
import br.com.desafio.totalshake.dto.request.PedidoDTORequest;
import br.com.desafio.totalshake.dto.response.ItemPedidoDTOResponse;
import br.com.desafio.totalshake.dto.response.PedidoDTOResponse;
import br.com.desafio.totalshake.model.ItemPedido;
import br.com.desafio.totalshake.model.Pedido;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PedidoMapper {

    private final ModelMapper modelMapper;

    public PedidoMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public Pedido convertPedidoDTOResquestToPedido(PedidoDTORequest pedidoDTORequest){
        return modelMapper.map(pedidoDTORequest, Pedido.class);
    }

    public PedidoDTOResponse convertPedidoToPedidoDTOResponse(Pedido pedido){
        return modelMapper.map(pedido, PedidoDTOResponse.class);
    }

    public ItemPedido convertItemPedidoDTOResquestToItemPedido(ItemPedidoDTORequest itemPedidoDTORequest){
        return modelMapper.map(itemPedidoDTORequest, ItemPedido.class);
    }

    public ItemPedidoDTOResponse convertItemPedidoToItemPedidoDTOResponse(ItemPedido itemPedido){
        return modelMapper.map(itemPedido, ItemPedidoDTOResponse.class);
    }



}
