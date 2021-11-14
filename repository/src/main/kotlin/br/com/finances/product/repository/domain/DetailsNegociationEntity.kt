package br.com.finances.product.repository.domain

import br.com.finances.product.output.repository.enumerated.DetailsNegociationTypeEnum
import java.math.BigDecimal
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_detalhes_negociacao")
data class DetailsNegociationEntity(
    @Id @Column(name = "id_detalhes_negociacao") @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto")
    var product: ProductEntity? = null,

    @Column(name = "preco_estimado")
    var estimatedPrice: BigDecimal? = null,

    @Column(name = "preco_final")
    var finalPrice: BigDecimal? = null,

    @Enumerated(EnumType.STRING) @Column(name = "tp_negociacao")
    var typeNegociation: DetailsNegociationTypeEnum? = null,

    @Column(name = "dh_estimada_negociacao")
    var estimatedNegociationAt: LocalDateTime? = null,

    @Column(name = "dh_final_negociacao")
    var finalNegociationAt: LocalDateTime? = null,

    @Column(name = "dh_criacao")
    var createdAt: LocalDateTime? = null
)
