package com.casestudy.ecart.service;



import com.casestudy.ecart.models.Cart;
//import com.caseStudy.ecart.models.FixedCart;
import com.casestudy.ecart.models.OrderHistory;
import com.casestudy.ecart.models.Products;
import com.casestudy.ecart.models.Users;
import com.casestudy.ecart.Repository.*;
import com.casestudy.ecart.Repository.ProductRepository;
import com.casestudy.ecart.Repository.CartRepository;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private ProductRepository productRepoistory;
    @Autowired
    private CartRepository cartRepository;
    //@Autowired
    // private FixedCartRepository fixedCartRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderHistoryRepository OrderHistoryRepository;

    public Cart addProduct(Long  userid, int productid) {
        Products products = productRepoistory.findByPid(productid);
        Users users = userRepository.findByUid((userid));



        if (cartRepository.findByUsersAndProducts(users, products).isPresent()) {
            Cart cartt =(Cart) cartRepository.findByUsersAndProducts(users, products).get();
            //    FixedCart fixedCart = fixedCartRepository.findByRefId(cartt.getId().intValue());
            cartt.setQuantity(cartt.getQuantity() + 1);
            //  fixedCart.setQuantity(fixedCart.getQuantity() + 1);
            cartRepository.save(cartt);
            // fixedCartRepository.save(fixedCart);
        } else {
            Cart c = new Cart(products, users, 1);
            //   FixedCart fc = new FixedCart(products, users, 1);
            cartRepository.save(c);
            //   fixedCartRepository.save(fc);
        }
        return (Cart)cartRepository.findByUsersAndProducts(users,products).get();
    }
    public Optional<Cart> removeproduct(Long userid,int productid) {
        Products products = productRepoistory.findByPid(productid);
        Users users = userRepository.findByUid(userid);

        if(cartRepository.findByUsersAndProducts(users,products).get().getQuantity() == 1) {
            Cart cart = (Cart)cartRepository.findByUsersAndProducts(users,products).get();
            cart.setQuantity(0);
            cartRepository.delete(cart);
        }
        else {
            Cart cart = cartRepository.findByUsersAndProducts(users,products).get();

            cart.setQuantity(cart.getQuantity() - 1);
            cartRepository.save(cart);
        }
        return cartRepository.findByUsersAndProducts(users,products);
    }

    public List<Cart> showCart(Long  user_id) {
        Users user = userRepository.findByUid(user_id);
        return cartRepository.findByUsersAndProducts_Active(user, 1);
    }
    public Optional<Cart> deleteproduct(Long userid,int productid)
    {
        Products product=productRepoistory.findByPid(productid);
        Users users=userRepository.findByUid(userid);
        Cart cart=cartRepository.findByUsersAndProducts(users,product).get();
        cartRepository.delete(cart);
        return cartRepository.findByUsersAndProducts(users,product);

    }
    public String clearCart(Long userId, Principal principal) {

        Users user = userRepository.findByUid(userId);
        List<Cart> cartList=cartRepository.findAllByUsers(user);
        for (Cart cart : cartList) {
            cartRepository.deleteById(cart.getCartId());
        }
        return "cart cleared!";
    }
    public double checkout(Long userid, Principal principal) {
        Users users = userRepository.findByUid(userid);
        double p;
        double total = 0;
        List<Cart> cartList = cartRepository.findAllByUsers(users);
        for(Cart cart: cartList){
            OrderHistory orderHistory = new OrderHistory();
            orderHistory.setProducts(cart.getProducts());
            orderHistory.setUsers(cart.getUsers());
            p = cart.getProducts().getPrductPrice();
            orderHistory.setQuantity(cart.getQuantity());
            total = total+cart.getQuantity()*p;
            orderHistory.setPrice((int)(cart.getQuantity()*p));
            orderHistory.setDate();
            OrderHistoryRepository.save(orderHistory);

        }
        clearCart(userid,principal);
        return total;
    }
    public List<OrderHistory> showOrderHistory(Long userid, Principal principal)
    {
        Users users=userRepository.findByUid(userid);
       return OrderHistoryRepository.findAllByUsers(users);
    }
}


