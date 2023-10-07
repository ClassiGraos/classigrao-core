package br.ufu.classisafra.data.classe

/**
 * Data class que representa os valores mínimos das classes de Soja.
 *
 * Esta data class armazena informações sobre os requisitos mínimos para as classes de grãos de Soja,
 * incluindo o valor mínimo de porcentagem de grãos amarelos para serem classificados como tal.
 *
 * @property minimoGraosAmarelos O valor mínimo de porcentagem de grãos amarelos.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaClasseSoja(
    var minimoGraosAmarelos: Double = 90.0
) : TabelaClasse
