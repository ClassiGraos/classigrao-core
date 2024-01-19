package br.ufu.classisafra.data.tipo.data_model

import br.ufu.classisafra.model.classificacao.grupo.GrupoSoja

/**
 * Data class que representa os limites de qualidade para o tipo de grão Soja.
 *
 * Esta data class contém informações sobre os limites de qualidade específicos
 * para o grão Soja, incluindo limites para características como ardidos
 * ou queimados, mofados, avariados, esverdeados, partidos, quebrados, amassados
 * e impurezas.
 *
 * @property limiteArdidosQueimados O limite tolerado para grãos ardidos ou queimados.
 * @property limiteQueimados O limite tolerado para grãos queimados.
 * @property limiteMofados O limite tolerado para grãos mofados.
 * @property limiteAvariados O limite tolerado para grãos avariados.
 * @property limiteEsverdeados O limite tolerado para grãos esverdeados.
 * @property limitePartidosQuebradosAmassados O limite tolerado para grãos partidos, quebrados ou amassados.
 * @property limiteImpurezas O limite tolerado para impurezas e matérias estranhas nos grãos.
 * @property grupo O grupo ao qual este tipo se enquadra.
 * @author Victor Hugo Ferreira Silva
 */
data class TipoSojaData(
    var limiteArdidosQueimados: Double,
    var limiteQueimados: Double,
    var limiteMofados: Double,
    var limiteAvariados: Double,
    var limiteEsverdeados: Double,
    var limitePartidosQuebradosAmassados: Double,
    var limiteImpurezas: Double,
    var grupo: GrupoSoja
)