# Plan de Desarrollo: Sistema de Gestión para Empresa Constructora

## 1. Resumen Ejecutivo

Este documento describe el plan de desarrollo para crear un **Sistema de Gestión para Empresa Constructora** que permita llevar un registro completo de todas las construcciones, incluyendo tipo de construcción, herramientas, trabajadores y maquinaria utilizada.

## 2. Análisis de la Situación Actual

### Código Base Existente
El repositorio actualmente contiene un **Sistema de Punto de Venta (POS)** desarrollado en Java con las siguientes características:
- **Arquitectura**: Modelo-Vista-Controlador (MVC)
- **Interfaz**: Java Swing (aplicación de escritorio)
- **Almacenamiento**: Archivos Excel (.xlsx) usando Apache POI
- **Funcionalidades actuales**:
  - Gestión de productos
  - Control de inventario
  - Sistema de ventas
  - Generación de reportes (PDF y Excel)
  - Alertas de stock bajo
  - Corte de caja

### Decisión de Arquitectura
Dado que el cliente solicita una **página web** pero el código existente es una **aplicación de escritorio en Java Swing**, propongo dos enfoques:

#### **Opción Recomendada: Adaptar la Aplicación Java Swing Existente**
- **Ventajas**:
  - Reutiliza toda la infraestructura existente
  - Menor tiempo de desarrollo
  - Mismo stack tecnológico que el estudiante ya domina
  - No requiere servidor web ni base de datos adicional
  - Fácil despliegue y distribución

#### Opción Alternativa: Desarrollar Nueva Aplicación Web
- **Tecnologías sugeridas**: HTML5, CSS3, JavaScript + Backend (Spring Boot o Node.js)
- **Ventajas**: Accesible desde navegador, multi-usuario
- **Desventajas**: Requiere desarrollo desde cero, mayor complejidad

**RECOMENDACIÓN**: Procederé con la **Opción 1** (adaptar Java Swing) ya que aprovecha el 80% del código existente.

## 3. Tecnologías y Herramientas a Utilizar

### 3.1 Lenguaje de Programación
- **Java SE 8+** (lenguaje principal)
  - Orientado a objetos
  - Robusto y maduro
  - Amplia documentación

### 3.2 Framework de Interfaz Gráfica
- **Java Swing**
  - Componentes visuales profesionales (JFrame, JTable, JPanel, etc.)
  - Personalización completa de colores y estilos
  - Diálogos modales para formularios

### 3.3 Bibliotecas Externas
- **Apache POI** (ya incluida)
  - Lectura/escritura de archivos Excel
  - Gestión de hojas de cálculo, celdas, estilos
  
- **JFreeChart** (ya incluida)
  - Generación de gráficos estadísticos
  - Gráficos de barras, pastel, líneas
  
- **iText / Apache PDFBox** (ya incluida)
  - Generación de reportes PDF profesionales
  - Exportación de datos

### 3.4 Almacenamiento de Datos
- **Archivos Excel (.xlsx)**
  - Fácil de exportar y compartir
  - No requiere instalación de base de datos
  - Compatible con Microsoft Excel y Google Sheets
  - Respaldos simples (copiar archivos)

### 3.5 Arquitectura del Software
- **Patrón MVC (Modelo-Vista-Controlador)**
  ```
  /modelo         → Clases de dominio (Construccion, Herramienta, Trabajador, etc.)
  /vista          → Interfaces gráficas (ventanas y formularios)
  /controlador    → Lógica de negocio y conexión con datos
  /utils          → Utilidades y helpers
  ```

## 4. Modelo de Datos - Sistema Constructora

### 4.1 Entidades Principales

#### A. Construcción
```java
public class Construccion {
    private int id;
    private String nombreProyecto;
    private String tipoConstruccion; // Casa, Edificio, Puente, Carretera, etc.
    private String ubicacion;
    private String cliente;
    private LocalDate fechaInicio;
    private LocalDate fechaFinEstimada;
    private LocalDate fechaFinReal;
    private String estado; // En Planificación, En Progreso, Completado, Suspendido
    private double presupuesto;
    private double costoActual;
    private String descripcion;
    private String responsable; // Ingeniero a cargo
}
```

