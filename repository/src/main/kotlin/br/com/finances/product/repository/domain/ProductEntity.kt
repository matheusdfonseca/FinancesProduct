package br.com.finances.product.repository.domain

import javax.persistence.*

@Entity
@Table(name = "tb_produtos")
data class ProductEntity(
    @Id @Column(name = "id_produto") @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = 0,

    @Column(name = "nm_produto")
    var name: String? = null,

    @Column(name = "descricao")
    var description: String? = null,

    @OneToMany(mappedBy = "product", targetEntity = DetailsNegociationEntity::class, fetch = FetchType.LAZY)
    var detailsNegociations: List<DetailsNegociationEntity>? = null
)
