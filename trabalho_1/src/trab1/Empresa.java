package trab1;

import java.util.Date;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 *
 * @author Francisco
 */

public class Empresa {
    
    private final LinkedList<Motorista> motoristas;
    private final TreeMap<Integer,Viagem>viagens;
    
    public Empresa(){
        motoristas=new LinkedList<>();
        viagens=new TreeMap<>();
    }
    
    public boolean addMotorista(String n,String name,double s){
        if(motoristas.contains(n))return false;
        else{
            motoristas.add(new Motorista(n,name,s));
            return true;
        }
    }
    
    public boolean addViagem(Integer cod,String lp,String ld,Date dp,double p,int nl){
        if(viagens.containsKey(cod))return false;
        else{
            viagens.put(cod, new Viagem(cod,lp,ld,dp,p,nl));
            return true;
        }
    }
    
    public boolean removeMotorista(String nif){
        for(Motorista m:motoristas){//percorre os motoristas, m é um iterator;
            if(m.getNif().equals(nif)){//até encontrar o nif correspondente;
                return motoristas.remove(m);//remove o motorista
            }else
                return false;
        }
        return false;
    }
    
    public boolean removeViagem(int cod){
        if(viagens.containsKey(cod)){//percorre as viagens ate encontrar o cod
            viagens.remove(cod);//remove a viagem
            return true;
        }else
            return false;
    }
    
    public double getReceitasTotais(){
        double receitas_totais=0.0;
        for(Viagem v:viagens.values()){
            receitas_totais +=v.getReceitas();
        }
        return receitas_totais;
    }
    
    public boolean vendeBilhete(Passageiro p, int codViagem) {
        if (viagens.containsKey(codViagem)) { //Verifica se a viagem existe;
            Viagem v = viagens.get(codViagem); //Crio um objeto viagem "iterador" que procura o codViagem em viagem.
            if (v.getLugaresDisponiveis() > 0) //Verifico os lugares disp.
                v.vendeBilhete(p);//vende o bilhete                 
            else
                return false; // Não há lugares disponíveis na viagem
        }
        return false; // Viagem não encontrada
    }
}
