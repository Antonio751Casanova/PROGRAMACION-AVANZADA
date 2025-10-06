# 🏗️ Sistema de Gestión para Empresa Constructora

## 📚 Documentación del Proyecto

Este repositorio contiene la planificación y desarrollo de un **Sistema de Gestión Integral para Empresa Constructora** basado en la arquitectura existente de punto de venta.

## 📖 Documentos de Planificación

### 1. 📋 [RESUMEN_EJECUTIVO.md](RESUMEN_EJECUTIVO.md)
**Léeme primero** - Documento ejecutivo conciso que explica:
- ¿Qué vamos a construir?
- Tecnologías a utilizar
- Por qué una aplicación de escritorio en lugar de web
- Funcionalidades principales
- Ventajas competitivas
- Cronograma de desarrollo (6 días)

**Recomendado para:** Clientes, gerentes, tomadores de decisiones

---

### 2. 📘 [PLAN_PROYECTO_CONSTRUCTORA.md](PLAN_PROYECTO_CONSTRUCTORA.md)
Documento técnico completo con todos los detalles:
- Análisis de situación actual
- Decisión de arquitectura
- Modelo de datos (7 entidades)
- Funcionalidades del sistema (6 módulos)
- Funcionalidades profesionales adicionales
- Diseño de interfaz
- Estructura de archivos Excel
- Plan de implementación por fases

**Recomendado para:** Desarrolladores, arquitectos de software, equipo técnico

---

### 3. 🎨 [MOCKUPS_INTERFAZ.md](MOCKUPS_INTERFAZ.md)
Mockups ASCII de todas las pantallas:
- Menú principal
- Gestión de construcciones
- Formularios de registro
- Dashboard ejecutivo
- Gestión de herramientas, trabajadores y maquinaria
- Módulo de reportes
- Paleta de colores y iconografía
- Flujo de navegación

**Recomendado para:** Diseñadores UI/UX, desarrolladores frontend, clientes visuales

---

## 🎯 Objetivo del Sistema

Crear una aplicación de escritorio profesional que permita a empresas constructoras:

✅ **Gestionar proyectos de construcción** completos  
✅ **Controlar recursos**: herramientas, trabajadores, maquinaria  
✅ **Seguimiento financiero**: presupuestos, costos, alertas  
✅ **Generar reportes**: PDF, Excel, gráficos estadísticos  
✅ **Dashboard ejecutivo**: métricas, alertas, análisis  

## 🛠️ Stack Tecnológico

| Componente | Tecnología | Uso |
|------------|------------|-----|
| **Lenguaje** | Java SE 8+ | Desarrollo principal |
| **UI Framework** | Java Swing | Interfaz gráfica de escritorio |
| **Arquitectura** | MVC (Modelo-Vista-Controlador) | Organización del código |
| **Almacenamiento** | Excel (.xlsx) | Base de datos de archivos |
| **Excel API** | Apache POI | Lectura/escritura Excel |
| **Gráficos** | JFreeChart | Visualizaciones estadísticas |
| **PDF** | iText/Apache PDFBox | Generación de reportes |

## 📊 Módulos del Sistema

1. **🏗️ Construcciones** - Gestión de proyectos
2. **🔧 Herramientas** - Control de inventario
3. **👷 Trabajadores** - RRHH y nómina
4. **🚜 Maquinaria** - Equipo pesado y mantenimiento
5. **📊 Reportes** - Exportación PDF/Excel
6. **📈 Dashboard** - Panel de control ejecutivo

## 🚀 Inicio Rápido

### Requisitos
- Java 8 o superior
- Sistema operativo: Windows, macOS o Linux
- 500 MB de espacio en disco

### Ejecución
```bash
java -jar Sistema-Constructora.jar
```

## 📁 Estructura del Proyecto

```
PROGRAMACION-AVANZADA/
├── RESUMEN_EJECUTIVO.md          ← Léeme primero
├── PLAN_PROYECTO_CONSTRUCTORA.md ← Plan técnico completo
├── MOCKUPS_INTERFAZ.md            ← Diseño de pantallas
├── README_CONSTRUCTORA.md         ← Este archivo
│
└── PROGRAMACION AVANZADA/
    └── Proyecto Final/
        ├── modelo/                ← Clases de dominio
        │   ├── Construccion
        │   ├── Herramienta
        │   ├── Trabajador
        │   └── Maquinaria
        │
        ├── vista/                 ← Interfaces gráficas
        │   ├── MenuPrincipal.java
        │   ├── ConstruccionesVista.java
        │   ├── HerramientasVista.java
        │   └── ...
        │
        ├── controlador/           ← Lógica de negocio
        │   ├── ConstruccionControlador
        │   ├── HerramientaControlador
        │   └── ...
        │
        └── data/                  ← Datos Excel
            ├── construcciones.xlsx
            ├── herramientas.xlsx
            ├── trabajadores.xlsx
            └── maquinaria.xlsx
```

## 📅 Cronograma

| Fase | Actividad | Duración | Estado |
|------|-----------|----------|--------|
| 0 | Planificación y diseño | ✅ Completado | ✅ |
| 1 | Modelos de datos | 1 día | ⏳ Pendiente |
| 2 | Módulo Construcciones | 1 día | ⏳ Pendiente |
| 3 | Módulos de Recursos | 1.5 días | ⏳ Pendiente |
| 4 | Reportes y Dashboard | 1 día | ⏳ Pendiente |
| 5 | Funcionalidades extra | 1 día | ⏳ Pendiente |
| 6 | Pruebas y refinamiento | 0.5 días | ⏳ Pendiente |

