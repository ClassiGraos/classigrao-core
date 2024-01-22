package domain.parametros.cores

/**
 * Representa a quantidade de grãos de soja em diferentes cores em uma amostra.
 *
 * Esta classe mantém informações sobre a quantidade de grãos amarelos e grãos de outras cores
 * em uma amostra de soja. Todos os valores devem ser não negativos.
 *
 * @param amostraClasseEmGramas A quantidade total de grãos de soja na amostra.
 * @param graosAmarelosEmGramas A quantidade de grãos de soja amarelos na amostra.
 * @param graosOutrasCoresEmGramas A quantidade de grãos de soja de outras cores na amostra.
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo permitido (menor que zero).
 * @author Victor Hugo Ferreira Silva
 */
class CoresSoja(
    amostraClasseEmGramas: Double,
    graosAmarelosEmGramas: Double,
    graosOutrasCoresEmGramas: Double
) {

    /**
     * Inicializa uma instância de [CoresSoja] verificando se os valores iniciais estão dentro do intervalo permitido.
     *
     * @param amostraClasseEmGramas A quantidade total de grãos de soja na amostra.
     * @param graosAmarelosEmGramas A quantidade de grãos de soja amarelos na amostra.
     * @param graosOutrasCoresEmGramas A quantidade de grãos de soja de outras cores na amostra.
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo permitido (menor que zero).
     */
    init {
        require(isPositive(amostraClasseEmGramas))
        require(isPositive(graosAmarelosEmGramas))
        require(isPositive(graosOutrasCoresEmGramas))
    }

    /**
     * Peso da amostra da classe em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra da classe for menor ou igual a zero.
     */
    var amostraClasseEmGramas: Double = amostraClasseEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos amarelos em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos amarelos for menor ou igual a zero.
     */
    var graosAmarelosEmGramas: Double = graosAmarelosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos de outras cores em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos de outras cores for menor ou igual a zero.
     */
    var graosOutrasCoresEmGramas: Double = graosOutrasCoresEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Verifica se o valor fornecido é maior ou igual a zero.
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    fun isPositive(value: Double) = value >= 0
}