package br.ufu.classisafra.model.parametros.defeitos

/**
 * Esta classe representa os defeitos encontrados em grãos de soja.
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
 * @author Victor Hugo Ferreira Silva
 */
class TabelaDefeitosSoja(
    ardidosEmPorcentagem: Double = 0.0,
    queimadosEmPorcentagem: Double = 0.0,
    mofadosEmPorcentagem: Double = 0.0,
    fermentadosEmPorcentagem: Double = 0.0,
    germinadosEmPorcentagem: Double = 0.0,
    imaturosEmPorcentagem: Double = 0.0,
    chochosEmPorcentagem: Double = 0.0,
    atacadosPorPragaEmPorcentagem: Double = 0.0,
    demaisDanificadosEmPorcentagem: Double = 0.0,
    esverdeadosEmPorcentagem: Double = 0.0,
    partidosQuebradosAmaçadosEmPorcentagem: Double = 0.0
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
     * Define a porcentagem de grãos queimados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var queimadosEmPorcentagem: Double = queimadosEmPorcentagem
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
     * Define a porcentagem de grãos imaturos.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var imaturosEmPorcentagem: Double = imaturosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos chochos.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var chochosEmPorcentagem: Double = chochosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos atacados por pragas.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var atacadosPorPragaEmPorcentagem: Double = atacadosPorPragaEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos danificados de outra forma.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var demaisDanificadosEmPorcentagem: Double = demaisDanificadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos esverdeados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var esverdeadosEmPorcentagem: Double = esverdeadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
        }

    /**
     * Define a porcentagem de grãos partidos, quebrados ou amassados.
     *
     * @param value O novo valor (deve estar entre 0 e 100).
     * @throws IllegalArgumentException Se o valor fornecido estiver fora do intervalo aceitável.
     */
    var partidosQuebradosAmaçadosEmPorcentagem: Double = partidosQuebradosAmaçadosEmPorcentagem
        set(value) {
            require(inRange(value))
            field = value
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
