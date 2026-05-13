package model.interfaces;

import java.time.Duration;

interface Calculos{
    Duration calcularPeriodoDeLocacao();
    Double calcularPagamentoPorHora();
    Double calcularPagamentoDiario();
    Double calcularValorImposto();
}
