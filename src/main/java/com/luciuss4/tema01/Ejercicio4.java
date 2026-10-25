package com.luciuss4.tema01;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("Recursos/pedidos.xml"));
            doc.getDocumentElement().normalize();

            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el id del pedido: ");
            String idPedido = sc.nextLine();

            NodeList pedidos = doc.getElementsByTagName("pedido");
            boolean encontrado = false;

            for (int i = 0; i < pedidos.getLength(); i++) {
                Element pedido = (Element) pedidos.item(i);

                if (pedido.getAttribute("id").equals(idPedido)) {
                    encontrado = true;

                    NodeList items = pedido.getElementsByTagName("item");
                    double totalCalculado = 0;

                    for (int j = 0; j < items.getLength(); j++) {
                        Element item = (Element) items.item(j);

                        String sku = item.getAttribute("sku");
                        String descripcion = item.getElementsByTagName("descripcion").item(0).getTextContent();
                        int cantidad = Integer.parseInt(item.getElementsByTagName("cantidad").item(0).getTextContent());
                        double precio = Double.parseDouble(item.getElementsByTagName("precioUnitario").item(0).getTextContent());

                        System.out.println("SKU: " + sku + " | Descripción: " + descripcion
                                + " | Cantidad: " + cantidad + " | Precio unitario: " + precio);

                        totalCalculado += cantidad * precio;
                    }

                    double totalXml = Double.parseDouble(pedido.getElementsByTagName("total").item(0).getTextContent());

                    System.out.println();
                    System.out.printf("Total del XML: %.2f%n", totalXml);
                    System.out.printf("Total calculado: %.2f%n", totalCalculado);

                    if (Math.abs(totalCalculado - totalXml) < 0.01) {
                        System.out.println("El total coincide");
                    } else {
                        System.out.println("El total NO coincide");
                    }
                }
            }

            if (!encontrado) {
                System.out.println("No existe ningún pedido con id " + idPedido);
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}