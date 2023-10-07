package model.parametros

import br.ufu.classisafra.model.classificacao.tipos_defeitos.TiposDefeitosSoja
import br.ufu.classisafra.model.parametros.Defeito
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class DefeitoTest {

    @Test
    fun givenDefeito_whenDesagioAbove100_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 120.0, 1.0) }
    }

    @Test
    fun givenDefeito_whenDesagioBelow0_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, -1.0, 1.0) }
    }

    @Test
    fun givenDefeito_whenLimiteToleradoEmPorcentagemAbove100_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 0.0, 120.0)  }
    }

    @Test
    fun givenDefeito_whenLimiteToleradoEmPorcentagemBelow100_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 0.0, -1.0)  }
    }

    @Test
    fun givenDefeito_whenPesoEmGramasEquals0_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 0.0, 150.0, 0.0, 1.0)  }
    }

    @Test
    fun givenDefeito_whenAmostraEmGramasEquals0_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 0.0, 0.0, 0.0, 1.0)  }
    }

    @Test
    fun givenDefeito_whenAmostraEmGramasBelowPesoEmGramas_thenThrowsIllegalArgumentException(){
        assertThrows<IllegalArgumentException> { Defeito(TiposDefeitosSoja.QUEIMADOS, 180.0, 150.0, 0.0, 1.0)  }
    }

    @Test
    fun givenDefeito_whenValidParameters_thenCalculatePorcentagem() {
        val defeito = Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 0.0, 1.0)
        val expected = 2.0 // (3.0 / 150.0) * 100
        val actual = defeito.calcularPorcentagem()
        assertEquals(expected, actual, 0.01)
    }

    @Test
    fun givenDefeito_whenDefeitoBelowLimiteTolerado_thenEstaAbaixoDoToleradoShouldReturnTrue() {
        val defeito = Defeito(TiposDefeitosSoja.QUEIMADOS, 1.0, 150.0, 0.0, 1.0)
        val expected = true
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun givenDefeito_whenDefeitoAboveLimiteTolerado_thenEstaAbaixoDoToleradoShouldReturnFalse() {
        val defeito = Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 0.0, 1.0)
        val expected = false
        val actual = defeito.estaAbaixoDoTolerado()
        assertEquals(expected, actual)
    }

    @Test
    fun givenDefeito_whenCalculatingDesconto_thenDescontoIsCalculatedCorrectly() {
        val defeito = Defeito(TiposDefeitosSoja.QUEIMADOS, 3.0, 150.0, 5.0, 1.0)
        val pesoInicialEmKg = 1000.0
        val expected = 9.596 // (2.0 - 1.0) / (100.0 - 1.0) * (100.0 - 5.0 / 100.0) * 1000.0
        val actual = defeito.calcularDescontoEmKg(pesoInicialEmKg)
        assertEquals(expected, actual, 0.01)
    }

}