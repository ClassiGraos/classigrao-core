package domain.graos.milho

import br.ufu.classisafra.data.classe.TabelaClasseMilho
import br.ufu.classisafra.data.grupo.TabelaGrupoMilho
import br.ufu.classisafra.data.tipo.TabelaTipoMilho
import br.ufu.classisafra.model.classificacao.classe.ClasseEnum
import br.ufu.classisafra.model.classificacao.classe.ClasseMilhoEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoMilhoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoMilhoEnum
import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosMilhoEnum
import domain.parametros.consistencia.ConsistenciaMilho
import domain.parametros.cores.CoresMilho
import domain.parametros.defeitos.Defeito
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MilhoTest {

    @Test
    fun `verifica se um grão foi desclassificado`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 100.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 6.0, 100.0, 0.0, 5.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 6.0, 100.0, 0.0, 100.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 86.0, 7.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.DESCLASSIFICADO, tipo)
        assertEquals(GrupoMilhoEnum.DURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como fora de tipo`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 100.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 4.0, 100.0, 0.0, 5.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 6.0, 100.0, 0.0, 100.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 86.0, 7.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.FORA_DE_TIPO, tipo)
        assertEquals(GrupoMilhoEnum.DURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

   @Test
    fun `verifica se um grão foi classificado como do tipo 3`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 2.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 2.5, 100.0, 0.0, 3.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 4.5, 100.0, 0.0, 5.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 86.0, 7.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_3, tipo)
        assertEquals(GrupoMilhoEnum.DURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como do tipo 2`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.5)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 1.5, 100.0, 0.0, 2.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 3.5, 100.0, 0.0, 4.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 86.0, 7.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_2, tipo)
        assertEquals(GrupoMilhoEnum.DURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como do tipo 1`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 86.0, 7.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.DURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como semiduro`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 7.0, 86.0, 7.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.SEMIDURO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como dentado`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 7.0, 7.0, 86.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.DENTADO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como do grupo misturado`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 33.0, 34.0, 33.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 96.0, 2.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.MISTURADO, grupo)
        assertEquals(ClasseMilhoEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como da classe Branca`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 33.0, 34.0, 33.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 2.0, 96.0, 2.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.MISTURADO, grupo)
        assertEquals(ClasseMilhoEnum.BRANCA, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como da classe Cores`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 33.0, 34.0, 33.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 2.0, 2.0, 96.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.MISTURADO, grupo)
        assertEquals(ClasseMilhoEnum.COR, classe)
    }

    @Test
    fun `verifica se um grão foi classificado como da classe Misturada`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosMilhoEnum.ARDIDOS, 0.5, 100.0, 0.0, 1.0)
        val queimados: Defeito = Defeito(DefeitosMilhoEnum.QUEBRADOS, 2.5, 100.0, 0.0, 3.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val consistenciaMilho: ConsistenciaMilho = ConsistenciaMilho(100.0, 33.0, 34.0, 33.0)
        val coresMilho: CoresMilho = CoresMilho(100.0, 50.0, 50.0, 0.0)
        val tabelaTipoMilho: TabelaTipoMilho = TabelaTipoMilho()
        val tabelaGrupoMilho: TabelaGrupoMilho = TabelaGrupoMilho()
        val tabelaClasseMilho: TabelaClasseMilho = TabelaClasseMilho()

        val milho: Milho = Milho(100.0, 1000.0, umidade, impurezas, defeitos, consistenciaMilho, coresMilho)

        val tipo: TipoEnum = milho.determinarTipo(tabelaTipoMilho)
        val grupo: GrupoEnum = milho.determinarGrupo(tabelaGrupoMilho)
        val classe: ClasseEnum = milho.determinarClasse(tabelaClasseMilho)

        assertEquals(TipoMilhoEnum.TIPO_1, tipo)
        assertEquals(GrupoMilhoEnum.MISTURADO, grupo)
        assertEquals(ClasseMilhoEnum.MISTURADA, classe)
    }
}