package br.com.desafio.totalshake.model;

import br.com.desafio.totalshake.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;


@Entity(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToMany(
            fetch = FetchType.LAZY,
            mappedBy = "pedido",
            cascade = CascadeType.ALL,
            orphanRemoval = false)
    private List<ItemPedido> itensPedidoList;

    @PrePersist
    void prePersist(){
        this.dataHora = LocalDateTime.now();
        this.status = Status.REALIZADO;
    }

}
