package com.luciuss4.tema01;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class Ejercicio2 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Recursos/empleados.xml"));
            doc.getDocumentElement().normalize();

            NodeList nodos = doc.getElementsByTagName("empleado");


            ArrayList<Empleado> empleados = new ArrayList<>();

            for (int i = 0; i < nodos.getLength(); i++) {
                Element e = (Element) nodos.item(i);

                String id = e.getAttribute("id");
                String nombre = e.getElementsByTagName("nombre").item(0).getTextContent();
                String departamento = e.getElementsByTagName("departamento").item(0).getTextContent();
                double salario = Double.parseDouble(e.getElementsByTagName("salario").item(0).getTextContent());
                String fechaAlta = e.getElementsByTagName("fechaAlta").item(0).getTextContent();

                empleados.add(new Empleado(id, nombre, departamento, salario, fechaAlta));
            }


            HashMap<String, Integer> numEmpleados = new HashMap<>();
            HashMap<String, Double> sumaSalarios = new HashMap<>();

            for (Empleado emp : empleados) {
                String dep = emp.getDepartamento();

                if (numEmpleados.containsKey(dep)) {
                    numEmpleados.put(dep, numEmpleados.get(dep) + 1);
                    sumaSalarios.put(dep, sumaSalarios.get(dep) + emp.getSalario());
                } else {
                    numEmpleados.put(dep, 1);
                    sumaSalarios.put(dep, emp.getSalario());
                }
            }


            System.out.printf("%-15s | %-12s | %-13s%n", "Departamento", "Nº empleados", "Salario medio");

            for (String dep : numEmpleados.keySet()) {
                double media = sumaSalarios.get(dep) / numEmpleados.get(dep);
                System.out.printf("%-15s | %-12d | %-13.2f%n", dep, numEmpleados.get(dep), media);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}