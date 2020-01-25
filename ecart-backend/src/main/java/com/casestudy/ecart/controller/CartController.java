package com.casestudy.ecart.controller;

import com.casestudy.ecart.models.Cart;
import com.casestudy.ecart.Repository.CartRepository;
import com.casestudy.ecart.models.OrderHistory;
import com.casestudy.ecart.service.CartService;
import com.casestudy.ecart.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/cart")
public class CartController {
    private CartRepository c;
    @Autowired
    CartService p;
    @Autowired
    userService u;
    @RequestMapping(value="/removeproduct/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Optional<Cart> removeproduct(@PathVariable int  productid, Principal principal)
    {
        return p.removeproduct(u.getUserId(principal),productid);
    }
    @RequestMapping(value="/addtocart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Cart addproduct(@PathVariable int productid, Principal principal)
    {
        return p.addProduct(u.getUserId(principal),productid);
    }
    @RequestMapping(value="/showcart/recieve",method= RequestMethod.GET)
    @ResponseBody
    public List<Cart> showproduct(Principal principal)
    {
        return p.showCart(u.getUserId(principal));
    }
    @RequestMapping(value="/removefromcart/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public String remove(@PathVariable int productid, Principal principal)
    {
        return p.clearCart(u.getUserId(principal), principal);
    }

    @RequestMapping(value="/deleteproduct/recieve/{productid}",method= RequestMethod.GET)
    @ResponseBody
    public Optional<Cart> deleteproduct(@PathVariable int productid, Principal principal)
    {
        return p.deleteproduct(u.getUserId(principal),productid);
    }

    @RequestMapping(value = "/checkout/recieve", method = RequestMethod.GET)
    @ResponseBody
    public double checkout(Principal principal) {
        return p.checkout(u.getUserId(principal),principal);
    }
    @RequestMapping(value = "/orderhistory/recieve", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderHistory> history( Principal principal) {
        return p.showOrderHistory(u.getUserId(principal),principal);
    }

}