#### B. Herramienta
```java
public class Herramienta {
    private int id;
    private String nombre;
    private String tipo; // Manual, Eléctrica, Hidráulica, etc.
    private String marca;
    private int cantidad;
    private String estado; // Disponible, En Uso, En Mantenimiento, Dañada
    private String ubicacion;
    private LocalDate fechaAdquisicion;
    private double costoUnitario;
}
```

#### C. AsignacionHerramienta (Relación Construcción-Herramienta)
```java
public class AsignacionHerramienta {
    private int id;
    private int construccionId;
    private int herramientaId;
    private int cantidadAsignada;
    private LocalDate fechaAsignacion;
    private LocalDate fechaDevolucion;
    private String estadoAsignacion; // Asignada, Devuelta, Extraviada
}
```

#### D. Trabajador
```java
public class Trabajador {
    private int id;
    private String nombre;
    private String apellido;
    private String especialidad; // Albañil, Electricista, Plomero, Soldador, etc.
    private String telefono;
    private String direccion;
    private double salarioDiario;
    private String estado; // Activo, Inactivo, Suspendido
    private LocalDate fechaContratacion;
}
```

#### E. AsignacionTrabajador (Relación Construcción-Trabajador)
```java
public class AsignacionTrabajador {
    private int id;
    private int construccionId;
    private int trabajadorId;
    private LocalDate fechaAsignacion;
    private LocalDate fechaFinalizacion;
    private int diasTrabajados;
    private double pagoPendiente;
    private String rol; // Oficial, Ayudante, Supervisor
}
```

#### F. Maquinaria
```java
public class Maquinaria {
    private int id;
    private String nombre;
    private String tipo; // Excavadora, Grúa, Mezcladora, Bulldozer, etc.
    private String modelo;
    private String placas;
    private String estado; // Operativa, En Mantenimiento, Fuera de Servicio
    private double costoPorHora;
    private LocalDate fechaUltimoMantenimiento;
    private int horasUso;
    private String operadorActual;
}
```

#### G. AsignacionMaquinaria (Relación Construcción-Maquinaria)
```java
public class AsignacionMaquinaria {
    private int id;
    private int construccionId;
    private int maquinariaId;
    private LocalDate fechaAsignacion;
    private int horasUtilizadas;
    private double costoTotal;
    private String operador;
}
```

## 5. Funcionalidades del Sistema

### 5.1 Gestión de Construcciones
- ✅ Registrar nueva construcción
- ✅ Editar datos de construcción
- ✅ Ver listado de construcciones (con filtros por estado)
- ✅ Eliminar construcción
- ✅ Ver detalles completos de una construcción
- ✅ Cambiar estado de construcción
- ✅ Calcular progreso y desviación presupuestaria

### 5.2 Gestión de Herramientas
- ✅ Registrar herramientas del inventario
- ✅ Asignar herramientas a construcciones
- ✅ Registrar devoluciones
- ✅ Control de disponibilidad
- ✅ Alertas de mantenimiento
- ✅ Historial de uso por herramienta

### 5.3 Gestión de Trabajadores
- ✅ Registrar trabajadores
- ✅ Asignar trabajadores a construcciones
- ✅ Control de asistencia y días trabajados
- ✅ Cálculo de nómina
- ✅ Historial laboral por trabajador

### 5.4 Gestión de Maquinaria
- ✅ Registrar maquinaria
- ✅ Asignar maquinaria a construcciones
- ✅ Control de horas de uso
- ✅ Programación de mantenimientos
- ✅ Cálculo de costos de operación

### 5.5 Reportes y Análisis
- ✅ Reporte de construcciones activas
- ✅ Reporte de costos por construcción
- ✅ Reporte de recursos utilizados
- ✅ Reporte de trabajadores por proyecto
- ✅ Gráficos de progreso
- ✅ Análisis presupuestario
- ✅ Exportación a Excel
- ✅ Exportación a PDF

