package br.ufu.classisafra.data.tipo.data_model
/**
 * Esta classe representa os limites de defeitos graves para grãos de soja fora do tipo.
 *
 * @property limiteDefeitosGravesGrupo1 O limite de defeitos graves para grãos de soja do Grupo 1 serem classificados como fora do tipo.
 * @property limiteDefeitosGravesGrupo2 O limite de defeitos graves para grãos de soja do Grupo 2 serem classificados como fora do tipo.
 * @author Victor Hugo Ferreira Silva
 */
data class LimiteForaDoTipoSoja (
    var limiteDefeitosGravesGrupo1: Double,
    var limiteDefeitosGravesGrupo2: Double
)