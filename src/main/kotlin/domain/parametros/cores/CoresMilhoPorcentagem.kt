package br.ufu.classisafra.model.parametros.cores

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
class CoresMilhoPorcentagem (
    amarelosEmPorcentagem: Double = 0.0,
    brancosEmPorcentagem: Double = 0.0,
    coloridosEmPorcentagem: Double = 0.0
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
        require(inRange(amarelosEmPorcentagem))
        require(inRange(brancosEmPorcentagem))
        require(inRange(coloridosEmPorcentagem))
    }

    /**
     * Porcentagem de grãos amarelos.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos amarelos não estiver entre 0 e 100.
     */
    var amarelosEmPorcentagem: Double = amarelosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Porcentagem de grãos brancos.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos brancos não estiver entre 0 e 100.
     */
    var brancosEmPorcentagem: Double = brancosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Porcentagem de grãos coloridos.
     *
     * @throws IllegalArgumentException Se a porcentagem de grãos coloridos não estiver entre 0 e 100.
     */
    var coloridosEmPorcentagem: Double = coloridosEmPorcentagem
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