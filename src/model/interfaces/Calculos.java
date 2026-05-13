package model.interfaces;

import java.time.Duration;

public interface Calculos {
    Duration calcularPeriodoDeLocacao();

    Double calcularPagamento();

    Double calcularValorImposto();

    Double totalImposto();
}
