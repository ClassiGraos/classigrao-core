package domain.parametros.defeitos

import br.ufu.classisafra.model.classificacao.tipos_defeitos.TiposDefeitosSoja
import domain.parametros.defeitos.Defeito
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DefeitoTest {

    @Test
    @DisplayName("Quando o Deságio for maior que 100 deve lançar exceção.")
    fun quandoDesagioAcimaDe100_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            120.0,
            1.0)
        }
    }

    @Test
    @DisplayName("Quando o Deságio for menor que 0 deve lançar exceção.")
    fun quandoDesagioAbaixoDe0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            -1.0,
            1.0)
        }
    }

    @Test
    @DisplayName("Quando o Limite Tolerado for maior que 100 deve lançar exceção.")
    fun quandoLimiteToleradoEmPorcentagemAcimaDe100_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            120.0)
        }
    }

    @Test
    @DisplayName("Quando o Limite Tolerado for menor que 0 deve lançar exceção.")
    fun quandoLimiteToleradoEmPorcentagemMenorQue0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            -1.0)
        }
    }

    @Test
    @DisplayName("Quando o Peso em Gramas for menor que 0 deve lançar exceção.")
    fun quandoPesoEmGramasMenorQue0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            -1.0,
            150.0,
            0.0,
            1.0)
        }
    }

    @Test
    @DisplayName("Quando a Amostra em Gramas for igual 0 deve lançar exceção.")
    fun quandoAmostraEmGramasIgual0_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            0.0,
            0.0,
            0.0,
            1.0)
        }
    }

    @Test
    @DisplayName("Quando a Amostra em Gramas for for menor que o Peso em Gramas deve lançar exceção.")
    fun quandoAmostraEmGramasMenorQuePesoEmGramas_ThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            180.0,
            150.0,
            0.0,
            1.0)
        }
    }

    @Test
    @DisplayName("Calcula a porcentagem correta.")
    fun calcularAPorcentagemTest() {
        val defeito = Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            1.0)
        val expected = 2.0 // (3.0 / 150.0) * 100
        val actual = defeito.calcularPorcentagem()
        assertEquals(expected, actual, 0.01)
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que o limite tolerado estaAbaixoDoTolerado() deve retornar verdadeiro.")
    fun estaAbaixoDoToleradoRetornTrue() {
        val defeito = Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            1.0,
            150.0,
            0.0,
            1.0)
        val expected = true
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Quando o limite tolerado for maior que o limite tolerado estaAbaixoDoTolerado() deve retornar falso.")
    fun estaAbaixoDoToleradoReturnFalse() {
        val defeito = Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            1.0)
        val expected = false
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    @DisplayName("Calcula o desconto correto.")
    fun calcularDescontEmKgTest() {
        val defeito = Defeito(
            TiposDefeitosSoja.QUEIMADOS,
            3.0,
            150.0,
            5.0,
            1.0)
        val pesoInicialEmKg = 1000.0
        val expected = 9.596 // (2.0 - 1.0) / (100.0 - 1.0) * (100.0 - 5.0 / 100.0) * 1000.0
        val actual = defeito.calcularDescontoEmKg(pesoInicialEmKg)
        assertEquals(expected, actual, 0.01)
    }

}