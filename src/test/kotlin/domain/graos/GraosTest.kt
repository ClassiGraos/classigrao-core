package domain.graos

import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosSojaEnum
import br.ufu.classisafra.model.graos.Graos
import domain.parametros.defeitos.Defeito
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals


class GraosTest {

    @Test
    fun `definir amostraEmGramas com valor válido`() {
        val graos = object : Graos(
            amostraEmGramas = 100.0,
            pesoInicialEmKg = 50.0,
            umidade = Umidade(11.0, 14.0),
            impurezas = Impurezas(12.0, 150.0, 5.0),
            defeitos = emptyList()
        ) {}

        assertEquals(100.0, graos.amostraEmGramas)
    }

    @Test
    fun `definir amostraEmGramas com valor inválido`() {
        assertThrows<IllegalArgumentException> {
            object : Graos(
                amostraEmGramas = -10.0,
                pesoInicialEmKg = 50.0,
                umidade = Umidade(11.0, 14.0),
                impurezas = Impurezas(12.0, 150.0, 5.0),
                defeitos = emptyList()
            ) {}
        }
    }

    @Test
    fun `definir pesoInicialEmKg com valor válido`() {
        val graos = object : Graos(
            amostraEmGramas = 100.0,
            pesoInicialEmKg = 50.0,
            umidade = Umidade(11.0, 14.0),
            impurezas = Impurezas(12.0, 150.0, 5.0),
            defeitos = emptyList()
        ) {}

        assertEquals(50.0, graos.pesoInicialEmKg)
    }

    @Test
    fun `definir pesoInicialEmKg com valor inválido`() {
        assertThrows<IllegalArgumentException> {
            object : Graos(
                amostraEmGramas = 100.0,
                pesoInicialEmKg = 0.0,
                umidade = Umidade(11.0, 14.0),
                impurezas = Impurezas(12.0, 150.0, 5.0),
                defeitos = emptyList()
            ) {}
        }
    }

    @Test
    fun `calcular desconto válido`() {
        val pesoLoteInicial: Double = 1000.0;
        val impurezas: Impurezas = Impurezas(2.0, 100.0, 1.0);
        val umidade: Umidade = Umidade(18.0, 14.0);

        val esverdeados = Defeito(
            DefeitosSojaEnum.ESVERDEADOS,
            4.0,
            100.0,
            10.0,
            2.0)
        val queimados = Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            1.0,
            100.0,
            10.0,
            0.3)
        val mofados = Defeito(
            DefeitosSojaEnum.MOFADOS,
            1.0,
            100.0,
            10.0,
            0.5)

        val defeitos: List<Defeito> = listOf(esverdeados, queimados, mofados)

        val expectedDescontoImpurezas: Double = (1000.0)*(2.0 - 1.0)/(100.0-1.0)
        val expectedDescontoUmidade: Double = (1000.0-expectedDescontoImpurezas)*(18.0 - 14.0)/(100.0-14.0)
        val expectedDescontoEsverdeados =  (1000.0)*((4.0-2.0)/(100.0-2.0)*((100.0-10.0)/100.0))
        val expectedDescontoQueimados =  (1000.0)*((1.0-0.3)/(100.0-0.3)*((100.0-10.0)/100.0))
        val expectedDescontoMofados =  (1000.0)*((1.0-0.5)/(100.0-0.5)*((100.0-10.0)/100.0))

        val expectedDescontoTotal = expectedDescontoImpurezas + expectedDescontoUmidade + expectedDescontoEsverdeados +
                expectedDescontoQueimados + expectedDescontoMofados

        val graos: Graos = Graos(
            amostraEmGramas = 100.0,
            pesoInicialEmKg = 1000.0,
            umidade = umidade,
            impurezas = impurezas,
            defeitos = defeitos
        )

        val actualDescontoTotal = graos.calcularDescontoEmKg()

        assertEquals(expectedDescontoTotal, actualDescontoTotal, 0.01)
    }

}