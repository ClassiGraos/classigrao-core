package domain.parametros.defeitos

import br.ufu.classisafra.model.classificacao.tipo.TipoEnum
import domain.parametros.interfaces.Descontavel
import domain.parametros.interfaces.Toleravel
import br.ufu.classisafra.model.classificacao.tipos_defeitos.DefeitosEnum

/**
 * Classe que representa a quantidade de um defeito dos grãos, com informações sobre peso,
 * peso da amostra, valor do deságio e limite percentual tolerado.
 *
 * Esta classe implementa as interfaces [Toleravel] e [Descontavel] para calcular
 * se o defeito está abaixo do limite tolerado e calcular o desconto com base na
 * porcentagem, limite tolerado e deságio.
 *
 * @param tipo Descreve o defeito sendo representado pelo objeto.
 * @param pesoEmGramas O peso do defeito em gramas (deve ser maior ou igual a zero).
 * @param amostraEmGramas O peso da amostra em gramas (deve ser maior ou igual a zero).
 * @param desagio O deságio do defeito (deve estar entre 0 e 100).
 * @param limiteToleradoEmPorcentagem O limite tolerado do defeito (deve estar entre 0 e 100).
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
 * @author Victor Hugo Ferreira Silva
 */
open class Defeito(

    tipo: DefeitosEnum,
    pesoEmGramas: Double,
    amostraEmGramas: Double,
    desagio: Double = 0.0,
    limiteToleradoEmPorcentagem: Double

): Toleravel, Descontavel {

    /**
     * Inicializador da classe [Defeito].
     *
     * Este bloco de inicialização é usado para validar os valores iniciais da instância de [Defeito].
     * Certifica-se de que o peso do defeito e da amostra sejam maiores que zero, e que o deságio e o limite
     * tolerado estejam dentro do intervalo permitido.
     *
     * @param pesoEmGramas O peso do defeito em gramas (deve ser maior que zero).
     * @param amostraEmGramas O peso da amostra em gramas (deve ser maior que zero).
     * @param desagio O deságio do defeito (deve estar entre 0 e 100).
     * @param limiteToleradoEmPorcentagem O limite tolerado em porcentagem (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
     */
    init {
        require(isPositive(pesoEmGramas))
        require(isPositive(amostraEmGramas))
        require(amostraEmGramas >= pesoEmGramas)
        require(inRange(desagio))
        require(inRange(limiteToleradoEmPorcentagem))
    }

    /**
     * Tipo do Defeito.
     */
    var tipo: DefeitosEnum = tipo

    /**
     * Peso do defeito em gramas.
     *
     * @throws IllegalArgumentException Se o peso do defeito for menor ou igual a zero.
     */
    var pesoEmGramas: Double = pesoEmGramas
        set(value) {
            require(isPositive(value))
            require(value <= amostraEmGramas)
            field = value
        }

    /**
     * Peso da amostra em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra for menor ou igual a zero.
     */
    var amostraEmGramas: Double = amostraEmGramas
        set(value) {
            require(isPositive(value))
            require(value >= pesoEmGramas)
            field = value
        }

    /**
     * Deságio do defeito em porcentagem.
     *
     * @throws IllegalArgumentException Se o deságio estiver fora do intervalo permitido.
     */
    var desagio: Double = desagio
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Limite tolerado do defeito em porcentagem.
     *
     * @throws IllegalArgumentException Se o limite tolerado estiver fora do intervalo permitido.
     */
    var limiteToleradoEmPorcentagem: Double = limiteToleradoEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Verifica se o valor é positivo e diferente de zero.
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun isPositive(value: Double) = value > 0

    /**
     * Intervalo tolerado pelos parâmetros.
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun inRange(value: Double) = value in 0.0..100.0

    /**
     * Calcula a porcentagem do defeito em relação à amostra.
     *
     * @return A porcentagem do defeito em relação à amostra.
     */
    fun calcularPorcentagem(): Double {
        return (pesoEmGramas/amostraEmGramas)*100
    }

    /**
     * Verifica se a porcentagem do defeito está abaixo do limite tolerado.
     *
     * @return `true` se o defeito estiver abaixo do limite tolerado, `false` caso contrário.
     */
    override fun estaAbaixoDoTolerado(): Boolean {
        return calcularPorcentagem() < limiteToleradoEmPorcentagem
    }

    /**
     * Calcula o desconto em quilogramas (kg) com base na porcentagem, limite tolerado e deságio.
     *
     * Se o defeito estiver abaixo do limite tolerado, nenhum desconto é aplicado.
     *
     * @param pesoInicialEmKg O peso inicial do produto em quilogramas (kg).
     * @return O valor do desconto em quilogramas (kg).
     */
    override fun calcularDescontoEmKg(pesoInicialEmKg: Double): Double {
        if(estaAbaixoDoTolerado()) return 0.0
        else return pesoInicialEmKg*((calcularPorcentagem()-limiteToleradoEmPorcentagem)/(100 - limiteToleradoEmPorcentagem))*((100 - desagio)/100)
    }

}