package domain.parametros.defeitos

import br.ufu.classisafra.model.parametros.defeitos.TabelaDefeitosMilho
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class TabelaDefeitosMilhoTest {

    @Test
    @DisplayName("Calcular Avariados em Porcentagem")
    fun testCalcularAvariadosEmPorcentagem() {
        val tabela = TabelaDefeitosMilho(
            ardidosEmPorcentagem = 10.0,
            mofadosEmPorcentagem = 5.0,
            fermentadosEmPorcentagem = 3.0,
            germinadosEmPorcentagem = 2.0,
            chochosImaturosEmPorcentagem = 4.0,
            gessadosEmPorcentagem = 1.0,
            carunchadosEmPorcentagem = 2.0,
            quebradosEmPorcentagem = 5.0
        )

        val actual = tabela.calcularAvariadosEmPorcentagem()
        val expected = 10.0 + 5.0 + 3.0 + 2.0 + 4.0 + 1.0

        assertEquals(expected, actual, "A porcentagem total de grãos avariados não está correta.")
    }

    @Test
    @DisplayName("Valores Iniciais Dentro do Intervalo")
    fun testValoresIniciaisDentroDoIntervalo() {
        val tabela = TabelaDefeitosMilho(
            ardidosEmPorcentagem = 10.0,
            mofadosEmPorcentagem = 20.0,
            fermentadosEmPorcentagem = 5.0,
            germinadosEmPorcentagem = 8.0,
            chochosImaturosEmPorcentagem = 3.0,
            gessadosEmPorcentagem = 2.0,
            carunchadosEmPorcentagem = 1.0,
            quebradosEmPorcentagem = 6.0
        )

        assertEquals(10.0, tabela.ardidosEmPorcentagem)
        assertEquals(20.0, tabela.mofadosEmPorcentagem)
        assertEquals(5.0, tabela.fermentadosEmPorcentagem)
        assertEquals(8.0, tabela.germinadosEmPorcentagem)
        assertEquals(3.0, tabela.chochosImaturosEmPorcentagem)
        assertEquals(2.0, tabela.gessadosEmPorcentagem)
        assertEquals(1.0, tabela.carunchadosEmPorcentagem)
        assertEquals(6.0, tabela.quebradosEmPorcentagem)
    }

    @Test
    @DisplayName("Valores Iniciais Maior que 100")
    fun testValoresInicialMaiorQue100() {
        assertThrows<IllegalArgumentException> {
            TabelaDefeitosMilho(
                ardidosEmPorcentagem = 1.0,
                mofadosEmPorcentagem = 101.0,
                fermentadosEmPorcentagem = 5.0,
                germinadosEmPorcentagem = 8.0,
                chochosImaturosEmPorcentagem = 3.0,
                gessadosEmPorcentagem = 2.0,
                carunchadosEmPorcentagem = 1.0,
                quebradosEmPorcentagem = 6.0
            )
        }
    }

    @Test
    @DisplayName("Valores Iniciais Menor que 0")
    fun testValoresInicialMenorQue0() {
        assertThrows<IllegalArgumentException> {
            TabelaDefeitosMilho(
                ardidosEmPorcentagem = -1.0,
                mofadosEmPorcentagem = 1.0,
                fermentadosEmPorcentagem = 5.0,
                germinadosEmPorcentagem = 8.0,
                chochosImaturosEmPorcentagem = 3.0,
                gessadosEmPorcentagem = 2.0,
                carunchadosEmPorcentagem = 1.0,
                quebradosEmPorcentagem = 6.0
            )
        }
    }
}