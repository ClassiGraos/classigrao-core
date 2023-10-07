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
data class DefeitosMilho(
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
     * Calcula a porcentagem total de grãos de milho avariados na amostra, considerando os defeitos ardidos,
     * mofados, fermentados, germinados, chochos e gesssados.
     *
     * @return A porcentagem total de grãos de milho avariados na amostra.
     */
    fun calcularAvariadosEmPorcentagem() = (ardidosEmPorcentagem + mofadosEmPorcentagem +
            fermentadosEmPorcentagem + germinadosEmPorcentagem + chochosImaturosEmPorcentagem + gessadosEmPorcentagem)
}
