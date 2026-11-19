# Diseño de Interfaz de Usuario (Jetpack Compose - Material 3)

Este documento detalla el diseño de interfaz de usuario para la aplicación de la tienda de artículos deportivos, utilizando Jetpack Compose con los componentes de **Material 3**. La aplicación cuenta con dos pantallas principales ("Productos" y "Clientes") conectadas mediante una barra de navegación inferior (`NavigationBar`).

---

## 1. Estructura General y Navegación

La aplicación utiliza un contenedor principal `Scaffold` que aloja un `NavHost` para la gestión de pantallas y una `NavigationBar` en la parte inferior para alternar entre la pantalla de **Productos** y la pantalla de **Clientes**.

### Boceto ASCII de la Estructura General con Navegación Inferior

```
+--------------------------------------------------+
|                    TopAppBar                     |
|         [ Catálogo de Productos / Clientes ]     |
+--------------------------------------------------+
|                                                  |
|                                                  |
|                   [ NAVHOST ]                    |
|             (Contenido de la Pantalla)           |
|                                                  |
|                                                  |
+--------------------------------------------------+
|                  NavigationBar                   |
|  [ (i) Productos ]        [ (u) Clientes ]       |
+--------------------------------------------------+
```

### Componentes de Navegación (Material 3 / Compose)

| Componente Compose | Función / Propósito |
| :--- | :--- |
| `rememberNavController()` | Administra la pila de navegación y el estado entre pantallas. |
| `Scaffold` | Estructura base que integra la `TopAppBar`, el contenido central y la `NavigationBar`. |
| `NavHost` | Contenedor que conmuta las pantallas según la ruta seleccionada (`"productos"` o `"clientes"`). |
| `NavigationBar` | Contenedor de Material 3 para la barra de navegación inferior. |
| `NavigationBarItem` | Opción individual dentro de la barra de navegación (icono, etiqueta y estado de selección). |
| `Icon` | Muestra el icono representativo de cada sección (`Icons.Default.ShoppingCart` y `Icons.Default.Person`). |
| `Text` | Etiqueta de texto debajo del icono en el botón de navegación. |

---

## 2. Pantalla "Productos"

Esta pantalla muestra el catálogo completo de productos disponibles (Calzado y Ropa) consumidos desde el `ProductoRepositorio`.

### Boceto ASCII del Layout (Pantalla "Productos")

```
+--------------------------------------------------+
| Catálogo de Productos                            |
+--------------------------------------------------+
| +----------------------------------------------+ |
| | [ Card - Calzado ]                           | |
| | Zapatillas Running Nike Air                  | |
| | Calzado: Zapatillas Running... Talla: 42...  | |
| | Precio: $120.0             Stock: 15 ud.     | |
| +----------------------------------------------+ |
| +----------------------------------------------+ |
| | [ Card - Ropa ]                              | |
| | Camiseta Fútbol Real Madrid                  | |
| | Ropa: Camiseta Fútbol... Deporte: Fútbol... | |
| | Precio: $85.0              Stock: 20 ud.     | |
| +----------------------------------------------+ |
| +----------------------------------------------+ |
| | [ Card - Calzado ]                           | |
| | Tenis Baloncesto Adidas Pro                  | |
| | ...                                          | |
| +----------------------------------------------+ |
+--------------------------------------------------+
|  [*] Productos            [ ] Clientes           |
+--------------------------------------------------+
```

### Componentes de Jetpack Compose (Material 3) - Pantalla Productos

| Componente Compose | Función / Propósito |
| :--- | :--- |
| `Scaffold` | Proporciona el marco básico con la `TopAppBar` superior y la barra inferior. |
| `TopAppBar` | Barra de título superior con el texto "Catálogo de Productos". |
| `LazyColumn` | Lista de desplazamiento vertical optimizada para renderizar los productos. |
| `Card` (`ElevatedCard` / `OutlinedCard`) | Tarjeta de contenedor para cada elemento del producto con elevación y bordes de Material 3. |
| `Column` | Disposición vertical de los datos dentro de la tarjeta del producto. |
| `Row` | Disposición horizontal para mostrar precio y stock alineados en los extremos. |
| `Text` | Renderiza el nombre, la descripción extendida, el precio y el stock con tipografía Material 3 (`titleMedium`, `bodyMedium`, `labelLarge`). |
| `Badge` / `AssistChip` | (Opcional) Indicador visual del tipo de producto o disponibilidad de stock. |

### Origen de Datos del Modelo (`Producto`)

| Dato Mostrado | Propiedad / Método Origen | Clase del Modelo |
| :--- | :--- | :--- |
| Nombre del Producto | `nombre: String` | `Producto` (vía `Calzado` o `Ropa`) |
| Descripción Extendida | `getDescripcion(): String` | `Producto` (Sobrescrito en `Calzado` y `Ropa`) |
| Precio | `precio: Double` | `Producto` |
| Stock Disponible | `stock: Int` | `Producto` |
| Talla (Calzado) | `talla: Int` | `Calzado` |
| Talla (Ropa) | `talla: String` | `Ropa` |
| Deporte (Ropa) | `deporte: String` | `Ropa` |

---

## 3. Pantalla "Clientes"

Esta pantalla muestra la lista de clientes registrados consumidos desde el `ClienteRepositorio`.

### Boceto ASCII del Layout (Pantalla "Clientes")

```
+--------------------------------------------------+
| Lista de Clientes                                |
+--------------------------------------------------+
| +----------------------------------------------+ |
| | [ Card - Cliente ]                           | |
| | (👤) Juan Pérez                              | |
| |      Teléfono: 555-0101                      | |
| +----------------------------------------------+ |
| +----------------------------------------------+ |
| | [ Card - Cliente ]                           | |
| | (👤) María Gómez                             | |
| |      Teléfono: 555-0102                      | |
| +----------------------------------------------+ |
| +----------------------------------------------+ |
| | [ Card - Cliente ]                           | |
| | (👤) Carlos López                            | |
| |      Teléfono: 555-0103                      | |
| +----------------------------------------------+ |
+--------------------------------------------------+
|  [ ] Productos            [*] Clientes           |
+--------------------------------------------------+
```

### Componentes de Jetpack Compose (Material 3) - Pantalla Clientes

| Componente Compose | Función / Propósito |
| :--- | :--- |
| `Scaffold` | Estructura base para contener la `TopAppBar` y el listado de clientes. |
| `TopAppBar` | Barra de título superior con el texto "Lista de Clientes". |
| `LazyColumn` | Lista de desplazamiento vertical optimizada para presentar los clientes. |
| `Card` (`OutlinedCard` / `ElevatedCard`) | Tarjeta de contenedor para la información de cada cliente. |
| `Row` | Disposición horizontal para colocar un avatar/icono al lado de los datos del cliente. |
| `Column` | Disposición vertical interna para el nombre y número telefónico. |
| `Icon` | Icono representativo de usuario (`Icons.Default.Person` o `Icons.Default.AccountCircle`). |
| `Text` | Renderiza el nombre y teléfono del cliente con estilos de texto Material 3 (`titleMedium`, `bodyMedium`). |

### Origen de Datos del Modelo (`Cliente`)

| Dato Mostrado | Propiedad Origen | Clase del Modelo |
| :--- | :--- | :--- |
| Identificador | `id: Int` | `Cliente` |
| Nombre Completo | `nombre: String` | `Cliente` |
| Número de Teléfono | `telefono: String` | `Cliente` |
