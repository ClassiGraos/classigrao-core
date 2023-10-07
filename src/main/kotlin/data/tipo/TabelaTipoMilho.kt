package br.ufu.classisafra.data.tipo

import br.ufu.classisafra.data.tipo.data_model.TipoMilhoData

/**
 * Data class que representa uma tabela de tipos de grãos de Milho com seus limites de qualidade.
 *
 * Esta data class armazena informações sobre os limites de qualidade para diferentes tipos de grãos de Milho,
 * incluindo os tipos do Tipo 1, Tipo 2, Tipo 3 e Fora do Tipo. Cada tipo possui limites específicos para várias
 * características de qualidade, como ardidos ou queimados, avariados, quebrados, impurezas e carunchados.
 *
 * @property tipo1 O primeiro tipo de grão de Milho com seus limites de qualidade.
 * @property tipo2 O segundo tipo de grão de Milho com seus limites de qualidade.
 * @property tipo3 O terceiro tipo de grão de Milho com seus limites de qualidade.
 * @property foraDeTipo O tipo de grão de Milho considerado "fora de tipo" com seus limites de qualidade.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaTipoMilho (
    var tipo1: TipoMilhoData = TipoMilhoData(
        limiteArdidosQueimados = 1.0,
        limiteAvariados = 6.0,
        limiteQuebrados = 3.0,
        limiteImpurezas = 1.0,
        limiteCarunchados = 2.0
    ),
    var tipo2: TipoMilhoData = TipoMilhoData(
        limiteArdidosQueimados = 2.0,
        limiteAvariados = 10.0,
        limiteQuebrados = 4.0,
        limiteImpurezas = 1.5,
        limiteCarunchados = 3.0
    ),
    var tipo3: TipoMilhoData = TipoMilhoData(
        limiteArdidosQueimados = 3.0,
        limiteAvariados = 15.0,
        limiteQuebrados = 5.0,
        limiteImpurezas = 2.0,
        limiteCarunchados = 4.0
    ),
    var foraDeTipo: TipoMilhoData = TipoMilhoData(
        limiteArdidosQueimados = 5.0,
        limiteAvariados = 20.0,
        limiteQuebrados = Double.POSITIVE_INFINITY,
        limiteImpurezas = Double.POSITIVE_INFINITY,
        limiteCarunchados = 8.0
    )
) : TabelaTipo
