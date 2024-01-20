package domain.parametros.defeitos

import br.ufu.classisafra.model.parametros.defeitos.TabelaDefeitosSoja
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TabelaDefeitosSojaTest {

    @Test
    @DisplayName("Calcular Avariados em Porcentagem")
    fun testCalcularAvariadosEmPorcentagem() {
        val tabela = TabelaDefeitosSoja(
            ardidosEmPorcentagem = 10.0,
            queimadosEmPorcentagem = 2.0,
            mofadosEmPorcentagem = 5.0,
            fermentadosEmPorcentagem = 3.0,
            germinadosEmPorcentagem = 2.0,
            imaturosEmPorcentagem = 4.0,
            chochosEmPorcentagem = 1.0,
            atacadosPorPragaEmPorcentagem = 6.0,
            demaisDanificadosEmPorcentagem = 2.0,
            esverdeadosEmPorcentagem = 2.0,
            partidosQuebradosAmaçadosEmPorcentagem = 5.0
        )

        val actual = tabela.calcularAvariadosEmPorcentagem()
        val expected = 10.0 + 2.0 + 5.0 + 3.0 + 2.0 + 4.0 + 1.0 + 6.0/4.0 + 2.0;

        assertEquals(expected, actual, "A porcentagem de grãos avariados não está correta.")
    }

    @Test
    @DisplayName("Calcular Ardidos e Queimados em Porcentagem")
    fun testCalcularArdidosQueimadosEmPorcentagem() {
        val tabela = TabelaDefeitosSoja(
            ardidosEmPorcentagem = 10.0,
            queimadosEmPorcentagem = 5.0,
            mofadosEmPorcentagem = 5.0,
            fermentadosEmPorcentagem = 3.0,
            germinadosEmPorcentagem = 2.0,
            imaturosEmPorcentagem = 4.0,
            chochosEmPorcentagem = 1.0,
            atacadosPorPragaEmPorcentagem = 6.0,
            demaisDanificadosEmPorcentagem = 2.0,
            esverdeadosEmPorcentagem = 2.0,
            partidosQuebradosAmaçadosEmPorcentagem = 5.0
        )

        val resultado = tabela.calcularArdidosQueimadosEmPorcentagem()

        assertEquals(15.0, resultado, "A porcentagem de grãos ardidos e queimados não está correta.")
    }

    @Test
    @DisplayName("Calcular Danificados em Porcentagem")
    fun testCalcularDanificadosEmPorcentagem() {
        val tabela = TabelaDefeitosSoja(
            ardidosEmPorcentagem = 10.0,
            queimadosEmPorcentagem = 5.0,
            mofadosEmPorcentagem = 5.0,
            fermentadosEmPorcentagem = 3.0,
            germinadosEmPorcentagem = 2.0,
            imaturosEmPorcentagem = 4.0,
            chochosEmPorcentagem = 1.0,
            atacadosPorPragaEmPorcentagem = 8.0,
            demaisDanificadosEmPorcentagem = 4.0,
            esverdeadosEmPorcentagem = 2.0,
            partidosQuebradosAmaçadosEmPorcentagem = 5.0
        )

        val resultado = tabela.calcularDanificadosEmPorcentagem()

        assertEquals(8.0/4.0 + 4.0, resultado, "A porcentagem de grãos danificados não está correta.")
    }

    @Test
    @DisplayName("Calcular Defeitos Graves em Porcentagem")
    fun testCalcularDefeitosGravesEmPorcentagem() {
        val tabela = TabelaDefeitosSoja(
            ardidosEmPorcentagem = 10.0,
            queimadosEmPorcentagem = 5.0,
            mofadosEmPorcentagem = 3.0,
            fermentadosEmPorcentagem = 3.0,
            germinadosEmPorcentagem = 2.0,
            imaturosEmPorcentagem = 4.0,
            chochosEmPorcentagem = 1.0,
            atacadosPorPragaEmPorcentagem = 8.0,
            demaisDanificadosEmPorcentagem = 4.0,
            esverdeadosEmPorcentagem = 2.0,
            partidosQuebradosAmaçadosEmPorcentagem = 5.0
        )

        val resultado = tabela.calcularDefeitosGravesEmPorcentagem()

        assertEquals(18.0, resultado, "A porcentagem de grãos com defeitos graves não está correta.")
    }

    @Test
    @DisplayName("Valores Iniciais Dentro do Intervalo")
    fun testValoresIniciaisDentroDoIntervalo() {
        val tabela = TabelaDefeitosSoja(
            ardidosEmPorcentagem = 10.0,
            queimadosEmPorcentagem = 20.0,
            mofadosEmPorcentagem = 5.0,
            fermentadosEmPorcentagem = 8.0,
            germinadosEmPorcentagem = 3.0,
            imaturosEmPorcentagem = 2.0,
            chochosEmPorcentagem = 1.0,
            atacadosPorPragaEmPorcentagem = 6.0,
            demaisDanificadosEmPorcentagem = 2.0,
            esverdeadosEmPorcentagem = 2.0,
            partidosQuebradosAmaçadosEmPorcentagem = 5.0
        )

        assertEquals(10.0, tabela.ardidosEmPorcentagem)
        assertEquals(20.0, tabela.queimadosEmPorcentagem)
        assertEquals(5.0, tabela.mofadosEmPorcentagem)
        assertEquals(8.0, tabela.fermentadosEmPorcentagem)
        assertEquals(3.0, tabela.germinadosEmPorcentagem)
        assertEquals(2.0, tabela.imaturosEmPorcentagem)
        assertEquals(1.0, tabela.chochosEmPorcentagem)
        assertEquals(6.0, tabela.atacadosPorPragaEmPorcentagem)
        assertEquals(2.0, tabela.demaisDanificadosEmPorcentagem)
        assertEquals(2.0, tabela.esverdeadosEmPorcentagem)
        assertEquals(5.0, tabela.partidosQuebradosAmaçadosEmPorcentagem)
    }

    @Test
    @DisplayName("Valores Iniciais Maior que 100")
    fun testValoresInicialMaiorQue100() {
        assertThrows<IllegalArgumentException> {
            TabelaDefeitosSoja(
                ardidosEmPorcentagem = 1.0,
                queimadosEmPorcentagem = 101.0,
                mofadosEmPorcentagem = 5.0,
                fermentadosEmPorcentagem = 8.0,
                germinadosEmPorcentagem = 3.0,
                imaturosEmPorcentagem = 2.0,
                chochosEmPorcentagem = 1.0,
                atacadosPorPragaEmPorcentagem = 6.0,
                demaisDanificadosEmPorcentagem = 2.0,
                esverdeadosEmPorcentagem = 2.0,
                partidosQuebradosAmaçadosEmPorcentagem = 5.0
            )
        }
    }

    @Test
    @DisplayName("Valores Iniciais Menor que 0")
    fun testValoresInicialMenorQue0() {
        assertThrows<IllegalArgumentException> {
            TabelaDefeitosSoja(
                ardidosEmPorcentagem = -1.0,
                queimadosEmPorcentagem = 1.0,
                mofadosEmPorcentagem = 5.0,
                fermentadosEmPorcentagem = 8.0,
                germinadosEmPorcentagem = 3.0,
                imaturosEmPorcentagem = 2.0,
                chochosEmPorcentagem = 1.0,
                atacadosPorPragaEmPorcentagem = 6.0,
                demaisDanificadosEmPorcentagem = 2.0,
                esverdeadosEmPorcentagem = 2.0,
                partidosQuebradosAmaçadosEmPorcentagem = 5.0
            )
        }
    }

}