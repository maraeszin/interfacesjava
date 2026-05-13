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

    public Duration calcularPeriodoDeLocacao(){
        return Duration.between(dataDeRetirada, dataDeEntrega);
    }

    public Double calcularPagamentoPorHora(){
        if (calcularPeriodoDeLocacao().toDays() < 1 && calcularPeriodoDeLocacao().toMinutes() > 1){
            long horas = Math.round(calcularPeriodoDeLocacao().toHours()) + 1;
            return horas * valorPorHora;
        } else if (calcularPeriodoDeLocacao().toDays() >= 1){
            long dias =
        }
        return null;
    }


}
