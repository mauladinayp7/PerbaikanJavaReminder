/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perbaikan.Java.Reminder.Java.Perbaikan.Reminder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

/**
 *
 * @author mladi
 */
@Controller
public class perhitungan {
    Double getTotal, tPurchase, getDiscount;
    public int Disc;
    public Double purchase(Double inputprice, Double var_quantity)
    {
        tPurchase = inputprice * var_quantity;
        
        if(tPurchase < 16000)
        {
            Disc = 0;
        }
        else if(tPurchase >= 16000 && tPurchase <= 24000)
        {
            Disc = 10;
        }
        else
        {
            Disc = 15;
        }
        
        getDiscount = tPurchase * Disc/100;
        getTotal = tPurchase - getDiscount;
        
        return getTotal;
    }
    
    public String getKet(Double inputMoney, Model done)
    {
        String ket = " ";
        Double change = inputMoney - getTotal;
        Double min = getTotal - inputMoney;
        
        if(getTotal < inputMoney)
        {
            ket = "uang kembalian anda " + change;
        }
        else if(getTotal > inputMoney)
        {
            ket = "uang anda kurang "+min;
        }
        else
        {
            ket ="uang pas!";
        }
        
        done.addAttribute("ket", ket);
        return ket;
    }
}