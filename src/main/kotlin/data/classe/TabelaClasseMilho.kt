package br.ufu.classisafra.data.classe
/**
 * Data class que representa os valores mínimos de uma Classe de Milho.
 *
 * Esta data class armazena informações sobre os requisitos mínimos para diferentes classes de grãos
 * de Milho, incluindo as classes Grãos Amarelos, Grãos Brancos e Grãos de Outras Cores. Cada classe tem
 * um valor mínimo especificado para atender aos critérios de qualidade.
 *
 * @property minimoGraosAmarelos O valor mínimo de qualidade para grãos da classe Grãos Amarelos.
 * @property minimoGraosBrancos O valor mínimo de qualidade para grãos da classe Grãos Brancos.
 * @property minimoGraosOutrasCores O valor mínimo de qualidade para grãos da classe Grãos de Outras Cores.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaClasseMilho(
    var minimoGraosAmarelos: Double = 95.0,
    var minimoGraosBrancos: Double = 95.0,
    var minimoGraosOutrasCores: Double = 95.0
) : TabelaClasse
