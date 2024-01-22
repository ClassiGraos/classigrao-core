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
open class Graos(

    amostraEmGramas: Double,
    pesoInicialEmKg: Double,
    umidade: Umidade,
    impurezas: Impurezas,
    defeitos: List<Defeito>

) {
     /**
     * Inicializa a classe [Graos], verificando se os valores iniciais de amostra e peso inicial estão dentro do
     * intervalo permitido.
     *
     * @param amostraEmGramas Peso da amostra em gramas.
     * @param pesoInicialEmKg Peso inicial do lote de grãos em quilogramas (kg).
     */
    init {
        require(inRange(amostraEmGramas))
        require(inRange(pesoInicialEmKg))
    }

    /**
     * Peso da amostra em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra for menor ou igual a zero.
     */
    var amostraEmGramas = amostraEmGramas
        set(value) {
            require(inRange(value)) { "O peso da amostra deve ser maior que zero." }
            field = value
        }

    /**
     * Peso inicial do lote de grãos em quilogramas (kg).
     *
     * @throws IllegalArgumentException Se o peso inicial do lote for menor ou igual a zero.
     */
    var pesoInicialEmKg = pesoInicialEmKg
        set(value) {
            require(inRange(value)) { "O peso inicial do lote deve ser maior que zero." }
            field = value
        }

    /**
     * Objeto da classe Umidade.
     */
    var umidade: Umidade = umidade

    /**
     * Objeto da classe Impurezas.
     */
    var impurezas: Impurezas = impurezas

    /**
     * Lista de objetos da classe Defeito.
     */
    var defeitos: List<Defeito> = defeitos


    /**
     * Verifica se o valor fornecido está dentro do intervalo permitido (maior ou igual a zero).
     *
     * @param value O valor a ser verificado.
     * @return true se o valor estiver dentro do intervalo permitido, caso contrário false.
     */
    private fun inRange(value: Double) = value > 0

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