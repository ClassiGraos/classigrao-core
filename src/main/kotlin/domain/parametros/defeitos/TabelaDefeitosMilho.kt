package br.ufu.classisafra.model.parametros.defeitos

/**
 * Data class que representa os defeitos em uma amostra de grãos de milho em porcentagem.
 *
 * @param ardidosEmPorcentagem A porcentagem de grãos de milho ardidos na amostra.
 * @param mofadosEmPorcentagem A porcentagem de grãos de milho mofados na amostra.
 * @param fermentadosEmPorcentagem A porcentagem de grãos de milho fermentados na amostra.
 * @param germinadosEmPorcentagem A porcentagem de grãos de milho germinados na amostra.
 * @param chochosImaturosEmPorcentagem A porcentagem de grãos de milho chochos ou imaturos na amostra.
 * @param gessadosEmPorcentagem A porcentagem de grãos de milho gessados na amostra.
 * @param carunchadosEmPorcentagem A porcentagem de grãos de milho carunchados na amostra.
 * @param quebradosEmPorcentagem A porcentagem de grãos de milho quebrados na amostra.
 * @author Victor Hugo Ferreira Silva
 */
class TabelaDefeitosMilho(
    ardidosEmPorcentagem: Double = 0.0,
    mofadosEmPorcentagem: Double = 0.0,
    fermentadosEmPorcentagem: Double = 0.0,
    germinadosEmPorcentagem: Double = 0.0,
    chochosImaturosEmPorcentagem: Double = 0.0,
    gessadosEmPorcentagem: Double = 0.0,
    carunchadosEmPorcentagem: Double = 0.0,
    quebradosEmPorcentagem: Double = 0.0
) {

    /**
     * Inicializador da classe [TabelaDefeitosMilho].
     *
     * Este bloco de inicialização é usado para validar os valores iniciais da instância de [TabelaDefeitosMilho].
     * Certifica-se de que todos os parâmetros estejam dentro do intervalo tolerado.
     *
     * @param ardidosEmPorcentagem Porcentagem de grãos ardidos.
     * @param mofadosEmPorcentagem Porcentagem de grãos mofados.
     * @param fermentadosEmPorcentagem Porcentagem de grãos fermentados.
     * @param germinadosEmPorcentagem Porcentagem de grãos germinados.
     * @param chochosImaturosEmPorcentagem Porcentagem de grãos chochos e imaturos.
     * @param gessadosEmPorcentagem Porcentagem de grãos gessados.
     * @param carunchadosEmPorcentagem Porcentagem de grãos carunchados.
     * @param quebradosEmPorcentagem Porcentagem de grãos quebrados.
     */
    init {
        require(inRange(ardidosEmPorcentagem))
        require(inRange(mofadosEmPorcentagem))
        require(inRange(fermentadosEmPorcentagem))
        require(inRange(germinadosEmPorcentagem))
        require(inRange(chochosImaturosEmPorcentagem))
        require(inRange(gessadosEmPorcentagem))
        require(inRange(carunchadosEmPorcentagem))
        require(inRange(quebradosEmPorcentagem))
    }

    /**
     * Define a porcentagem de grãos ardidos.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var ardidosEmPorcentagem: Double = ardidosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos mofados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var mofadosEmPorcentagem: Double = mofadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos fermentados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var fermentadosEmPorcentagem: Double = fermentadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos germinados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var germinadosEmPorcentagem: Double = germinadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos chochos/imaturos.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var chochosImaturosEmPorcentagem: Double = chochosImaturosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos gessados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var gessadosEmPorcentagem: Double = gessadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos carunchados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var carunchadosEmPorcentagem: Double = carunchadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos quebrados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var quebradosEmPorcentagem: Double = quebradosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Intervalo tolerado pelos parâmetros.
     */
    private fun inRange(value: Double) = value in 0.0..100.0

    /**
     * Calcula a porcentagem total de grãos de milho avariados na amostra, considerando os defeitos ardidos,
     * mofados, fermentados, germinados, chochos e gesssados.
     *
     * @return A porcentagem total de grãos de milho avariados na amostra.
     */
    fun calcularAvariadosEmPorcentagem() = (ardidosEmPorcentagem + mofadosEmPorcentagem +
            fermentadosEmPorcentagem + germinadosEmPorcentagem + chochosImaturosEmPorcentagem + gessadosEmPorcentagem)
}
