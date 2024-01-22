package br.ufu.classisafra.model.parametros.consistencia

/**
 * Representa a distribuição percentual de diferentes cores de grãos de milho em uma amostra.
 *
 * Esta classe mantém informações sobre a distribuição percentual de grãos de milho em três categorias:
 * amarelos, brancos e coloridos. Os valores devem estar no intervalo de 0.0 a 100.0, inclusivo.
 *
 * @param amarelosEmPorcentagem A porcentagem de grãos de milho amarelos na amostra.
 * @param brancosEmPorcentagem A porcentagem de grãos de milho brancos na amostra.
 * @param coloridosEmPorcentagem A porcentagem de grãos de milho coloridos na amostra.
 * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo permitido (não entre 0.0 e 100.0).
 * @author Victor Hugo Ferreira Silva
 */
class ConsistenciaMilhoPorcentagem(
    duroEmPorcentagem: Double = 0.0,
    semiduroEmPorcentagem: Double = 0.0,
    dentadoEmPorcentagem: Double = 0.0
) {

    /**
     * Inicializa uma instância de [CoresMilhoPorcentagem] verificando se os valores iniciais estão dentro do intervalo permitido.
     *
     * @param amarelosEmPorcentagem A porcentagem de grãos de milho amarelos na amostra.
     * @param brancosEmPorcentagem A porcentagem de grãos de milho brancos na amostra.
     * @param coloridosEmPorcentagem A porcentagem de grãos de milho coloridos na amostra.
     * @throws IllegalArgumentException Se algum dos valores iniciais estiver fora do intervalo permitido (não entre 0.0 e 100.0).
     */
    init {
        require(inRange(duroEmPorcentagem))
        require(inRange(semiduroEmPorcentagem))
        require(inRange(dentadoEmPorcentagem))
    }

    /**
     * Porcentagem de grãos de milho duros.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos duros não estiver entre 0 e 100.
     */
    var duroEmPorcentagem: Double = duroEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Porcentagem de grãos de milho semiduros.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos semiduros não estiver entre 0 e 100.
     */
    var semiduroEmPorcentagem: Double = semiduroEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Porcentagem de grãos de milho dentados.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos dentados não estiver entre 0 e 100.
     */
    var dentadoEmPorcentagem: Double = dentadoEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Verifica se o valor fornecido está dentro do intervalo permitido (entre 0.0 e 100.0, inclusivo).
     *
     * @param value O valor a ser verificado.
     * @return `true` se o valor estiver dentro do intervalo permitido, caso contrário `false`.
     */
    private fun inRange(value: Double) = value in 0.0..100.0
}