### 5.6 Panel de Control (Dashboard)
- ✅ Construcciones activas vs completadas
- ✅ Alertas de presupuesto excedido
- ✅ Maquinaria que requiere mantenimiento
- ✅ Herramientas no devueltas
- ✅ Resumen financiero general

## 6. Funcionalidades Profesionales Adicionales

### 6.1 Sistema de Notificaciones
- **Alertas de presupuesto**: Cuando una construcción exceda el 90% del presupuesto
- **Recordatorios de mantenimiento**: Para maquinaria
- **Herramientas no devueltas**: Alertas automáticas
- **Vencimiento de plazos**: Notificaciones de fechas límite

### 6.2 Sistema de Búsqueda Avanzada
- Búsqueda por múltiples criterios
- Filtros combinados (fecha, estado, tipo, ubicación)
- Búsqueda rápida con autocompletado

### 6.3 Exportación e Importación
- **Exportar** construcciones a Excel/PDF
- **Importar** datos desde plantillas Excel
- **Respaldo automático** de datos

### 6.4 Gráficos Interactivos
- Gráfico de costos vs presupuesto
- Línea de tiempo de construcciones
- Utilización de recursos (gráficos de pastel)
- Productividad por trabajador

### 6.5 Control de Usuarios (Opcional)
- Login con usuario y contraseña
- Perfiles: Administrador, Ingeniero, Supervisor
- Registro de auditoría (quién modificó qué)

### 6.6 Calculadora de Materiales
- Estimación de materiales por tipo de construcción
- Cálculo automático de cemento, arena, grava, etc.
- Base de datos de costos unitarios

### 6.7 Gestión de Proveedores
- Registro de proveedores de materiales
- Historial de compras
- Evaluación de proveedores

### 6.8 Calendario de Proyectos
- Vista de calendario con fechas de construcciones
- Alertas de conflictos de recursos
- Planificación visual

## 7. Diseño de Interfaz de Usuario

### 7.1 Menú Principal
```
╔══════════════════════════════════════════════╗
║   Sistema de Gestión - Empresa Constructora  ║
║                                              ║
║   [Construcciones]    [Herramientas]        ║
║   [Trabajadores]      [Maquinaria]          ║
║   [Reportes]          [Dashboard]           ║
║                                              ║
║   © 2025 Constructora Professional          ║
╚══════════════════════════════════════════════╝
```

### 7.2 Ventana de Gestión de Construcciones
- Tabla con listado de construcciones
- Botones: Nuevo, Editar, Eliminar, Ver Detalles
- Filtros por estado y tipo
- Búsqueda rápida
- Indicadores visuales de estado (colores)

### 7.3 Formulario de Nueva Construcción
- Campos organizados por secciones
- Validación de datos
- Selección de fechas con calendario
- Cálculo automático de duración estimada

