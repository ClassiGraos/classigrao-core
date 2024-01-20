package domain.graos.milho

import domain.tabelas.classe.interfaces.TabelaClasse
import br.ufu.classisafra.data.classe.TabelaClasseMilho
import br.ufu.classisafra.data.grupo.TabelaGrupoMilho
import domain.tabelas.tipo.interfaces.TabelaTipo
import br.ufu.classisafra.data.tipo.TabelaTipoMilho
import br.ufu.classisafra.data.tipo.data_model.TipoMilhoData
import br.ufu.classisafra.model.classificacao.classe.ClasseEnum
import br.ufu.classisafra.model.classificacao.classe.ClasseMilhoEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoMilhoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoMilhoEnum
import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosMilhoEnum
import br.ufu.classisafra.model.graos.Graos
import domain.parametros.defeitos.Defeito
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade
import br.ufu.classisafra.model.parametros.consistencia.ConsistenciaMilho
import br.ufu.classisafra.model.parametros.cores.CoresMilho
import br.ufu.classisafra.model.parametros.defeitos.TabelaDefeitosMilho

/**
 * Classe que representa grãos de milho e suas características.
 *
 * @property amostraEmGramas O peso da amostra de grãos de milho em gramas.
 * @property pesoInicialEmKg O peso inicial do lote de grãos de milho em quilogramas (kg).
 * @property umidade O objeto que representa a umidade dos grãos de milho.
 * @property impurezas O objeto que representa as impurezas dos grãos de milho.
 * @property defeitos A lista de defeitos presentes na amostra de grãos de milho.
 * @property amostraGrupoEmGramas O peso da amostra do grupo dos grãos de milho em gramas.
 * @property graosDurosEmGramas O peso dos grãos de milho duros em gramas.
 * @property graosSemidurosEmGramas O peso dos grãos de milho semiduros em gramas.
 * @property graosDentadosEmGramas O peso dos grãos de milho dentados em gramas.
 * @property amostraClasseEmGramas O peso da amostra da classe dos grãos de milho em gramas.
 * @property graosAmarelosEmGramas O peso dos grãos de milho amarelos em gramas.
 * @property graosBrancosEmGramas O peso dos grãos de milho brancos em gramas.
 * @property graosColoridosEmGramas O peso dos grãos de milho coloridos em gramas.
 * @author Victor Hugo Ferreira Silva
 **/
