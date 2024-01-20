package br.ufu.classisafra.model.parametros.consistencia

data class ConsistenciaMilho(
    var duroEmPorcentagem: Double = 0.0,
    var semiduroEmPorcentagem: Double = 0.0,
    var dentadoEmPorcentagem: Double = 0.0
) {
    init {
        require(inRange(duroEmPorcentagem))
        require(inRange(semiduroEmPorcentagem))
        require(inRange(dentadoEmPorcentagem))
    }
    private fun inRange(value: Double) = value in 0.0..100.0
}
