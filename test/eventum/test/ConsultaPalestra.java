package eventum.test;

import eventum.dao.PalestraDAO;
import eventum.model.Palestra;
import eventum.model.Palestrante;

/**
 *
 * @author nimb
 */
public class ConsultaPalestra {

    public static void main(String[] args) throws Exception {

        
        PalestraDAO dao = new PalestraDAO();
        

        // PALESTRANTES DE UMA PALESTRA
        Palestra palestra = dao.consultarPorId(3L);
        
        
        
        System.out.println("Palestra : " + palestra.getTitulo());
        for (Palestrante palestrante : palestra.getPalestrantes()) {
            System.out.println("Palestrante: " + palestrante.getNome());
        }

// QUAIS SAO AS PALESTRAS DE UM PALESTRANTE
//        PalestranteDAO dao = new PalestranteDAO();
//
//        Palestrante palestrante = dao.consultarPorId(4L);
//        System.out.println("Palestrante : " + palestrante.getNome());
//        for (Palestra p : palestrante.getPalestra()) {
//            System.out.println("Palestra: " + p.getTitulo()
//                    + " no " + p.getLocal().getPredio() + "-"
//                    + p.getLocal().getSala());
//        }

    }

}
