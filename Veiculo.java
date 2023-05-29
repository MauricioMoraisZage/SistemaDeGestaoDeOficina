import java.util.ArrayList;

public class Veiculo {
    private String placa;
    private String proprietario;
    private String modelo;
    private double ValorAPagar;      //Valor a Pagar...
    
    Veiculo() {
    }
    public Veiculo(String placa, String dono, String modelo, double valor) {
        this.placa = placa;
        this.proprietario = dono;
        this.modelo = modelo;
        this.ValorAPagar = valor;
    }

    public String getPlaca() {
        return placa;
    }
    public String getDono() {
        return proprietario;
    }
    public String getModel() {
        return modelo;
    }
    public double getValor() {
        return ValorAPagar;
    }

    // lista estática para armazenar todos os veículos registrados
    public static ArrayList<Veiculo> TodsVcs = new ArrayList<Veiculo>();
}
