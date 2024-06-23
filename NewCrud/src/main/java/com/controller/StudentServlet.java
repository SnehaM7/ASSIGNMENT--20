package com.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.model.Student;

public class StudentServlet extends HttpServlet {
    private SessionFactory sessionFactory;

    @Override
    public void init() {
        // Initialize Hibernate configuration
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "fetch"; // Default action
        }

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            switch (action) {
                case "insert":
                    // Insert Operation
                    String insertStudentId = req.getParameter("studentId");
                    String insertName = req.getParameter("name");
                    String insertEmail = req.getParameter("email");
                    String insertPhone = req.getParameter("phone");
                    String insertAddress = req.getParameter("address");

                    Student newStudent = new Student();
                    newStudent.setStudentId(Integer.parseInt(insertStudentId));
                    newStudent.setName(insertName);
                    newStudent.setEmail(insertEmail);
                    newStudent.setPhone(insertPhone);
                    newStudent.setAddress(insertAddress);

                    session.save(newStudent);
                    break;

                case "update":
                    // Update Operation
                    String updateStudentId = req.getParameter("studentId");
                    String updateName = req.getParameter("name");
                    String updateEmail = req.getParameter("email");
                    String updatePhone = req.getParameter("phone");
                    String updateAddress = req.getParameter("address");

                    Student existingStudent = session.get(Student.class, Integer.parseInt(updateStudentId));
                    if (existingStudent != null) {
                        existingStudent.setName(updateName);
                        existingStudent.setEmail(updateEmail);
                        existingStudent.setPhone(updatePhone);
                        existingStudent.setAddress(updateAddress);
                        session.update(existingStudent);
                    }
                    break;

                case "delete":
                    // Delete Operation
                    String deleteStudentId = req.getParameter("studentId");
                    Student studentToDelete = session.get(Student.class, Integer.parseInt(deleteStudentId));
                    if (studentToDelete != null) {
                        session.delete(studentToDelete);
                    }
                    break;

                case "fetch":
                    // Fetch Operation
                    Query<Student> query = session.createQuery("from Student", Student.class);
                    List<Student> students = query.list();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("students.jsp").forward(req, resp);
                    return; // To avoid commit and redirect

                default:
                    // Unknown action, handle as needed
                    break;
            }

            session.getTransaction().commit();
        }

        // Redirect back to the index.jsp page
        resp.sendRedirect("index.jsp");
    }

    @Override
    public void destroy() {
        // Close the Hibernate session factory
        sessionFactory.close();
    }
}
