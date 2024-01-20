package domain.graos

import br.ufu.classisafra.model.graos.Graos
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class GraosTest {

    @Test
    fun `definir amostraEmGramas com valor válido`() {
        val graos = object : Graos(
            amostraEmGramas = 100.0,
            pesoInicialEmKg = 50.0,
            umidade = Umidade(11.0, 14.0),
            impurezas = Impurezas(12.0, 150.0, 5.0),
            defeitos = emptyList()
        ) {}

        assertEquals(100.0, graos.amostraEmGramas)
    }

    @Test
    fun `definir amostraEmGramas com valor inválido`() {
        assertThrows<IllegalArgumentException> {
            object : Graos(
                amostraEmGramas = -10.0,
                pesoInicialEmKg = 50.0,
                umidade = Umidade(11.0, 14.0),
                impurezas = Impurezas(12.0, 150.0, 5.0),
                defeitos = emptyList()
            ) {}
        }
    }

    @Test
    fun `definir pesoInicialEmKg com valor válido`() {
        val graos = object : Graos(
            amostraEmGramas = 100.0,
            pesoInicialEmKg = 50.0,
            umidade = Umidade(11.0, 14.0),
            impurezas = Impurezas(12.0, 150.0, 5.0),
            defeitos = emptyList()
        ) {}

        assertEquals(50.0, graos.pesoInicialEmKg)
    }

    @Test
    fun `definir pesoInicialEmKg com valor inválido`() {
        assertThrows<IllegalArgumentException> {
            object : Graos(
                amostraEmGramas = 100.0,
                pesoInicialEmKg = 0.0,
                umidade = Umidade(11.0, 14.0),
                impurezas = Impurezas(12.0, 150.0, 5.0),
                defeitos = emptyList()
            ) {}
        }
    }

}