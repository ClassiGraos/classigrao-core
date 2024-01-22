package domain.parametros.cores

/**
 * Representa as cores dos grãos de milho em um lote, indicando a quantidade em gramas de cada tipo de grão.
 *
 * @param amostraClasseEmGramas Peso da amostra do lote em gramas (deve ser maior que zero).
 * @param graosAmarelosEmGramas Peso dos grãos amarelos em gramas (deve ser maior ou igual a zero).
 * @param graosBrancosEmGramas Peso dos grãos brancos em gramas (deve ser maior ou igual a zero).
 * @param graosColoridosEmGramas Peso dos grãos coloridos em gramas (deve ser maior ou igual a zero).
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
 * @author Victor Hugo Ferreira Silva
 */
class CoresMilho(
    amostraClasseEmGramas: Double,
    graosAmarelosEmGramas: Double,
    graosBrancosEmGramas: Double,
    graosColoridosEmGramas: Double
) {

    /**
     * Inicializa a classe [CoresMilho], verificando se os valores iniciais de amostra e pesos dos grãos
     * (amarelos, brancos e coloridos) estão dentro do intervalo permitido.
     *
     * @param amostraClasseEmGramas Peso da amostra do lote em gramas (deve ser maior que zero).
     * @param graosAmarelosEmGramas Peso dos grãos amarelos em gramas (deve ser maior ou igual a zero).
     * @param graosBrancosEmGramas Peso dos grãos brancos em gramas (deve ser maior ou igual a zero).
     * @param graosColoridosEmGramas Peso dos grãos coloridos em gramas (deve ser maior ou igual a zero).
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
     */
    init {
        require(isPositive(amostraClasseEmGramas)) { "O peso da amostra deve ser maior que zero." }
        require(isPositive(graosAmarelosEmGramas)) { "O peso dos grãos amarelos deve ser maior ou igual a zero." }
        require(isPositive(graosBrancosEmGramas)) { "O peso dos grãos brancos deve ser maior ou igual a zero." }
        require(isPositive(graosColoridosEmGramas)) { "O peso dos grãos coloridos deve ser maior ou igual a zero." }
    }

    /**
     * Peso da amostra do lote em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra for menor ou igual a zero.
     */
    var amostraClasseEmGramas: Double = amostraClasseEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos amarelos em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos amarelos for menor que zero.
     */
    var graosAmarelosEmGramas: Double = graosAmarelosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos brancos em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos brancos for menor que zero.
     */
    var graosBrancosEmGramas: Double = graosBrancosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos coloridos em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos coloridos for menor que zero.
     */
    var graosColoridosEmGramas: Double = graosColoridosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Verifica se o valor é positivo e diferente de zero.
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun isPositive(value: Double) = value >= 0
}