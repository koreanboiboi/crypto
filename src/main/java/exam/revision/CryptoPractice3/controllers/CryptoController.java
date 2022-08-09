package exam.revision.CryptoPractice3.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exam.revision.CryptoPractice3.services.CryptoService;

@Controller
@RequestMapping("/price")
public class CryptoController {
    
    @Autowired
    private CryptoService cryptoSvc;

    @GetMapping
    public String getPrice(@RequestParam (name="fsym") String coin,
                           @RequestParam(name = "tsyms") String currency
                           ,Model model){

        //System.out.println(cryptoSvc.getPrice(coin, currency)); 
        model.addAttribute("fsym",coin);
        model.addAttribute("tsyms",cryptoSvc.getPrice(coin, currency));
        
        
        return "price";
    }

}
