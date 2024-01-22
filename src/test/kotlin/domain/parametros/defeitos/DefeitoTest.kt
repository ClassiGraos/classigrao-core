package domain.parametros.defeitos

import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosSojaEnum
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DefeitoTest {

    @Test
    fun `quando o deságio for maior que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            120.0,
            1.0)
        }
    }

    @Test
    fun `quando o deságio for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            -1.0,
            1.0)
        }
    }

    @Test
    fun `quando o limite tolerado for maior que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            120.0)
        }
    }

    @Test
    fun `quando o limite tolerado for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            -1.0)
        }
    }

    @Test
    fun `quando o peso em gramas for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            -1.0,
            150.0,
            0.0,
            1.0)
        }
    }

    @Test
    fun `quando a amostra em gramas for igual 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            0.0,
            0.0,
            0.0,
            1.0)
        }
    }

    @Test
    fun `quando a amostra em gramas for for menor que o peso em gramas deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            180.0,
            150.0,
            0.0,
            1.0)
        }
    }

    @Test
    fun `calcula a porcentagem correta`() {
        val defeito = Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            1.0)
        val expected = 2.0 // (3.0 / 150.0) * 100
        val actual = defeito.calcularPorcentagem()
        assertEquals(expected, actual, 0.01)
    }

    @Test
    fun `quando o limite tolerado for maior que a porcentagem, estaAbaixoDoTolerado() deve retornar verdadeiro`() {
        val defeito = Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            1.0,
            150.0,
            0.0,
            1.0)
        val expected = true
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `quando o limite tolerado for menor que a porcentagem, estaAbaixoDoTolerado() deve retornar falso`() {
        val defeito = Defeito(
            DefeitosSojaEnum.QUEIMADOS,
            3.0,
            150.0,
            0.0,
            1.0)
        val expected = false
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `calcula o desconto correto`() {
        val pesoLoteInicial: Double = 1000.0;
        val defeito = Defeito(
            DefeitosSojaEnum.ESVERDEADOS,
            4.0,
            100.0,
            10.0,
            2.0)
        val expected =  (1000.0)*((4.0-2.0)/(100.0-2.0)*((100.0-10.0)/100.0))
        val actual = defeito.calcularDescontoEmKg(pesoLoteInicial)
        assertEquals(expected, actual, 0.01)
    }

}