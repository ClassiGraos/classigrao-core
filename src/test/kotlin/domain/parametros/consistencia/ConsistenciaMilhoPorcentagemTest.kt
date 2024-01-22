package domain.parametros.consistencia

import br.ufu.classisafra.model.parametros.consistencia.ConsistenciaMilhoPorcentagem
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ConsistenciaMilhoPorcentagemTest {

    @Test
    fun `valores iniciais dentro do intervalo`() {
        val consistenciaMilho = ConsistenciaMilhoPorcentagem(
            duroEmPorcentagem = 40.0,
            semiduroEmPorcentagem = 30.0,
            dentadoEmPorcentagem = 20.0
        )

        assertEquals(40.0, consistenciaMilho.duroEmPorcentagem)
        assertEquals(30.0, consistenciaMilho.semiduroEmPorcentagem)
        assertEquals(20.0, consistenciaMilho.dentadoEmPorcentagem)
    }

    @Test
    fun `valores iniciais maiores que 100`() {
        assertThrows<IllegalArgumentException> {
            ConsistenciaMilhoPorcentagem(
                duroEmPorcentagem = 120.0,
                semiduroEmPorcentagem = 101.0,
                dentadoEmPorcentagem = 110.0
            )
        }
    }

    @Test
    fun `valores iniciais menores que 0`() {
        assertThrows<IllegalArgumentException> {
            ConsistenciaMilhoPorcentagem(
                duroEmPorcentagem = -10.0,
                semiduroEmPorcentagem = -5.0,
                dentadoEmPorcentagem = -1.0
            )
        }
    }
}