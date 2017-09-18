/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ims;

import ims.view.Login;
import ims.view.StoreKeeperMain;

/**
 *
 * @author Chamath
 */
public class IMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Login login = new Login();
        //login.setVisible(true);
        //login.setLocationRelativeTo(null);
        
        StoreKeeperMain skm = new StoreKeeperMain();
        skm.setVisible(true);
        skm.setLocationRelativeTo(null);

    }
    
}
