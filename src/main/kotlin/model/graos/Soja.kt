package br.ufu.classisafra.model.graos

import br.ufu.classisafra.data.classe.TabelaClasse
import br.ufu.classisafra.data.classe.TabelaClasseSoja
import br.ufu.classisafra.data.tipo.TabelaTipo
import br.ufu.classisafra.data.tipo.TabelaTipoSoja
import br.ufu.classisafra.data.tipo.data_model.TipoSojaData
import br.ufu.classisafra.model.classificacao.classe.Classe
import br.ufu.classisafra.model.classificacao.classe.ClasseSoja
import br.ufu.classisafra.model.classificacao.tipos_defeitos.TiposDefeitosSoja
import br.ufu.classisafra.model.classificacao.grupo.Grupo
import br.ufu.classisafra.model.classificacao.grupo.GrupoSoja
import br.ufu.classisafra.model.classificacao.tipo.Tipo
import br.ufu.classisafra.model.classificacao.tipo.TipoSoja
import br.ufu.classisafra.model.parametros.Defeito
import br.ufu.classisafra.model.parametros.defeitos.DefeitosSoja
import br.ufu.classisafra.model.parametros.Impurezas
import br.ufu.classisafra.model.parametros.Umidade

/**
 * Esta classe representa grãos de soja, incluindo informações sobre defeitos e características específicas.
 *
 * @property amostraEmGramas Peso da amostra em gramas.
 * @property pesoInicialEmKg Peso inicial do lote de grãos em quilogramas (kg).
 * @property umidade Percentagem de umidade dos grãos.
 * @property impurezas Percentagem de impurezas nos grãos.
 * @property defeitos Lista de defeitos encontrados nos grãos.
 * @property graosAmarelosEmGramas Peso dos grãos amarelos em gramas.
 * @property graosOutrasCoresEmGramas Peso dos grãos de outras cores em gramas.
 */
