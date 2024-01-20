package br.ufu.classisafra.model.parametros.defeitos

/**
 * Data class que representa os defeitos em uma amostra de grãos de milho em porcentagem.
 *
 * @property ardidosEmPorcentagem A porcentagem de grãos de milho ardidos na amostra.
 * @property mofadosEmPorcentagem A porcentagem de grãos de milho mofados na amostra.
 * @property fermentadosEmPorcentagem A porcentagem de grãos de milho fermentados na amostra.
 * @property germinadosEmPorcentagem A porcentagem de grãos de milho germinados na amostra.
 * @property chochosImaturosEmPorcentagem A porcentagem de grãos de milho chochos ou imaturos na amostra.
 * @property gessadosEmPorcentagem A porcentagem de grãos de milho gessados na amostra.
 * @property carunchadosEmPorcentagem A porcentagem de grãos de milho carunchados na amostra.
 * @property quebradosEmPorcentagem A porcentagem de grãos de milho quebrados na amostra.
 * @author Victor Hugo Ferreira Silva
 */
data class TabelaDefeitosMilho(
    var ardidosEmPorcentagem: Double = 0.0,
    var mofadosEmPorcentagem: Double = 0.0,
    var fermentadosEmPorcentagem: Double = 0.0,
    var germinadosEmPorcentagem: Double = 0.0,
    var chochosImaturosEmPorcentagem: Double = 0.0,
    var gessadosEmPorcentagem: Double = 0.0,
    var carunchadosEmPorcentagem: Double = 0.0,
    var quebradosEmPorcentagem: Double = 0.0
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
