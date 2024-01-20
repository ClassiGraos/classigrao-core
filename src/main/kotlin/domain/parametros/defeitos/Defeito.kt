package domain.parametros.defeitos

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

    var tipo: DefeitosEnum,
    pesoEmGramas: Double,
    amostraEmGramas: Double,
    desagio: Double = 0.0,
    limiteToleradoEmPorcentagem: Double = Double.POSITIVE_INFINITY

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
        if (pesoEmGramas <= 0) throw IllegalArgumentException("O peso do defeito deve ser maior que zero.")
        if (amostraEmGramas <= 0) throw IllegalArgumentException("O peso da amostra deve ser maior que zero.")
        if (amostraEmGramas < pesoEmGramas) throw IllegalArgumentException("O peso da amostra deve ser maior que o peso do defeito.")
        if (desagio < 0 || desagio > 100) throw IllegalArgumentException("O desagio deve estar entre 0 e 100.")
        if (limiteToleradoEmPorcentagem < 0 || limiteToleradoEmPorcentagem > 100) throw IllegalArgumentException("O limite tolerado deve estar entre 0 e 100.")
    }

    /**
     * Peso do defeito em gramas.
     */
    var pesoEmGramas: Double = pesoEmGramas

    /**
     * Peso da amostra em gramas.
     */
    var amostraEmGramas: Double = amostraEmGramas

    /**
     * Valor do deságio do defeito.
     */
    var desagio: Double = desagio

    /**
     * Representa o limite tolerado do defeito do grão em porcentagem.
     *
     * @param limiteToleradoEmPorcentagem O valor inicial do limite tolerado (deve estar entre 0 e 100).
     */
    var limiteToleradoEmPorcentagem: Double  = limiteToleradoEmPorcentagem

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