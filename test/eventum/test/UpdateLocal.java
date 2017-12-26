/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import eventum.dao.LocalDAO;
import eventum.model.Local;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sigaln
 */
public class UpdateLocal {

    public static void main(String[] args) {

        LocalDAO ldao = new LocalDAO();

        Long localId = 1L;

        // obtendo o local pelo id
        System.out.println("\nPegar o Local pelo id: " + localId);

        Local l = ldao.getById(localId);

        System.out.println("Informações do local: ");
        System.out.println(Long.toString(localId));

        System.out.println("Atualizando capacidade do local...");
        l.setCapacidade(210);

        System.out.println("Novas informações do Local");
        System.out.println(Long.toString(localId));

        System.out.println("Done!");

    }

}
