package domain.parametros.umidade

import domain.parametros.interfaces.Descontavel
import domain.parametros.interfaces.Toleravel

/**
 * Classe que representa a umidade de um grão e sua tolerância.
 *
 * Esta classe implementa as interfaces [Toleravel] e [Descontavel] para calcular
 * se a umidade está abaixo do limite tolerado e calcular o desconto com base na umidade
 * e no peso inicial.
 *
 * @param umidadeEmPorcentagem A umidade do grão em porcentagem (deve estar entre 0 e 100).
 * @param limiteToleradoEmPorcentagem O limite de umidade tolerado em porcentagem (deve estar entre 0 e 100).
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
 * @author Victor Hugo Ferreira Silva
 */
class Umidade (

    umidadeEmPorcentagem: Double,
    limiteToleradoEmPorcentagem: Double

    ) : Toleravel, Descontavel {

    /**
     * Inicializa uma instância de [Umidade] com os valores de umidade e limite tolerado especificados.
     *
     * Este construtor verifica se os valores iniciais estão dentro do intervalo aceitável (entre 0 e 100)
     * para o teor de umidade e o limite tolerado. Se algum dos valores estiver fora desse intervalo,
     * uma exceção [IllegalArgumentException] é lançada.
     *
     * @param umidadeEmPorcentagem A umidade do grão em porcentagem (deve estar entre 0 e 100).
     * @param limiteToleradoEmPorcentagem O limite de umidade tolerado em porcentagem (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
     * @see Umidade
     */
    init {
        require(inRange(umidadeEmPorcentagem))
        require(inRange(limiteToleradoEmPorcentagem))
    }

    /**
     * Representa a umidade do grão em porcentagem.
     *
     * @param umidadeEmPorcentagem O valor inicial do teor de umidade (deve estar entre 0 e 100).
     */
    var umidadeEmPorcentagem: Double = umidadeEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Representa o limite tolerado do teor de umidade do grão em porcentagem.
     *
     * @param limiteToleradoEmPorcentagem O valor inicial do limite tolerado (deve estar entre 0 e 100).
     */
    var limiteToleradoEmPorcentagem: Double = limiteToleradoEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Intervalo tolerado pelos parâmetros.
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun inRange(value: Double) = value in 0.0..100.0

    /**
     * Verifica se a umidade está abaixo do limite tolerado.
     *
     * @return `true` se a umidade estiver abaixo do limite tolerado, `false` caso contrário.
     */
    override fun estaAbaixoDoTolerado(): Boolean {
        return umidadeEmPorcentagem < limiteToleradoEmPorcentagem
    }

    /**
     * Calcula o desconto em quilogramas (kg) com base na umidade e no peso inicial.
     *
     * Se a umidade estiver abaixo do limite tolerado, nenhum desconto é aplicado.
     *
     * @param pesoInicialEmKg Neste caso o peso inicial será o Peso do Lote Inicial menos
     * o Peso das Impurezas e Matéria Estranhas.
     *
     * @return O valor do desconto em quilogramas (kg).
     */
    override fun calcularDescontoEmKg(pesoInicialEmKg: Double): Double {
        if(estaAbaixoDoTolerado()) return 0.0
        else return pesoInicialEmKg*(umidadeEmPorcentagem-limiteToleradoEmPorcentagem)/(100 - limiteToleradoEmPorcentagem)
    }
}