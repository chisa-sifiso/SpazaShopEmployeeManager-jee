/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.ac.tut.bl.EmployeeFacadeLocal;
import za.ac.tut.models.Employee;

/**
 *
 * @author sifis
 */
public class addEmpServlet extends HttpServlet {
@EJB EmployeeFacadeLocal eml;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        Integer age = Integer.parseInt(request.getParameter("age"));
        String gender = request.getParameter("gender");
        String hiredate = request.getParameter("hiredate");//yyyy-mm-dd
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date hiredatereal =null;
    try {
         hiredatereal = dateFormat.parse(hiredate);
    } catch (ParseException ex) {
        Logger.getLogger(addEmpServlet.class.getName()).log(Level.SEVERE, null, ex);
    }
        Employee emp = new Employee();
        emp.setName(name);emp.setAge(age);emp.setGender(gender);
        emp.setHiredate(hiredatereal);
        
        eml.create(emp);
        request.getRequestDispatcher("outCome.html").forward(request, response);
        
        
    }

  

}
