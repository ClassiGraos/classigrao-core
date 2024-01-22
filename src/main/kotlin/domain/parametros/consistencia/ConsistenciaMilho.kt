package domain.parametros.consistencia

/**
 * Representa a consistência dos grãos de milho, incluindo informações sobre amostra e a quantidade de grãos
 * classificados como duros, semiduros e dentados.
 *
 * @param amostraGrupoEmGramas Peso da amostra do grupo em gramas.
 * @param graosDurosEmGramas Peso dos grãos classificados como duros em gramas.
 * @param graosSemidurosEmGramas Peso dos grãos classificados como semiduros em gramas.
 * @param graosDentadosEmGramas Peso dos grãos classificados como dentados em gramas.
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
 * @author Victor Hugo Ferreira Silva
 */
class ConsistenciaMilho(
    amostraGrupoEmGramas: Double,
    graosDurosEmGramas: Double,
    graosSemidurosEmGramas: Double,
    graosDentadosEmGramas: Double,
) {

    /**
     * Inicializa a classe [ConsistenciaMilho], verificando se os valores iniciais de amostra e pesos dos grãos
     * (duros, semiduros e dentados) estão dentro do intervalo permitido.
     *
     * @param amostraGrupoEmGramas Peso da amostra do grupo em gramas (deve ser maior que zero).
     * @param graosDurosEmGramas Peso dos grãos classificados como duros em gramas (deve ser maior ou igual a zero).
     * @param graosSemidurosEmGramas Peso dos grãos classificados como semiduros em gramas (deve ser maior ou igual a zero).
     * @param graosDentadosEmGramas Peso dos grãos classificados como dentados em gramas (deve ser maior ou igual a zero).
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo aceitável.
     */
    init {
        require(isPositive(amostraGrupoEmGramas))
        require(isPositive(graosDurosEmGramas))
        require(isPositive(graosSemidurosEmGramas))
        require(isPositive(graosDentadosEmGramas))
    }

    /**
     * Peso da amostra do grupo em gramas.
     *
     * @throws IllegalArgumentException Se o peso da amostra for menor ou igual a zero.
     */
    var amostraGrupoEmGramas = amostraGrupoEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos classificados como duros em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos duros for menor que zero.
     */
    var graosDurosEmGramas = graosDurosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos classificados como semiduros em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos semiduros for menor que zero.
     */
    var graosSemidurosEmGramas = graosSemidurosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Peso dos grãos classificados como dentados em gramas.
     *
     * @throws IllegalArgumentException Se o peso dos grãos dentados for menor que zero.
     */
    var graosDentadosEmGramas = graosDentadosEmGramas
        set(value) {
            require(isPositive(value))
            field = value
        }

    /**
     * Verifica se o valor fornecido está dentro do intervalo permitido (deve estar entre 0 e 100).
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun isPositive(value: Double) = value >= 0.0

}