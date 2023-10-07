package br.ufu.classisafra.data.tipo.data_model

/**
 * Data class que representa os limites de qualidade para o tipo de grão Milho.
 *
 * Esta data class contém informações sobre os limites de qualidade específicos
 * para o grão de Milho, incluindo limites para características como ardidos,
 * avariados, quebrados, matérias estranhas e carunchados.
 *
 * @property limiteArdidosQueimados O limite tolerado para grãos ardidos ou queimados.
 * @property limiteAvariados O limite tolerado para grãos avariados.
 * @property limiteQuebrados O limite tolerado para grãos quebrados.
 * @property limiteImpurezas O limite tolerado de impurezas e matérias estranhas nos grãos.
 * @property limiteCarunchados O limite tolerado para grãos carunchados.
 * @author Victor Hugo Ferreira Silva
 */
data class TipoMilhoData(
    var limiteArdidosQueimados: Double,
    var limiteAvariados: Double,
    var limiteQuebrados: Double,
    var limiteImpurezas: Double,
    var limiteCarunchados: Double
)
