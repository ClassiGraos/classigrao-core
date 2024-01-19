package br.ufu.classisafra.data.grupo

/**
 * Data class que representa os valores mínimos de cada Grupo de Milho.
 *
 * Esta data class armazena informações sobre os requisitos mínimos para diferentes grupos de grãos
 * de Milho, incluindo os grupos Grãos Duros, Grãos Semiduros e Grãos Dentados. Cada grupo tem um valor
 * mínimo especificado para atender aos critérios do grupo.
 *
 * @property minimoGraosDuros O valor mínimo de qualidade para grãos do grupo Grãos Duros.
 * @property minimoGraosSemiduros O valor mínimo de qualidade para grãos do grupo Grãos Semiduros.
 * @property minimoGraosDentados O valor mínimo de qualidade para grãos do grupo Grãos Dentados.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaGrupoMilho (
    var minimoGraosDuros: Double = 85.0,
    var minimoGraosSemiduros: Double = 85.0,
    var minimoGraosDentados: Double = 85.0,
)