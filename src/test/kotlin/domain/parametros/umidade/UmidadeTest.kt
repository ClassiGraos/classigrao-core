package domain.parametros.umidade
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class UmidadeTest {

    @Test
    @DisplayName("Quando a umidade for maior que 100 deve lançar exceção.")
    fun quandoUmidadeEmPorcentagemMaiorQue100_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Umidade(120.0, 14.0) }
    }

    @Test
    @DisplayName("Quando a umidade for menor que 0 deve lançar exceção.")
    fun quandoUmidadeEmPorcentagemMenorQue0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Umidade(-1.0, 14.0) }
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que 100 deve lançar exceção.")
    fun quandoLimiteToleradoEmPorcentagemMaiorQue100_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Umidade(8.0, 120.0) }
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que 100 deve lançar exceção.")
    fun quandoLimiteToleradoEmPorcentagemMenorQue0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Umidade(8.0, -1.0) }
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que o limite tolerado estaAbaixoDoTolerado() deve retornar verdadeiro.")
    fun estaAbaixoDoToleradoTestReturnTrue(){
        val umidade = Umidade(8.0, 14.0)
        val expected = true
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que o limite tolerado estaAbaixoDoTolerado() deve retornar falso.")
    fun estaAbaixoDoToleradoTestReturnFalse(){
        val umidade = Umidade(18.0, 14.0)
        val expected = false
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }
}