**Fecha estimada de entrega:** 6 días hábiles

## 🎨 Características de Diseño

### Colores
- 🟦 **Primario**: Azul construcción (#2C3E50)
- 🟧 **Secundario**: Naranja seguridad (#E67E22)
- 🟩 **Éxito**: Verde (#27AE60)
- 🟨 **Alerta**: Amarillo (#F39C12)
- 🟥 **Error**: Rojo (#C0392B)

### Interfaz
- Profesional y moderna
- Intuición para uso empresarial
- Iconografía clara y descriptiva
- Validaciones en tiempo real
- Mensajes de ayuda contextuales

## 💡 Funcionalidades Profesionales

### Básicas
- ✅ CRUD completo de todas las entidades
- ✅ Búsqueda y filtrado avanzado
- ✅ Validación de datos
- ✅ Exportación PDF y Excel

### Avanzadas
- ✅ Sistema de notificaciones inteligentes
- ✅ Gráficos interactivos
- ✅ Dashboard ejecutivo con KPIs
- ✅ Calculadora de materiales
- ✅ Calendario de proyectos
- ✅ Análisis presupuestario
- ✅ Alertas automáticas

### Extras
- ✅ Respaldos automáticos
- ✅ Historial de cambios
- ✅ Exportación de informes personalizados
- ✅ Vista previa antes de exportar

## 📈 Ventajas Clave

1. **Reutilización de código** - 80% del framework ya existe
2. **Sin costos recurrentes** - No requiere hosting ni suscripciones
3. **Datos seguros y privados** - Todo almacenado localmente
4. **Fácil respaldo** - Copiar carpeta de datos
5. **Portable** - Funciona desde USB
6. **Escalable** - Migrable a web en el futuro
7. **Sin dependencias complejas** - No requiere servidor ni DB

## 🔐 Seguridad

- Validación de datos de entrada
- Respaldos automáticos periódicos
- Control de acceso (opcional)
- Auditoría de cambios
- Encriptación de datos sensibles (opcional)

## 📞 Soporte

### Documentación
- Manual de usuario (incluido)
- Manual técnico para desarrolladores
- Guía de instalación
- FAQs

### Contacto
- Issues en GitHub
- Documentación técnica en código
- Comentarios inline

## 🔄 Roadmap Futuro

### Versión 2.0
- [ ] Migración a aplicación web
- [ ] Base de datos SQL
- [ ] Multi-usuario con roles
- [ ] Módulo de proveedores
- [ ] Integración con contabilidad
- [ ] App móvil (Android/iOS)
- [ ] API REST para integraciones

### Versión 1.1 (mejoras incrementales)
- [ ] Importación masiva desde Excel
- [ ] Plantillas de construcción
- [ ] Más tipos de gráficos
- [ ] Cotizaciones automáticas
- [ ] Integración con email

## 📝 Licencia

Este proyecto es desarrollado para propósitos educativos.

## 👥 Contribuidores

- **Antonio Casanova** - Desarrollo principal
- **GitHub Copilot** - Asistencia en planificación

---

## ❓ FAQ - Preguntas Frecuentes

### ¿Por qué Java Swing y no web?

**Respuesta:** Aunque el cliente solicitó una "página web", se recomienda Java Swing porque:
1. Aprovecha 80% del código existente
2. No requiere servidor, hosting ni internet
3. Más rápida y eficiente
4. Sin costos recurrentes
5. Datos seguros localmente
6. Perfecta para empresas pequeñas/medianas

Si más adelante se necesita web, la lógica de negocio se puede migrar fácilmente.

### ¿Puede usarse en múltiples computadoras?

**Sí**, hay dos opciones:
1. **Individual**: Cada computadora tiene su propia copia
2. **Compartida**: Archivos Excel en carpeta de red compartida (requiere configuración)

### ¿Qué pasa con los respaldos?

El sistema puede configurarse para:
- Respaldos automáticos diarios
- Exportación manual cuando se desee
- Los archivos Excel son fáciles de copiar y respaldar

### ¿Es escalable?

**Sí**, el diseño modular permite:
- Agregar nuevos módulos fácilmente
- Migrar a base de datos SQL
- Convertir a aplicación web
- Extender funcionalidades

### ¿Incluye capacitación?

Se incluye:
- Manual de usuario detallado con capturas
- Videos demostrativos (opcional)
- Soporte técnico inicial
- Documentación completa

---

## 🎓 Aprendizajes Técnicos

Este proyecto demuestra:
- ✅ Arquitectura MVC bien estructurada
- ✅ Diseño orientado a objetos
- ✅ Patrones de diseño (Singleton, Observer, Factory)
- ✅ Programación en capas
- ✅ Manejo de archivos y streams
- ✅ Generación de reportes
- ✅ Desarrollo de interfaces gráficas profesionales
- ✅ Gestión de proyectos de software

---

## 🌟 Próximos Pasos

1. **Revisar documentación** - Leer los 3 documentos principales
2. **Aprobar plan** - Confirmar que cumple expectativas
3. **Iniciar desarrollo** - Fase 1: Modelos de datos
4. **Iterar y mejorar** - Retroalimentación continua
5. **Entregar sistema** - Aplicación funcional completa

---

**¿Preguntas? ¿Sugerencias? ¿Listo para comenzar?**

Lee primero: [RESUMEN_EJECUTIVO.md](RESUMEN_EJECUTIVO.md)
