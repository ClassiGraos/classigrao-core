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
data class DefeitosSoja(
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
