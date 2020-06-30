package com.offcn.servlet;

import com.offcn.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet("/PayServlet")
public class PayServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          /*从购物车中取出信息，计算需要支付的总钱数*/

        HttpSession session = request.getSession();

        //从session中取出购物车
        Map<Product,Integer> cart = (Map<Product,Integer>)session.getAttribute("cart");

        /*
        * 循环遍历购物车这个Map. 从key中取出商品的单价，从value中取出商品的数量。
        * 单价*数量 算出某个商品的钱数。再把所有商品的钱数累加在一起
        * */

        double total = 0;  // 总钱数

        Set<Map.Entry<Product,Integer>> set = cart.entrySet();

        for(Map.Entry<Product,Integer> entry:set){
              double money = entry.getKey().getShop_price()*entry.getValue();
              total = total+money;
        }

        request.setAttribute("total",total);
        request.getRequestDispatcher("jsp/pay.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request, response);
    }
}
