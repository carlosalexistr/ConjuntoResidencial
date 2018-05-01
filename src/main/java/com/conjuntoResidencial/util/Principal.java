/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.conjuntoResidencial.util;

import com.conjuntoResidencial.dao.GrupoFamiliarDAO.GrupoFamiliarDAOImpl;
import com.conjuntoResidencial.model.Grupofamiliar;
import java.util.Date;

/**
 *
 * @author Julian Olarte Torres
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Iniciando prueba");
        
        //Instanciamos el objecto AsambleaDAOImpl (es la que tiene los metodos usables)
//          AsambleaDAOImpl asambleadao= new AsambleaDAOImpl();
        GrupoFamiliarDAOImpl grupofami = new GrupoFamiliarDAOImpl();
        //Creamos un nuevo objeto de tipo Asamblea y lo llenamos (el id no se llena, este se genera automaticamente cuando se guarde)
//        Asamblea asm = new Asamblea();
//        asm.setFecha(new Date(94,11, 23));
//        asm.setDescripcion("asamblea de prueba descripcion");
//        asm.setLugar("San jose d cucuta");
Grupofamiliar gf = new  Grupofamiliar();

        gf.setCelular("32155631");
        gf.setDocumento("01029883");
        gf.setFechanacimiento(new Date(94,11, 23));
        gf.setId(1);
        gf.setNombre("Familia Robinson");
          //Guardamos en la base de datos con el metodo save de AsambleaDOImpl
//        asambleadao.save(asm);
        grupofami.save(gf);
        
        //llamamos al metodo findAll y lo recorremos para mostrar el .toString del objeto
//        List<Asamblea> asambleas = asambleadao.findAll();
//        for(Asamblea asamblea: asambleas) {
//            System.out.println(asamblea.toString());
//        }
        System.out.println("Ejemplo finalizao correctamente");
        System.out.println("aqui estuvo DaQuin");
    }
    
}
