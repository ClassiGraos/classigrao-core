package br.ufu.classisafra.model.graos

import domain.parametros.defeitos.Defeito
import domain.parametros.impurezas.Impurezas
import domain.parametros.umidade.Umidade

/**
 * Classe abstrata que representa grãos com informações sobre amostra, peso inicial e atributos de qualidade.
 *
 * Esta classe serve como uma classe base para representar grãos comuns, incluindo informações sobre amostra,
 * peso inicial e atributos de qualidade, como umidade, impurezas e defeitos.
 *
 * @param amostraEmGramas O peso da amostra em gramas (deve ser maior que zero).
 * @param pesoInicialEmKg O peso inicial do lote de grãos em quilogramas (kg) (deve ser maior que zero).
 * @param umidade O objeto que representa a umidade dos grãos.
 * @param impurezas O objeto que representa as impurezas dos grãos.
 * @param defeitos Uma lista de objetos que representam defeitos dos grãos.
 * @author Victor Hugo Ferreira Silva
 */
abstract class Graos(

    amostraEmGramas: Double,
    pesoInicialEmKg: Double,
    var umidade: Umidade,
    var impurezas: Impurezas,
    var defeitos: List<Defeito>

) {

    /**
     * Peso da amostra em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra for menor ou igual a zero.
     */
    var amostraEmGramas = amostraEmGramas
        set(value) {
            if (value <= 0) throw IllegalArgumentException("O peso da amostra deve ser maior que zero.")
        }

    /**
     * Peso inicial do lote de grãos em quilogramas (kg).
     *
     * @throws IllegalArgumentException Se o peso inicial do lote for menor ou igual a zero.
     */
    var pesoInicialEmKg = pesoInicialEmKg
        set(value) {
            if (value <= 0) IllegalArgumentException("O peso inicial do lote deve ser maior que zero.")
        }


    /**
     * Calcula o desconto em quilogramas (kg) com base nos defeitos, impurezas e umidade dos grãos.
     *
     * @param pesoInicialEmKg O peso inicial do lote de grãos em quilogramas (kg).
     * @return O valor do desconto em quilogramas (kg).
     */
    fun calcularDescontoEmKg(): Double {
        var descontosDefeitosEmKg: Double = 0.0
        for (defeito in defeitos){
            descontosDefeitosEmKg += defeito.calcularDescontoEmKg(pesoInicialEmKg)
        }

        var descontoImpurezasEmKg = impurezas.calcularDescontoEmKg(pesoInicialEmKg)
        var descontoUmidadeEmKg = umidade.calcularDescontoEmKg(pesoInicialEmKg - descontoImpurezasEmKg)

        return descontosDefeitosEmKg + descontoImpurezasEmKg + descontoUmidadeEmKg
    }

    /**
     * Verifica se os parâmetros dos grãos de soja estão dentro dos limites de tolerância.
     *
     * @return true se os grãos estiverem dentro do limite de tolerância, caso contrário false.
     */
    fun verificarSeAbaixoDoTolerado(): Boolean {
        var defeitosEstaoAbaixoDoTolerado: Boolean = true;
        for (defeito in defeitos) {
            defeitosEstaoAbaixoDoTolerado = defeitosEstaoAbaixoDoTolerado && defeito.estaAbaixoDoTolerado()
        }
        val impurezaEstaAbaixoDoTolerado = impurezas.estaAbaixoDoTolerado()
        val umidadeEstaAbaixoDoTolerdao = umidade.estaAbaixoDoTolerado()

        return defeitosEstaoAbaixoDoTolerado && impurezaEstaAbaixoDoTolerado && umidadeEstaAbaixoDoTolerdao
    }

}