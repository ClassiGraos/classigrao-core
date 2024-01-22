package domain.graos.soja

import domain.tabelas.classe.interfaces.TabelaClasse
import br.ufu.classisafra.data.classe.TabelaClasseSoja
import domain.tabelas.tipo.interfaces.TabelaTipo
import br.ufu.classisafra.data.tipo.TabelaTipoSoja
import br.ufu.classisafra.data.tipo.data_model.TipoSojaData
import br.ufu.classisafra.model.classificacao.classe.ClasseEnum
import br.ufu.classisafra.model.classificacao.classe.ClasseSojaEnum
import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosSojaEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoSojaEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoSojaEnum
import br.ufu.classisafra.model.graos.Graos
import domain.parametros.defeitos.Defeito
import br.ufu.classisafra.model.parametros.defeitos.TabelaDefeitosSoja
import domain.parametros.cores.CoresSoja
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade

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
    coresSoja: CoresSoja
) : Graos(
    amostraEmGramas = amostraEmGramas,
    pesoInicialEmKg = pesoInicialEmKg,
    umidade = umidade,
    impurezas = impurezas,
    defeitos = defeitos
) {

    /**
     * Estrutura CoresSoja com o peso de diferentes Cores da amostra.
     */
    var coresSoja = coresSoja

    /**
     * Estrutura DefeitosSoja, a qual os defeitos da Soja serão mapeados.
     */
    lateinit var defeitosSoja : TabelaDefeitosSoja

    /**
     * Determina o tipo dos grãos de soja com base em uma tabela de tipos específica.
     *
     * @param tabelaTipo A tabela de tipos usada para determinar o tipo dos grãos.
     * @return O tipo dos grãos de soja.
     * @throws IllegalArgumentException Se a tabela de tipos não for do tipo TabelaTipoSoja.
     */
    fun determinarTipo(tabelaTipo: TabelaTipo, grupoSoja: GrupoSojaEnum): TipoEnum {
        if (tabelaTipo !is TabelaTipoSoja) throw IllegalArgumentException("A tabela de tipo utilizada não é referente a Soja.")

        defeitosSoja = mapearDefeitos()

        return if (foiDesclassificado(grupoSoja, tabelaTipo)) TipoSojaEnum.DESCLASSIFICADO
        else if (verificarSeDoTipo(tabelaTipo.tipo1)) TipoSojaEnum.TIPO_1
        else if (verificarSeDoTipo(tabelaTipo.tipo2)) TipoSojaEnum.TIPO_2
        else if (verificarSeDoTipo(tabelaTipo.padrao)) TipoSojaEnum.PADRAO
        else TipoSojaEnum.FORA_DE_TIPO
    }

    /**
     * Determina a classe dos grãos de soja com base em uma tabela de classes específica.
     *
     * @param tabelaClasse A tabela de classes usada para determinar a classe dos grãos.
     * @return A classe dos grãos de soja.
     * @throws IllegalArgumentException Se a tabela de classes não for do tipo TabelaClasseSoja.
     */
    fun determinarClasse(tabelaClasse: TabelaClasse): ClasseEnum {
        if (tabelaClasse !is TabelaClasseSoja) throw IllegalArgumentException("A tabela de classe utilizada não é referente a Soja.")

        if (calcularPorcentagemAmarelos() >= tabelaClasse.minimoGraosAmarelos) return ClasseSojaEnum.AMARELA
        return ClasseSojaEnum.MISTURADA
    }


    /**
     * Calcula a porcentagem de grãos amarelos em relação ao total de grãos.
     *
     * @return A porcentagem de grãos amarelos.
     */
    fun calcularPorcentagemAmarelos(): Double {
        return (coresSoja.graosAmarelosEmGramas / coresSoja.amostraClasseEmGramas)*100
    }


    /**
     * Verifica se os grãos de soja cumprem os limites de tolerâncias dos seus respectivos grupos.
     *
     * @return true se os grãos estiverem dentro do limite de tolerância deste tipo, caso contrário false.
     */
    private fun foiDesclassificado(
        grupoSoja: GrupoSojaEnum,
        tabelaTipo: TabelaTipoSoja
    ): Boolean {
        val limiteForaDoTipo =
            if (grupoSoja == GrupoSojaEnum.GRUPO_1)
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
    private fun mapearDefeitos(): TabelaDefeitosSoja {
        var defeitosSoja = TabelaDefeitosSoja();
        for (defeito in defeitos){
            when (defeito.tipo) {
                DefeitosSojaEnum.ARDIDOS -> defeitosSoja.ardidosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.QUEIMADOS -> defeitosSoja.queimadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.MOFADOS -> defeitosSoja.mofadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.FERMENTADOS -> defeitosSoja.fermentadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.GERMINADOS -> defeitosSoja.germinadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.IMATUROS -> defeitosSoja.imaturosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.CHOCHOS -> defeitosSoja.chochosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.ESVERDEADOS -> defeitosSoja.esverdeadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.QUEBRADOS -> defeitosSoja.partidosQuebradosAmaçadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.ATACADOS_PRAGAS -> defeitosSoja.atacadosPorPragaEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosSojaEnum.DEMAIS_DANIFICADOS -> defeitosSoja.demaisDanificadosEmPorcentagem = defeito.calcularPorcentagem()
            }
        }
        return defeitosSoja
    }
}