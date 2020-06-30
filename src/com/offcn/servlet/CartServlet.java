package com.offcn.servlet;

import com.offcn.bean.Product;
import com.offcn.service.ProductService;
import com.offcn.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String method= request.getParameter("method");
           if("putInCart".equals(method)){
               putInCart(request,response);
           }else if("deleteFromCart".equals(method)){
               deleteFromCart(request,response);
           }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         this.doPost(request,response);
    }

    // 加入商品到购物车
    protected void putInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取购买数量
        String quantity = request.getParameter("quantity");
        //获取购买商品的id
        String proId = request.getParameter("proId");

        /*
        * 购物车操作的思路：
        *    1 先根据商品id查询到要购买的商品
        *    2 把要购买的商品，和该商品的购物数量存入一个Map中
        *    3 把Map存入HttpSession中
        * */

        // 查到要购买的商品
        ProductService service = new ProductServiceImpl();
        Product product = service.getProductById(Integer.parseInt(proId));
/*
        // 要买的商品和数量存入map(购物车)中
        Map<Product,Integer> cart = new HashMap<>();
        cart.put(product,Integer.parseInt(quantity));

        // 把map(购物车)存入session中
        HttpSession session = request.getSession();
        session.setAttribute("cart",cart);

        //跳转到购物车页面
        response.sendRedirect("jsp/cart.jsp");

*/

/*
         // 第一次加商品到购物车时，创建一个购物车(Map)。后面再加商品时，商品要加入到原来的购物车中！
         HttpSession session = request.getSession();
         Map<Product,Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");

         if(cart==null){  // 第一次加商品到购物车中
             cart = new HashMap<>();  //创建出购物车
             cart.put(product,Integer.parseInt(quantity));  // 把商品加入购物车
             session.setAttribute("cart",cart);          // 把购物车加入到session中
         }else{           // 不是第一次来
             cart.put(product,Integer.parseInt(quantity)); // 只需要将商品加入到购物车中
         }

        response.sendRedirect("jsp/cart.jsp");
*/
         HttpSession session = request.getSession();
         Map<Product,Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");

         if(cart==null){  // 第1次来
             cart = new HashMap<>();
             cart.put(product,Integer.parseInt(quantity));
             session.setAttribute("cart",cart);

         }else{  // 不是第一次来
               //要先判断购物车中是否已有该商品。如果没有，把商品加入购物车，若果有，把已有的商品的数量进行更新即可。
               /*
               Integer num = cart.get(product);
               if(num==null){  // 原来的购物车中没有该商品
                    cart.put(product,Integer.parseInt(quantity));
               }else{  //原来的购物车中有该商品
                    int total = num+Integer.parseInt(quantity);
                    cart.put(product,total);
               }
                   用这种判断是否把某个商品加入购物车的方式是不正确的，原因是  cart.get(product)
                   product的值每次是不同的（因为product是对象的地址！）
               */

               // 判断购物车中是否包含正在操作的这个商品
               Set<Product> ks = cart.keySet();

               boolean flag = false; // 假设不包含
               Product pro = null ;  // 作用是，当在购物车中找到了，正在购买的商品时，为了取出已有的数量，需要把引用赋给这个变量，在循环外就可以使用了
               for(Product p:ks){
                     if(p.getPro_id()==product.getPro_id()){  // 说明包含
                          flag = true;
                          pro = p;
                          break;
                     }
               }

               if(flag){  // 购物车已有正在购买的商品

                   int num = cart.get(pro);
                   //cart.put(product,num+Integer.parseInt(quantity));
                   cart.put(pro,num+Integer.parseInt(quantity));

               }else{
                   cart.put(product,Integer.parseInt(quantity));
               }
         }

         response.sendRedirect("jsp/cart.jsp");
    }

    protected void deleteFromCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          String proId = request.getParameter("proId");

          /*
          * 思路：根据获取到的id到session中的购物车（map）中找商品，找到就从map中删除掉
          * */
          HttpSession session = request.getSession();
          Map<Product,Integer> cart = (Map)session.getAttribute("cart");
          Set<Product> ks = cart.keySet();

          for(Product pro:ks){

               if(pro.getPro_id()==Integer.parseInt(proId)){ //在购物车中找到了要删除的商品
                   cart.remove(pro);
                   break;
               }
          }

          response.sendRedirect("jsp/cart.jsp");
    }
}