class Milho(
    amostraEmGramas: Double,
    pesoInicialEmKg: Double,
    umidade: Umidade,
    impurezas: Impurezas,
    defeitos: List<Defeito>,
    var amostraGrupoEmGramas: Double,
    var graosDurosEmGramas: Double,
    var graosSemidurosEmGramas: Double,
    var graosDentadosEmGramas: Double,
    var amostraClasseEmGramas: Double,
    var graosAmarelosEmGramas: Double,
    var graosBrancosEmGramas: Double,
    var graosColoridosEmGramas: Double
) : Graos(
    amostraEmGramas = amostraEmGramas,
    pesoInicialEmKg = pesoInicialEmKg,
    umidade = umidade,
    impurezas = impurezas,
    defeitos = defeitos
) {
    /**
     * Estrutura DefeitosMilho, a qual os defeitos do Milho serão mapeados.
     */
    lateinit var defeitosMilho: TabelaDefeitosMilho

    /**
     * Determina o tipo dos grãos de milho com base na tabela de tipos fornecida.
     *
     * @param tabelaTipo A tabela de tipos usada para determinar o tipo dos grãos de milho.
     * @return O tipo dos grãos de milho.
     * @throws IllegalArgumentException Se a tabela de tipos fornecida não for para milho.
     */
    fun determinarTipo(tabelaTipo: TabelaTipo): TipoEnum {
        if (tabelaTipo !is TabelaTipoMilho) throw IllegalArgumentException("A tabela de tipo utilizada não é referente a Milho.")

        defeitosMilho = mapearDefeitos()

        return if (verificarSeDoTipo(tabelaTipo.tipo1)) TipoMilhoEnum.TIPO_1
        else if (verificarSeDoTipo(tabelaTipo.tipo2)) TipoMilhoEnum.TIPO_2
        else if (verificarSeDoTipo(tabelaTipo.tipo3)) TipoMilhoEnum.TIPO_3
        else if (verificarSeDoTipo(tabelaTipo.foraDeTipo)) TipoMilhoEnum.FORA_DE_TIPO
        else TipoMilhoEnum.DESCLASSIFICADO
    }

    /**
     * Determina a classe dos grãos de milho com base na tabela de classes fornecida.
     *
     * @param tabelaClasse A tabela de classes usada para determinar a classe dos grãos de milho.
     * @return A classe dos grãos de milho.
     * @throws IllegalArgumentException Se a tabela de classes fornecida não for para milho.
     */
    fun determinarClasse(tabelaClasse: TabelaClasse): ClasseEnum {
        if (tabelaClasse !is TabelaClasseMilho) throw IllegalArgumentException("A tabela de classe utilizada não é referente a Milho.")

        val coresMilho = calcularPorcentagensCores()

        if (coresMilho.amarelosEmPorcentagem >= tabelaClasse.minimoGraosAmarelos) return ClasseMilhoEnum.AMARELA
        else if (coresMilho.brancosEmPorcentagem >= tabelaClasse.minimoGraosBrancos) return ClasseMilhoEnum.BRANCA
        else if (coresMilho.coloridosEmPorcentagem >= tabelaClasse.minimoGraosOutrasCores) return ClasseMilhoEnum.COR
        return ClasseMilhoEnum.MISTURADA
    }

    /**
     * Determina o grupo dos grãos de milho com base na tabela de grupo fornecida.
     *
     * @param tabelaGrupo A tabela de grupo usada para determinar o grupo dos grãos de milho.
     * @return O grupo dos grãos de milho.
     */
    fun determinarGrupo(tabelaGrupo: TabelaGrupoMilho): GrupoEnum {
        val consistenciaMilho = calcularPorcentagensConsistencia()

        if (consistenciaMilho.duroEmPorcentagem > tabelaGrupo.minimoGraosDuros) return GrupoMilhoEnum.DURO
        else if (consistenciaMilho.semiduroEmPorcentagem > tabelaGrupo.minimoGraosSemiduros) return GrupoMilhoEnum.SEMIDURO
        else if (consistenciaMilho.dentadoEmPorcentagem > tabelaGrupo.minimoGraosDentados) return GrupoMilhoEnum.DENTADO
        return GrupoMilhoEnum.MISTURADO
    }

    /**
     * Calcula as porcentagens de consistência dos grãos de milho.
     *
     * @return Um objeto [ConsistenciaMilho] contendo as porcentagens de grãos de milho duros, semiduros e dentados.
     */
    fun calcularPorcentagensConsistencia(): ConsistenciaMilho {
        var consistenciaMilho = ConsistenciaMilho()
        consistenciaMilho.duroEmPorcentagem = (graosDurosEmGramas / amostraGrupoEmGramas)*100
        consistenciaMilho.semiduroEmPorcentagem = (graosSemidurosEmGramas / amostraGrupoEmGramas)*100
        consistenciaMilho.dentadoEmPorcentagem = (graosDentadosEmGramas / amostraGrupoEmGramas)*100
        return consistenciaMilho
    }

    /**
     * Calcula as porcentagens de cores dos grãos de milho.
     *
     * @return Um objeto [CoresMilho] contendo as porcentagens de grãos de milho amarelos, brancos e coloridos.
     */
    fun calcularPorcentagensCores(): CoresMilho {
        var coresMilho = CoresMilho()
        coresMilho.amarelosEmPorcentagem = (graosAmarelosEmGramas / amostraClasseEmGramas)*100
        coresMilho.brancosEmPorcentagem = (graosBrancosEmGramas / amostraClasseEmGramas)*100
        coresMilho.coloridosEmPorcentagem = (graosColoridosEmGramas / amostraClasseEmGramas)*100
        return coresMilho
    }

    /**
     * Verifica se os grãos de milho atendem aos critérios do tipo especificado.
     *
     * @param tipo O tipo de milho a ser verificado.
     * @return `true` se os grãos de milho atenderem aos critérios do tipo, caso contrário, `false`.
     */
    private fun verificarSeDoTipo(tipo: TipoMilhoData): Boolean {
        val estaAbaixoDoLimiteDeArdidos = defeitosMilho.ardidosEmPorcentagem <= tipo.limiteArdidosQueimados
        val estaAbaixoDoLimiteDeAvariados = defeitosMilho.calcularAvariadosEmPorcentagem() <= tipo.limiteAvariados
        val estaAbaixoDoLimiteDeQuebrados = defeitosMilho.quebradosEmPorcentagem <= tipo.limiteQuebrados
        val estaAbaixoDoLimiteDeImpurezas = impurezas.calcularPorcentagem() <= tipo.limiteImpurezas
        val estaAbaixoDoLimiteDeCarunchados = defeitosMilho.carunchadosEmPorcentagem <= tipo.limiteCarunchados

        val conditions = listOf(estaAbaixoDoLimiteDeArdidos, estaAbaixoDoLimiteDeAvariados, estaAbaixoDoLimiteDeQuebrados, estaAbaixoDoLimiteDeImpurezas, estaAbaixoDoLimiteDeCarunchados)

        return conditions.all {it}
    }

    /**
     * Mapeia os defeitos presentes na amostra de grãos de milho para a classe [TabelaDefeitosMilho].
     *
     * @return Um objeto [TabelaDefeitosMilho] contendo as porcentagens de defeitos de milho.
     */
    private fun mapearDefeitos(): TabelaDefeitosMilho {
        var defeitosMilho = TabelaDefeitosMilho();
        for (defeito in defeitos) {
            when (defeito.tipo) {
                DefeitosMilhoEnum.ARDIDOS -> defeitosMilho.ardidosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.MOFADOS -> defeitosMilho.mofadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.FERMENTADOS -> defeitosMilho.fermentadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.GERMINADOS -> defeitosMilho.germinadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.CHOCHOS_IMATUROS -> defeitosMilho.chochosImaturosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.GESSADOS -> defeitosMilho.gessadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.CARUNCHADOS -> defeitosMilho.carunchadosEmPorcentagem = defeito.calcularPorcentagem()
                DefeitosMilhoEnum.QUEBRADOS -> defeitosMilho.quebradosEmPorcentagem = defeito.calcularPorcentagem()
            }
        }
        return defeitosMilho
    }

}