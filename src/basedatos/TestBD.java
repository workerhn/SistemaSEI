/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos;

/**
 *
 * @author alfae
 */
public class TestBD {

    public static void main(String[] args) {
        BaseDatos bd = new BaseDatos();

        System.out.println(bd.getConnection());
    }
}
