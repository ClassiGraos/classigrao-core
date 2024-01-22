package domain.parametros.umidade
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals

class UmidadeTest {

    @Test
    fun `quando a umidade for maior que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Umidade(120.0, 14.0) }
    }

    @Test
    fun `quando a umidade for menor que 0 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Umidade(-1.0, 14.0) }
    }

    @Test
    fun `quando o limite tolerado for maior que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Umidade(8.0, 120.0) }
    }

    @Test
     fun `quando o limite tolerado for menor que 100 deve lançar exceção`(){
        assertThrows<IllegalArgumentException> { Umidade(8.0, -1.0) }
    }

    @Test
    fun `quando o limite tolerado for maior que a porcentage estaAbaixoDoTolerado() deve retornar verdadeiro`(){
        val umidade = Umidade(8.0, 14.0)
        val expected = true
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `quando o limite tolerado for maior que a porcentagem estaAbaixoDoTolerado() deve retornar falso`(){
        val umidade = Umidade(18.0, 14.0)
        val expected = false
        val actual = umidade.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun `calcular desconto válido`() {
        val pesoLoteInicial: Double = 1000.0;
        val  pesoDescontoImpurezas: Double = 10.0;
        val umidade: Umidade = Umidade(18.0, 14.0);

        val expectedDesconto: Double = (1000.0-10.0)*(18.0 - 14.0)/(100.0-14.0)
        val actualDesconto: Double = umidade.calcularDescontoEmKg(pesoLoteInicial - pesoDescontoImpurezas);
        assertEquals(expectedDesconto, actualDesconto, 0.01)
    }
}