class Soja(
    amostraEmGramas: Double,
    pesoInicialEmKg: Double,
    umidade: Umidade,
    impurezas: Impurezas,
    defeitos: List<Defeito>,
    var amostraClasseEmGramas: Double,
    var graosAmarelosEmGramas: Double,
    var graosOutrasCoresEmGramas: Double
) : Graos(
    amostraEmGramas = amostraEmGramas,
    pesoInicialEmKg = pesoInicialEmKg,
    umidade = umidade,
    impurezas = impurezas,
    defeitos = defeitos
) {

    /**
     * Estrutura DefeitosSoja, a qual os defeitos da Soja serão mapeados.
     */
    lateinit var defeitosSoja : DefeitosSoja

    /**
     * Determina o tipo dos grãos de soja com base em uma tabela de tipos específica.
     *
     * @param tabelaTipo A tabela de tipos usada para determinar o tipo dos grãos.
     * @return O tipo dos grãos de soja.
     * @throws IllegalArgumentException Se a tabela de tipos não for do tipo TabelaTipoSoja.
     */
    fun determinarTipo(tabelaTipo: TabelaTipo, grupoSoja: GrupoSoja): Tipo {
        if (tabelaTipo !is TabelaTipoSoja) throw IllegalArgumentException("A tabela de tipo utilizada não é referente a Soja.")

        defeitosSoja = mapearDefeitos()

        return if (foiDesclassificado(grupoSoja, tabelaTipo)) TipoSoja.DESCLASSIFICADO
        else if (verificarSeDoTipo(tabelaTipo.tipo1)) TipoSoja.TIPO_1
        else if (verificarSeDoTipo(tabelaTipo.tipo2)) TipoSoja.TIPO_2
        else if (verificarSeDoTipo(tabelaTipo.padrao)) TipoSoja.PADRAO
        else TipoSoja.FORA_DE_TIPO
    }

    /**
     * Determina a classe dos grãos de soja com base em uma tabela de classes específica.
     *
     * @param tabelaClasse A tabela de classes usada para determinar a classe dos grãos.
     * @return A classe dos grãos de soja.
     * @throws IllegalArgumentException Se a tabela de classes não for do tipo TabelaClasseSoja.
     */
    fun determinarClasse(tabelaClasse: TabelaClasse): Classe {
        if (tabelaClasse !is TabelaClasseSoja) throw IllegalArgumentException("A tabela de classe utilizada não é referente a Soja.")

        if (calcularPorcentagemAmarelos() >= tabelaClasse.minimoGraosAmarelos) return ClasseSoja.AMARELA
        return ClasseSoja.MISTURADA
    }


    /**
     * Calcula a porcentagem de grãos amarelos em relação ao total de grãos.
     *
     * @return A porcentagem de grãos amarelos.
     */
    fun calcularPorcentagemAmarelos(): Double {
        return (graosAmarelosEmGramas / amostraClasseEmGramas)*100
    }


    /**
     * Verifica se os grãos de soja cumprem os limites de tolerâncias dos seus respectivos grupos.
     *
     * @return true se os grãos estiverem dentro do limite de tolerância deste tipo, caso contrário false.
     */
    private fun foiDesclassificado(
        grupoSoja: GrupoSoja,
        tabelaTipo: TabelaTipoSoja
    ): Boolean {
        val limiteForaDoTipo =
            if (grupoSoja == GrupoSoja.GRUPO_1)
                tabelaTipo.limiteForaDoTipo.limiteDefeitosGravesGrupo1
            else tabelaTipo.limiteForaDoTipo.limiteDefeitosGravesGrupo2

        if (defeitosSoja.calcularDefeitosGravesEmPorcentagem() > limiteForaDoTipo) return true
        return false
    }

    /**
     * Verifica se os grãos de soja estão dentro do limite de tolerância de determinado tipo.
     *
     * @return true se os grãos estiverem dentro do limite de tolerância deste tipo, caso contrário false.
     */
    private fun verificarSeDoTipo(tipo: TipoSojaData): Boolean {
        val estaAbaixoDoLimiteDeQueimados = defeitosSoja.queimadosEmPorcentagem <= tipo.limiteQueimados
        val estaAbaixoDoLimiteDeArdidosEQueimados = defeitosSoja.calcularArdidosQueimadosEmPorcentagem() <= tipo.limiteArdidosQueimados
        val estaAbaixoDoLimiteDeMofados = defeitosSoja.mofadosEmPorcentagem <= tipo.limiteMofados
        val estaAbaixoDoLimiteDeAvariados = defeitosSoja.calcularAvariadosEmPorcentagem() <= tipo.limiteAvariados
        val estaAbaixoDoLimiteDeEsverdeados = defeitosSoja.esverdeadosEmPorcentagem <= tipo.limiteEsverdeados
        val estaAbaixoDoLimiteDePartidosQuebradosAmassados = defeitosSoja.partidosQuebradosAmaçadosEmPorcentagem <= tipo.limitePartidosQuebradosAmassados
        val estaAbaixoDoLimiteDeImpurezas = impurezas.calcularPorcentagem() <= tipo.limiteImpurezas

        val conditions = listOf(estaAbaixoDoLimiteDeQueimados, estaAbaixoDoLimiteDeArdidosEQueimados, estaAbaixoDoLimiteDeMofados, estaAbaixoDoLimiteDeAvariados, estaAbaixoDoLimiteDeEsverdeados, estaAbaixoDoLimiteDePartidosQuebradosAmassados, estaAbaixoDoLimiteDeImpurezas)

        return conditions.all { it }
    }

    /**
     * Mapeia os defeitos dos grãos de soja para a estrutura DefeitosSoja.
     *
     * @return Uma instância de DefeitosSoja com as porcentagens dos defeitos mapeadas.
     */
    private fun mapearDefeitos(): DefeitosSoja {
        var defeitosSoja = DefeitosSoja();
        for (defeito in defeitos){
            when (defeito.tipo) {
                TiposDefeitosSoja.ARDIDOS -> defeitosSoja.ardidosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.QUEIMADOS -> defeitosSoja.queimadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.MOFADOS -> defeitosSoja.mofadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.FERMENTADOS -> defeitosSoja.fermentadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.GERMINADOS -> defeitosSoja.germinadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.IMATUROS -> defeitosSoja.imaturosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.CHOCHOS -> defeitosSoja.chochosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.ESVERDEADOS -> defeitosSoja.esverdeadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.QUEBRADOS -> defeitosSoja.partidosQuebradosAmaçadosEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.ATACADOS_PRAGAS -> defeitosSoja.atacadosPorPragaEmPorcentagem = defeito.calcularPorcentagem()
                TiposDefeitosSoja.DEMAIS_DANIFICADOS -> defeitosSoja.demaisDanificadosEmPorcentagem = defeito.calcularPorcentagem()
            }
        }
        return defeitosSoja
    }
}