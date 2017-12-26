package eventum.test;

import eventum.dao.PalestraDAO;
import eventum.model.Local;
import eventum.model.Palestra;
import eventum.model.Palestrante;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nimb
 */
public class ConsultaPalestra {

    public static void main(String[] args) throws Exception {

        
        PalestraDAO dao = new PalestraDAO();
        

        // PALESTRANTES DE UMA PALESTRA
        Palestra palestra = dao.consultarPorId(4L);
        System.out.println("Palestra : " + palestra.getTitulo());
        for (Palestrante palestrante : palestra.getPalestrantes()) {
            System.out.println("Palestrante: " + palestrante.getNome());
        }

        // QUAIS SAO AS PALESTRAS DE UM PALESTRANTE
        PalestranteDAO dao = new PalestranteDAO();

        Palestrante palestrante = dao.consultarPorId(4L);
        System.out.println("Palestrante : " + palestrante.getNome());
        for (Palestra p : palestrante.getPalestras()) {
            System.out.println("Palestra: " + p.getTitulo()
                    + " no " + p.getLocal().getPredio() + "-"
                    + p.getLocal().getSala());
        }

    }

}
