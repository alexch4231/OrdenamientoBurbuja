/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexc
 */
@WebServlet(urlPatterns = {"/BubbleSortServlet"})
public class BubbleSortServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Obtener los números a ordenar desde los parámetros de la solicitud
        String numbersParam = request.getParameter("numbers");

        if (numbersParam != null && !numbersParam.isEmpty()) {
            String[] numberStrings = numbersParam.split(",");
            int[] numbers = new int[numberStrings.length];

            for (int i = 0; i < numberStrings.length; i++) {
                numbers[i] = Integer.parseInt(numberStrings[i]);
            }

            // Ordenar el arreglo utilizando el algoritmo de ordenamiento burbuja
            bubbleSort(numbers);

            // Enviar la respuesta ordenada al cliente
            PrintWriter out = response.getWriter();
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del ordenamiento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Arreglo ordenado:</h1>");
            out.println("<ul>");
            for (int num : numbers) {
                out.println("<li>" + num + "</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        } else {
            response.getWriter().println("No se proporcionaron números para ordenar.");
        }
    }

    private void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "BubbleSortServlet";
    }
}