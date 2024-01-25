package domain.graos.soja

import br.ufu.classisafra.data.classe.TabelaClasseSoja
import br.ufu.classisafra.data.tipo.TabelaTipoSoja
import br.ufu.classisafra.model.classificacao.classe.ClasseEnum
import br.ufu.classisafra.model.classificacao.classe.ClasseSojaEnum
import br.ufu.classisafra.model.classificacao.grupo.GrupoSojaEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoEnum
import br.ufu.classisafra.model.classificacao.tipo.TipoSojaEnum
import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosSojaEnum
import domain.parametros.cores.CoresSoja
import domain.parametros.defeitos.Defeito
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SojaTest {

    @Test
    fun `verifica se um grão do Grupo 1 foi desclassificado`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 7.0, 100.0, 0.0, 1.5)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 7.0, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_1)

        assertEquals(TipoSojaEnum.DESCLASSIFICADO, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 1 foi classifificado como fora do tipo`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 5.0, 100.0, 0.0, 1.5)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 5.0, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_1)

        assertEquals(TipoSojaEnum.FORA_DE_TIPO, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 1 foi classifificado como do tipo 2`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 1.4, 100.0, 0.0, 1.5)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 0.9, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_1)

        assertEquals(TipoSojaEnum.TIPO_2, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 1 foi classifificado como do tipo 1`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 0.4, 100.0, 0.0, 0.5)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 0.2, 100.0, 0.0, 0.3)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_1)

        assertEquals(TipoSojaEnum.TIPO_1, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 2 foi desclassificado`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 21.0, 100.0, 0.0, 6.0)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 21.0, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_2)

        assertEquals(TipoSojaEnum.DESCLASSIFICADO, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 2 foi classificado como fora do tipo`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 7.0, 100.0, 0.0, 6.0)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 2.0, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_2)

        assertEquals(TipoSojaEnum.FORA_DE_TIPO, tipo)
    }

    @Test
    fun `verifica se um grão do Grupo 2 foi classificado como padrão`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 5.0, 100.0, 0.0, 6.0)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 0.5, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 98.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaTipoSoja: TabelaTipoSoja = TabelaTipoSoja()

        val tipo: TipoEnum = soja.determinarTipo(tabelaTipoSoja, GrupoSojaEnum.GRUPO_2)

        assertEquals(TipoSojaEnum.PADRAO, tipo)
    }

    @Test
    fun `verifica se um grão é da classe amarela`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 5.0, 100.0, 0.0, 6.0)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 0.5, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 91.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaClasseSoja: TabelaClasseSoja = TabelaClasseSoja()

        val classe: ClasseEnum = soja.determinarClasse(tabelaClasseSoja);

        assertEquals(ClasseSojaEnum.AMARELA, classe)
    }

    @Test
    fun `verifica se um grão é da classe misturados`() {
        val umidade: Umidade = Umidade(12.0, 14.0)
        val impurezas: Impurezas = Impurezas(0.5, 100.0, 1.0)
        val mofados: Defeito = Defeito(DefeitosSojaEnum.MOFADOS, 5.0, 100.0, 0.0, 6.0)
        val queimados: Defeito = Defeito(DefeitosSojaEnum.QUEIMADOS, 0.5, 100.0, 0.0, 1.0)
        val defeitos: List<Defeito> = listOf(mofados, queimados)
        val coresSoja: CoresSoja = CoresSoja(100.0, 89.0, 2.0)
        val soja: Soja = Soja(100.0, 1000.0, umidade, impurezas, defeitos, coresSoja)
        val tabelaClasseSoja: TabelaClasseSoja = TabelaClasseSoja()

        val classe: ClasseEnum = soja.determinarClasse(tabelaClasseSoja);

        assertEquals(ClasseSojaEnum.MISTURADA, classe)
    }
}