### 7.4 Paleta de Colores
- **Primario**: Azul construcción (#2C3E50)
- **Secundario**: Naranja seguridad (#E67E22)
- **Éxito**: Verde (#27AE60)
- **Alerta**: Amarillo (#F39C12)
- **Error**: Rojo (#C0392B)

## 8. Estructura de Archivos Excel

### construcciones.xlsx
```
ID | Nombre | Tipo | Ubicación | Cliente | Fecha Inicio | Fecha Fin Est. | Estado | Presupuesto | Costo Actual | Responsable
```

### herramientas.xlsx
```
ID | Nombre | Tipo | Marca | Cantidad | Estado | Ubicación | Fecha Adquisición | Costo
```

### asignaciones_herramientas.xlsx
```
ID | Construcción ID | Herramienta ID | Cantidad | Fecha Asignación | Fecha Devolución | Estado
```

### trabajadores.xlsx
```
ID | Nombre | Apellido | Especialidad | Teléfono | Salario Diario | Estado | Fecha Contratación
```

### asignaciones_trabajadores.xlsx
```
ID | Construcción ID | Trabajador ID | Fecha Asignación | Días Trabajados | Pago Pendiente | Rol
```

### maquinaria.xlsx
```
ID | Nombre | Tipo | Modelo | Placas | Estado | Costo/Hora | Último Mantenimiento | Horas Uso
```

### asignaciones_maquinaria.xlsx
```
ID | Construcción ID | Maquinaria ID | Fecha Asignación | Horas Utilizadas | Costo Total | Operador
```

## 9. Plan de Implementación

### Fase 1: Preparación y Estructura (Día 1)
- [x] Análisis del código existente
- [ ] Crear modelo de clases (Construccion, Herramienta, etc.)
- [ ] Configurar archivos Excel de datos
- [ ] Crear controladores base

### Fase 2: Módulo de Construcciones (Día 2)
- [ ] Vista de gestión de construcciones
- [ ] Formulario de alta/edición
- [ ] Controlador de construcciones
- [ ] Lectura/escritura en Excel

### Fase 3: Módulo de Recursos (Día 3)
- [ ] Gestión de herramientas
- [ ] Gestión de trabajadores
- [ ] Gestión de maquinaria
- [ ] Sistema de asignaciones

### Fase 4: Reportes y Dashboard (Día 4)
- [ ] Panel de control principal
- [ ] Generación de reportes PDF
- [ ] Gráficos estadísticos
- [ ] Exportación a Excel

### Fase 5: Funcionalidades Profesionales (Día 5)
- [ ] Sistema de notificaciones
- [ ] Búsqueda avanzada
- [ ] Calculadora de materiales
- [ ] Calendario de proyectos

### Fase 6: Pruebas y Refinamiento (Día 6)
- [ ] Pruebas de integración
- [ ] Validación de datos
- [ ] Ajustes de UI/UX
- [ ] Documentación de usuario

## 10. Ventajas de este Enfoque

### 10.1 Reutilización de Código
- 80% del framework ya existe (MVC, Excel, reportes)
- Solo se necesita adaptar el modelo de datos
- Componentes de UI ya probados

### 10.2 Fácil Mantenimiento
- Estructura clara y organizada
- Separación de responsabilidades
- Código documentado

### 10.3 Escalabilidad
- Fácil agregar nuevos módulos
- Posibilidad de migrar a base de datos SQL en el futuro
- Extensible a aplicación web más adelante

### 10.4 Sin Dependencias Complejas
- No requiere servidor web
- No requiere instalación de base de datos
- Funciona en cualquier computadora con Java
- Portable (USB, compartir por carpeta de red)

### 10.5 Interfaz Familiar
- Profesional y moderna
- Consistente con aplicaciones empresariales
- Curva de aprendizaje baja

## 11. Requisitos del Sistema

### Hardware Mínimo
- Procesador: Intel Core i3 o equivalente
- RAM: 4 GB
- Disco: 500 MB espacio libre

### Software
- **Sistema Operativo**: Windows 7+, macOS 10.10+, Linux
- **Java Runtime Environment (JRE)**: Versión 8 o superior
- **Microsoft Excel** (opcional, para abrir archivos .xlsx)

## 12. Entregables

1. **Aplicación ejecutable** (.jar)
2. **Código fuente** completo
3. **Manual de usuario** (PDF)
4. **Manual técnico** para desarrolladores
5. **Plantillas Excel** de ejemplo
6. **Base de datos de prueba** con datos demo

## 13. Conclusión

Este plan propone desarrollar un **Sistema de Gestión para Empresa Constructora** aprovechando la infraestructura existente del sistema de punto de venta. La solución será:

- ✅ **Profesional**: Interfaz moderna y funcional
- ✅ **Completa**: Gestiona todos los aspectos solicitados
- ✅ **Eficiente**: Reutiliza código probado
- ✅ **Escalable**: Fácil de extender
- ✅ **Accesible**: No requiere conocimientos técnicos avanzados

El desarrollo estimado es de **5-6 días** para tener un sistema completamente funcional y profesional.

---

**¿Tienes alguna pregunta o sugerencia sobre este plan? ¿Te gustaría que modifique o agregue algo antes de comenzar con la implementación?**
