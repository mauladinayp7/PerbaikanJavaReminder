/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Perbaikan.Java.Reminder.Java.Perbaikan.Reminder;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author mladi
 */
@Controller
public class projectController{
    
    perhitungan p = new perhitungan();
    
    @RequestMapping("/input")
    public String getData(HttpServletRequest data, Model discountprocess){
        
        String inputname = data.getParameter("var_name");        
        String inputprice = data.getParameter("var_harga");        
        String inputquantity = data.getParameter("var_quantity");        
        String inputMoney = data.getParameter("var_money");
        
        
        Double iPrice = Double.valueOf(inputprice);
        Double iQuantity = Double.valueOf(inputquantity);
        Double iMoney = Double.valueOf(inputMoney);
        
        p.purchase(iPrice, iQuantity);
        p.getKet(iMoney, discountprocess);
              
               
        discountprocess.addAttribute("name", inputname);
        discountprocess.addAttribute("price", inputprice);
        discountprocess.addAttribute("quantity", inputquantity);
        discountprocess.addAttribute("Money", inputMoney);
        discountprocess.addAttribute("tAwal", p.tPurchase);
        discountprocess.addAttribute("total", p.getTotal);
        discountprocess.addAttribute("diskon", p.getDiscount);
        
        
        
        return "view";
    }    
}