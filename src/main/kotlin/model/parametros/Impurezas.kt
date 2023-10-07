package br.ufu.classisafra.model.parametros

import br.ufu.classisafra.model.classificacao.tipos_defeitos.TiposImpurezas

/**
 * Classe que representa as impurezas em grãos, com informações sobre peso, amostra e limite tolerado.
 *
 * Esta classe herda de [Defeito] e fornece informações específicas para impurezas em grãos, incluindo peso,
 * peso da amostra e limite tolerado.
 *
 * @param pesoEmGramas O peso das impurezas em gramas (deve ser maior ou igual a zero).
 * @param amostraEmGramas O peso da amostra em gramas (deve ser maior ou igual a zero).
 * @param limiteToleradoEmPorcentagem O limite tolerado de impurezas em porcentagem (deve estar entre 0 e 100).
 * @author Victor Hugo Ferreira Silva
 */
class Impurezas (

    pesoEmGramas: Double,
    amostraEmGramas: Double,
    limiteToleradoEmPorcentagem: Double

) : Defeito(
    tipo = TiposImpurezas.IMPUREZAS,
    pesoEmGramas = pesoEmGramas,
    amostraEmGramas = amostraEmGramas,
    desagio = 0.0,
    limiteToleradoEmPorcentagem = limiteToleradoEmPorcentagem

)