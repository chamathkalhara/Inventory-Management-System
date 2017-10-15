/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import ims.view.ManagerMain2;
import javax.swing.JFrame;

/**
 *
 * @author Chamath
 */
public class IMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Login2 main2 = new Login2();
        //StoreKeeperMain main2 = new StoreKeeperMain();
        //CashierMain main2 = new CashierMain();
        ManagerMain2 main2 = new ManagerMain2();
        main2.setVisible(true);
        main2.setLocationRelativeTo(null);
        main2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
