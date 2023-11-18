package Principal;
import trab1.Empresa;
import trab1.Passageiro;

import java.util.Date;
/**
 *
 * @author Francisco
 */
public class Principal {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Cria Empresa.
        Empresa e1=new Empresa();
        //Cria Passageiros
        Passageiro p1=new Passageiro("123","Joao","9123456");
        Passageiro p2=new Passageiro("321","Ana","910909");
        //Cria Motoristas
        e1.addMotorista("11", "Afonso I", 1000);
        e1.addMotorista("33", "Afonso II", 1100);
        //Datas
        Date d1=new Date(2023-12-31);
        Date d2=new Date(2023-12-20);
        //Viagens
        e1.addViagem(1, "Braganca", "Porto",d1, 5, 50);
        e1.addViagem(2, "Porto", "Braganca",d2, 10, 50);
        e1.addViagem(3, "Porto", "Braganca",d1, 10, 50);
        //Remove a Viagem
        e1.removeViagem(3);
        //Remove o Motorista
        e1.removeMotorista("33");
        //Vende Bilhetes
        e1.vendeBilhete(p1,1);
        e1.vendeBilhete(p2,2);
        
        System.out.println("Total: "+e1.getReceitasTotais()+" Euros.");
        // TODO code application logic here
    }
}