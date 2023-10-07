package model.parametros
import br.ufu.classisafra.model.parametros.Umidade
import org.junit.jupiter.api.*
import kotlin.test.assertEquals

class UmidadeTest {

    @Test
    fun givenUmidade_whenUmidadeEmPorcentagemAbove100_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> {Umidade(120.0, 14.0)}
    }

    @Test
    fun givenUmidade_whenUmidadeEmPorcentagemBelow0_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> {Umidade(-1.0, 14.0)}
    }

    @Test
    fun givenUmidade_whenLimiteToleradoEmPorcentagemAbove100_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> {Umidade(8.0, 120.0)}
    }

    @Test
    fun givenUmidade_whenLimiteToleradoEmPorcentagemBelow0_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> {Umidade(8.0, -1.0)}
    }

    @Test
    fun givenUmidade_whenUmidadeBelowLimiteTolerado_thenReturnTrue(){
        val umidade = Umidade(8.0, 14.0)
        val expected = true
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun givenUmidade_whenUmidadeAboveLimiteTolerado_thenReturnFalse(){
        val umidade = Umidade(18.0, 14.0)
        val expected = false
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }
}