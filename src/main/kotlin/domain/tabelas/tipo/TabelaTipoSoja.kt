package br.ufu.classisafra.data.tipo
import br.ufu.classisafra.data.tipo.data_model.LimiteForaDoTipoSoja
import br.ufu.classisafra.data.tipo.data_model.TipoSojaData
import br.ufu.classisafra.model.classificacao.grupo.GrupoSojaEnum
import domain.tabelas.tipo.interfaces.TabelaTipo

/**
 * Data class que representa uma tabela de tipos de grãos de Soja com seus limites de qualidade.
 *
 * Esta data class armazena informações sobre os limites de qualidade para diferentes tipos de grãos de Soja,
 * incluindo os tipos do Tipo 1, Tipo 2 e Padrão. Cada tipo possui limites específicos para várias características
 * de qualidade, como ardidos ou queimados, mofados, avariados, esverdeados, partidos, quebrados, amassados e impurezas.
 *
 * @property tipo1 O primeiro tipo de grão de Soja com seus limites de qualidade.
 * @property tipo2 O segundo tipo de grão de Soja com seus limites de qualidade.
 * @property padrao O tipo de grão de Soja padrão com seus limites de qualidade.
 * @property limiteForaDoTipo Limites para o Grão de soja ser classificado como fora Do tipo.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaTipoSoja (

    var tipo1: TipoSojaData = TipoSojaData(
        limiteArdidosQueimados = 1.0,
        limiteQueimados = 0.3,
        limiteMofados = 0.5,
        limiteAvariados = 4.0,
        limiteEsverdeados = 2.0,
        limitePartidosQuebradosAmassados = 8.0,
        limiteImpurezas = 1.0,
        grupo = GrupoSojaEnum.GRUPO_1,
    ),

    var tipo2: TipoSojaData = TipoSojaData(
        limiteArdidosQueimados = 2.0,
        limiteQueimados = 1.0,
        limiteMofados = 1.5,
        limiteAvariados = 6.0,
        limiteEsverdeados = 4.0,
        limitePartidosQuebradosAmassados = 15.0,
        limiteImpurezas = 1.0,
        grupo = GrupoSojaEnum.GRUPO_1
    ),

    var padrao: TipoSojaData = TipoSojaData(
        limiteArdidosQueimados = 4.0,
        limiteQueimados = 1.0,
        limiteMofados = 6.0,
        limiteAvariados = 8.0,
        limiteEsverdeados = 8.0,
        limitePartidosQuebradosAmassados = 30.0,
        limiteImpurezas = 1.0,
        grupo = GrupoSojaEnum.GRUPO_2
    ),

    var limiteForaDoTipo: LimiteForaDoTipoSoja = LimiteForaDoTipoSoja(
        limiteDefeitosGravesGrupo1 = 12.0,
        limiteDefeitosGravesGrupo2 = 40.0
    )

): TabelaTipo