package com.lvs.Language;

import java.util.HashMap;
import java.util.Map;

public class LanguageSpanish {
    private static Map<String, String> spanish = new HashMap<>();

    static {
        // Other
        spanish.put("invalidInput", "¡Entrada no válida!");

        // Language
        spanish.put("language", "Idioma");
        spanish.put("english", "Inglés");
        spanish.put("german", "Alemán");
        spanish.put("spanish", "Español");
        spanish.put("chooseLanguage", "Elige idioma");

        // Main Menu
        spanish.put("mainMenu", "Menú principal");
        spanish.put("exit", "Salir");
        spanish.put("back", "Atrás");

        // Supplier
        spanish.put("suppliers", "Proveedores");
        spanish.put("supplier", "Proveedor");
        spanish.put("addSupplier", "Agregar proveedor");
        spanish.put("removeSupplier", "Eliminar proveedor");
        spanish.put("showSuppliers", "Mostrar proveedores");

        // Customer
        spanish.put("customers", "Clientes");
        spanish.put("customer", "Cliente");
        spanish.put("addCustomer", "Agregar cliente");
        spanish.put("removeCustomer", "Eliminar cliente");
        spanish.put("showCustomers", "Mostrar clientes");
        spanish.put("customerType", "Seleccionar tipo de cliente");
        spanish.put("branchCustomer", "Cliente de sucursal");
        spanish.put("businessCustomer", "Cliente de negocios");
        spanish.put("privateCustomer", "Cliente privado");
        spanish.put("contactPerson", "Persona de contacto");
        spanish.put("customerName", "Nombre");
        spanish.put("customerAddress", "Dirección");
        spanish.put("businessName", "Nombre de la empresa");
        spanish.put("filialNr", "Número de sucursal");

        // Orders
        spanish.put("orders", "Pedidos");
        spanish.put("addOrder", "Agregar pedido");
        spanish.put("showOrders", "Mostrar pedidos");
        spanish.put("findOrder", "Buscar pedido");
        spanish.put("findOrderText", "Buscar pedido por:");
        spanish.put("searchParty", "Ingrese el nombre del cliente o proveedor:");
        spanish.put("searchProduct", "Ingrese el nombre del producto:");
        spanish.put("buyOrSell", "¿Comprar o vender? (k/v)");
        spanish.put("noProductAdded", "¡Debe agregar al menos un producto al pedido!");
        spanish.put("orderError", "¡No se pudo crear el pedido!");
        spanish.put("addProductToOrder", "¿Agregar producto? (j/n)");
        spanish.put("chooseCustomer", "Ingrese el nombre del cliente, el nombre de la empresa o el número de sucursal:");
        spanish.put("chooseSupplier", "Ingrese el nombre del proveedor:");
        spanish.put("customerError", "¡No se pudo encontrar al cliente!");
        spanish.put("supplierError", "¡No se pudo encontrar al proveedor!");

        // Reports
        spanish.put("reports", "Informes");
        spanish.put("showReports", "Mostrar informes");
        spanish.put("overallReport", "Informe general");
        spanish.put("productReport", "Informe de producto");
        spanish.put("revenueReport", "Informe de ingresos");

        // Products & Inventory
        spanish.put("inventory", "Inventario");
        spanish.put("showInventory", "Mostrar inventario");
        spanish.put("stock", "Stock");
        spanish.put("products", "Productos");
        spanish.put("product", "Producto");
        spanish.put("productName", "Nombre");
        spanish.put("productPrice", "Precio");
        spanish.put("productQuantity", "Cantidad");
        spanish.put("addProduct", "Agregar producto");
        spanish.put("removeProduct", "Eliminar producto");
        spanish.put("editProduct", "Editar producto");
        spanish.put("removeAmount", "Ingrese la cantidad o 'x' para todos:");
        spanish.put("showProducts", "Mostrar productos");
        spanish.put("newProductName", "Ingrese el nuevo nombre del producto:");
        spanish.put("newProductPrice", "Ingrese el nuevo precio del producto:");
        spanish.put("newProductQuantity", "Ingrese la nueva cantidad del producto:");
    }

    public static Map<String, String> getLanguage() {
        return spanish;
    }
}