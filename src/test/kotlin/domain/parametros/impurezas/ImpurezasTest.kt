package domain.parametros.impurezas

import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class ImpurezasTest {

    @Test
    fun `quando o limite tolerado for maior que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Impurezas(
            3.0,
            150.0,
            120.0)
        }
    }

    @Test
    fun `quando o limite tolerado for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Impurezas(
            3.0,
            150.0,
            -1.0)
        }
    }

    @Test
    fun `quando o peso em gramas for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Impurezas(
            -1.0,
            150.0,
            1.0)
        }
    }

    @Test
    fun `quando a amostra em gramas for igual 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Impurezas(
            0.0,
            0.0,
            1.0)
        }
    }

    @Test
    fun `quando a amostra em gramas for for menor que o peso em gramas deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Impurezas(
            180.0,
            150.0,
            1.0)
        }
    }

    @Test
    fun `calcula a porcentagem correta`() {
        val impurezas = Impurezas(
            3.0,
            150.0,
            1.0)
        val expected = 2.0 // (3.0 / 150.0) * 100
        val actual = impurezas.calcularPorcentagem()
        assertEquals(expected, actual, 0.01)
    }

    @Test
    fun `quando o limite tolerado for maior que a porcentagem, estaAbaixoDoTolerado() deve retornar verdadeiro`() {
        val impurezas = Impurezas(
            1.0,
            150.0,
            1.0)
        val expected = true
        val actual = impurezas.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `quando o limite tolerado for menor que a porcentagem, estaAbaixoDoTolerado() deve retornar falso`() {
        val impurezas = Impurezas(
            3.0,
            150.0,
            1.0)
        val expected = false
        val actual = impurezas.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `calcular desconto em kg válido`() {
        val pesoLoteInicial: Double = 1000.0;
        val impurezas: Impurezas = Impurezas(2.0, 100.0, 1.0);

        val expectedDesconto: Double = (1000.0)*(2.0 - 1.0)/(100.0-1.0)
        val actualDesconto: Double = impurezas.calcularDescontoEmKg(pesoLoteInicial);
        Assertions.assertEquals(expectedDesconto, actualDesconto, 0.01)
    }

}