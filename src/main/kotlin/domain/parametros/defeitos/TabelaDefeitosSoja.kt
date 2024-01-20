package br.ufu.classisafra.model.parametros.defeitos

/**
 * Esta classe representa os defeitos encontrados em grãos de soja.
 *
 * @property ardidosEmPorcentagem Porcentagem de grãos ardidos.
 * @property queimadosEmPorcentagem Porcentagem de grãos queimados.
 * @property mofadosEmPorcentagem Porcentagem de grãos mofados.
 * @property fermentadosEmPorcentagem Porcentagem de grãos fermentados.
 * @property germinadosEmPorcentagem Porcentagem de grãos germinados.
 * @property imaturosEmPorcentagem Porcentagem de grãos imaturos.
 * @property chochosEmPorcentagem Porcentagem de grãos chochos.
 * @property atacadosPorPragaEmPorcentagem Porcentagem de grãos atacados por pragas.
 * @property demaisDanificadosEmPorcentagem Porcentagem de grãos danificados por outros motivos.
 * @property esverdeadosEmPorcentagem Porcentagem de grãos esverdeados.
 * @property partidosQuebradosAmaçadosEmPorcentagem Porcentagem de grãos partidos, quebrados ou amassados.
 */
data class TabelaDefeitosSoja(
    var ardidosEmPorcentagem: Double = 0.0,
    var queimadosEmPorcentagem: Double = 0.0,
    var mofadosEmPorcentagem: Double = 0.0,
    var fermentadosEmPorcentagem: Double = 0.0,
    var germinadosEmPorcentagem: Double = 0.0,
    var imaturosEmPorcentagem: Double = 0.0,
    var chochosEmPorcentagem: Double = 0.0,
    var atacadosPorPragaEmPorcentagem: Double = 0.0,
    var demaisDanificadosEmPorcentagem: Double = 0.0,
    var esverdeadosEmPorcentagem: Double = 0.0,
    var partidosQuebradosAmaçadosEmPorcentagem: Double = 0.0
) {

    /**
     * Inicializador da classe [TabelaDefeitosSoja].
     *
     * Este bloco de inicialização é usado para validar os valores iniciais da instância de [TabelaDefeitosSoja].
     * Certifica-se de que todos os parâmetros esteja dentro do intervalo tolerado.
     *
     * @param ardidosEmPorcentagem Porcentagem de grãos ardidos.
     * @param queimadosEmPorcentagem Porcentagem de grãos queimados.
     * @param mofadosEmPorcentagem Porcentagem de grãos mofados.
     * @param fermentadosEmPorcentagem Porcentagem de grãos fermentados.
     * @param germinadosEmPorcentagem Porcentagem de grãos germinados.
     * @param imaturosEmPorcentagem Porcentagem de grãos imaturos.
     * @param chochosEmPorcentagem Porcentagem de grãos chochos.
     * @param atacadosPorPragaEmPorcentagem Porcentagem de grãos atacados por pragas.
     * @param demaisDanificadosEmPorcentagem Porcentagem de grãos danificados por outros motivos.
     * @param esverdeadosEmPorcentagem Porcentagem de grãos esverdeados.
     * @param partidosQuebradosAmaçadosEmPorcentagem Porcentagem de grãos partidos, quebrados ou amassados.
     */
    init {
        require(inRange(ardidosEmPorcentagem))
        require(inRange(queimadosEmPorcentagem))
        require(inRange(mofadosEmPorcentagem))
        require(inRange(fermentadosEmPorcentagem))
        require(inRange(germinadosEmPorcentagem))
        require(inRange(imaturosEmPorcentagem))
        require(inRange(chochosEmPorcentagem))
        require(inRange(atacadosPorPragaEmPorcentagem))
        require(inRange(demaisDanificadosEmPorcentagem))
        require(inRange(esverdeadosEmPorcentagem))
        require(inRange(partidosQuebradosAmaçadosEmPorcentagem))
    }

    /**
     * Intervalo tolerado pelos parâmetros.
     */
    private fun inRange(value: Double) = value in 0.0..100.0;

    /**
     * Calcula a porcentagem de grãos avariados, que inclui grãos ardidos, mofados, fermentados, germinados,
     * imaturos, chochos e danificados.
     *
     * @return A porcentagem de grãos avariados.
     */
    fun calcularAvariadosEmPorcentagem() = (calcularArdidosQueimadosEmPorcentagem() + mofadosEmPorcentagem + fermentadosEmPorcentagem +
            germinadosEmPorcentagem + imaturosEmPorcentagem + chochosEmPorcentagem + calcularDanificadosEmPorcentagem())

    /**
     * Calcula a porcentagem de grãos ardidos e queimados.
     *
     * @return A porcentagem de grãos ardidos e queimados.
     */
    fun calcularArdidosQueimadosEmPorcentagem() = ardidosEmPorcentagem + queimadosEmPorcentagem

    /**
     * Calcula a porcentagem de grãos danificados, incluindo os atacados por pragas e outros danificados.
     *
     * @return A porcentagem de grãos danificados.
     */
    fun calcularDanificadosEmPorcentagem() = atacadosPorPragaEmPorcentagem / 4 + demaisDanificadosEmPorcentagem

    /**
     * Calcula a porcentagem de grãos com defeitos graves, incluindo os queimados, ardidos e mofados.
     *
     * @return A porcentagem de grãos com defeitos graves.
     */
    fun calcularDefeitosGravesEmPorcentagem() = queimadosEmPorcentagem + ardidosEmPorcentagem + mofadosEmPorcentagem
}
