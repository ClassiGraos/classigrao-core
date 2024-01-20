package br.ufu.classisafra.model.parametros.cores

data class CoresMilho (
    var amarelosEmPorcentagem: Double = 0.0,
    var brancosEmPorcentagem: Double = 0.0,
    var coloridosEmPorcentagem: Double = 0.0
) {
    init {
        require(inRange(amarelosEmPorcentagem))
        require(inRange(brancosEmPorcentagem))
        require(inRange(coloridosEmPorcentagem))
    }

    private fun inRange(value: Double) = value in 0.0..100.0
}