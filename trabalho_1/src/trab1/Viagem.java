package trab1;
import java.util.Date;
import java.util.LinkedList;

/**
 *
 * @author Francisco
 */
public class Viagem {
    private int cod;
    private String localPartida;
    private String localDestino;
    private Date dataPartida;
    private double precoBilhete;
    private int numLugares;
    private int numLugaresComprados;
    private Motorista motoristas;
    private LinkedList<Passageiro>passageiros;
    
    public Viagem(Integer cod,String lp,String ld,Date dp,double p,int nl,Motorista m){
        this.cod=cod;
        localPartida=lp;
        localDestino=ld;
        numLugares=nl;
        precoBilhete=p;
        dataPartida=dp;
        motoristas=m;
        passageiros = new LinkedList<>();
    }
    
    public Viagem(Integer cod,String lp,String ld,Date dp,double p,int nl){
        this.cod=cod;
        localPartida=lp;
        localDestino=ld;
        numLugares=nl;
        precoBilhete=p;
        dataPartida=dp;
        passageiros = new LinkedList<>();
    }

    public int getCod(){
        return cod;
    }
    
    public String getLocalPartida() {
        return localPartida;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public double getPrecoBilhete() {
        return precoBilhete;
    }

    public int getNumLugares() {
        return numLugares;
    }

    public void setMotoristas(Motorista m) {
        motoristas=m;
    }
   
    public Motorista getMotorista(){
        return motoristas;
    }
    
    public boolean addPassageiro(Passageiro p){
        return passageiros.add(p);
    }
     
    public boolean vendeBilhete(Passageiro p) {
        if (numLugaresComprados < numLugares) { //Verifica se tem lugares disp.
            passageiros.add(p); //adiciona o passageiro
            numLugaresComprados++; //incrementa numLugaresComprados
            return true; // Bilhete vendido
        }
        return false; // Bilhete nao vendido
    }
      
    public int getLugaresDisponiveis(){
        return numLugares-numLugaresComprados();
    }
    
    public int numLugaresComprados() {
        return numLugaresComprados;
    }
    
    public double getReceitas(){
        return numLugaresComprados()*precoBilhete;
    }
}