package model.entity;

import model.interfaces.Calculos;

import java.time.Duration;
import java.time.LocalDateTime;

public class Locacao implements Calculos {

    private String modeloCarro;
    private LocalDateTime dataDeRetirada;
    private LocalDateTime dataDeEntrega;
    private Double valorPorHora;
    private Double valorDiario;

    public Locacao() {
    }

    public Locacao(String modeloCarro, LocalDateTime dataDeRetirada, LocalDateTime dataDeEntrega, Double valorPorHora, Double valorDiario) {
        this.modeloCarro = modeloCarro;
        this.dataDeRetirada = dataDeRetirada;
        this.dataDeEntrega = dataDeEntrega;
        this.valorPorHora = valorPorHora;
        this.valorDiario = valorDiario;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public LocalDateTime getDataDeRetirada() {
        return dataDeRetirada;
    }

    public LocalDateTime getDataDeEntrega() {
        return dataDeEntrega;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public Double getValorDiario() {
        return valorDiario;
    }

    public Duration calcularPeriodoDeLocacao() {
        return Duration.between(dataDeRetirada, dataDeEntrega);
    }

    double valorPagamentoBasico = 0;

    public Double calcularPagamento() {
        if (calcularPeriodoDeLocacao().toHours() <= 12) {
            double horas = Math.ceil(calcularPeriodoDeLocacao().toMinutes() / 60.0);
            valorPagamentoBasico += horas * valorPorHora;
        } else {
            double dias = Math.ceil((double) calcularPeriodoDeLocacao().toMinutes() / 1440);
            valorPagamentoBasico += dias * valorDiario;
        }
        return valorPagamentoBasico;
    }

    double valorFinal = 0;

    public Double calcularValorImposto() {
        if (valorPagamentoBasico <= 100) {
            valorFinal = valorPagamentoBasico + (valorPagamentoBasico * 0.2);
        } else {
            valorFinal = valorPagamentoBasico + (valorPagamentoBasico * 0.15);
        }
        return valorFinal;
    }

    double totalImposto = 0;

    public Double totalImposto() {
        if (valorPagamentoBasico <= 100) {
            totalImposto = valorPagamentoBasico * 0.2;
        } else {
            totalImposto = valorPagamentoBasico * 0.15;
        }
        return totalImposto;
    }


}
