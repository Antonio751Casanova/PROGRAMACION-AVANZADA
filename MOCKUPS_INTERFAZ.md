# Mockups de Interfaz - Sistema de Gestión Constructora

## 1. Menú Principal

```
╔═══════════════════════════════════════════════════════════════════╗
║                                                                   ║
║        🏗️  SISTEMA DE GESTIÓN - EMPRESA CONSTRUCTORA  🏗️         ║
║                                                                   ║
║                      Bienvenido, Usuario                          ║
║                                                                   ║
╠═══════════════════════════════════════════════════════════════════╣
║                                                                   ║
║     ┌─────────────────────┐      ┌─────────────────────┐        ║
║     │                     │      │                     │        ║
║     │   📋 CONSTRUCCIONES │      │   🔧 HERRAMIENTAS   │        ║
║     │                     │      │                     │        ║
║     │  Gestionar Proyectos│      │  Control Inventario │        ║
║     │                     │      │                     │        ║
║     └─────────────────────┘      └─────────────────────┘        ║
║                                                                   ║
║     ┌─────────────────────┐      ┌─────────────────────┐        ║
║     │                     │      │                     │        ║
║     │   👷 TRABAJADORES   │      │   🚜 MAQUINARIA     │        ║
║     │                     │      │                     │        ║
║     │  Personal y Nómina  │      │  Equipo Pesado      │        ║
║     │                     │      │                     │        ║
║     └─────────────────────┘      └─────────────────────┘        ║
║                                                                   ║
║     ┌─────────────────────┐      ┌─────────────────────┐        ║
║     │                     │      │                     │        ║
║     │   📊 REPORTES       │      │   📈 DASHBOARD      │        ║
║     │                     │      │                     │        ║
║     │  Informes y Gráficas│      │  Panel de Control   │        ║
║     │                     │      │                     │        ║
║     └─────────────────────┘      └─────────────────────┘        ║
║                                                                   ║
╠═══════════════════════════════════════════════════════════════════╣
║                                                                   ║
║              © 2025 Sistema Constructora Professional            ║
║                                                                   ║
╚═══════════════════════════════════════════════════════════════════╝
```

## 2. Gestión de Construcciones

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  🏗️  GESTIÓN DE CONSTRUCCIONES                              🔙 Volver    ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  🔍 Buscar: [____________________]  📁 Filtro: [Todas ▾]  🔄 Actualizar  ║
║                                                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ ID │ Nombre Proyecto    │ Tipo    │ Estado      │ Presupuesto │ % │ │
║  ├────┼────────────────────┼─────────┼─────────────┼─────────────┼───┤ │
║  │ 1  │ Casa López         │ Casa    │ ✅ Activo   │ $500,000    │85%│ │
║  │ 2  │ Edificio Central   │ Edificio│ ⚠️  Alerta  │ $2,500,000  │95%│ │
║  │ 3  │ Puente Río Grande  │ Puente  │ 🏗️ Progreso │ $1,200,000  │45%│ │
║  │ 4  │ Carretera Norte    │ Vial    │ ✅ Activo   │ $3,000,000  │30%│ │
║  │ 5  │ Plaza Comercial    │ Comercial│ ⏸️ Pausado │ $4,500,000  │10%│ │
║  │ 6  │ Bodega Industrial  │ Bodega  │ ✅ Activo   │ $800,000    │60%│ │
║  │ 7  │ Centro Deportivo   │ Deportivo│ ✔️ Completado│ $1,500,000 │100%│ │
║  └─────────────────────────────────────────────────────────────────────┘ │
║                                                                           ║
║  ┌────────────┐ ┌────────────┐ ┌────────────┐ ┌────────────────────┐   ║
║  │ ➕ NUEVO   │ │ ✏️ EDITAR  │ │ 🗑️ ELIMINAR│ │ 👁️ VER DETALLES   │   ║
║  └────────────┘ └────────────┘ └────────────┘ └────────────────────┘   ║
║                                                                           ║
║  📊 Total Construcciones: 7  |  Activas: 4  |  Completadas: 1           ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 3. Formulario Nueva Construcción

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  ➕ NUEVA CONSTRUCCIÓN                                                    ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  📋 INFORMACIÓN GENERAL                                                   ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Nombre del Proyecto: [________________________________]              │ ║
║  │                                                                       │ ║
║  │ Tipo: [Casa ▾]                Cliente: [_____________________]       │ ║
║  │                                                                       │ ║
║  │ Ubicación: [_____________________________________________]            │ ║
║  │                                                                       │ ║
║  │ Responsable/Ingeniero: [______________________________]              │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  📅 FECHAS                                                                ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Fecha Inicio: [📅 01/03/2025]    Fecha Fin Est: [📅 01/09/2025]     │ ║
║  │                                                                       │ ║
║  │ Duración Estimada: 6 meses (calculado automáticamente)               │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  💰 PRESUPUESTO                                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Presupuesto Total: $ [_________________] MXN                          │ ║
║  │                                                                       │ ║
║  │ Estado Inicial: [⚪ En Planificación ▾]                              │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  📝 DESCRIPCIÓN                                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ [____________________________________________________________]        │ ║
║  │ [____________________________________________________________]        │ ║
║  │ [____________________________________________________________]        │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║            ┌──────────┐                    ┌──────────┐                  ║
║            │ ✅ GUARDAR│                    │ ❌ CANCELAR│                  ║
║            └──────────┘                    └──────────┘                  ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 4. Vista Detalles de Construcción

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  🏗️  DETALLES: Casa López                              🔙 Volver         ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  📋 INFORMACIÓN                  📊 PROGRESO                              ║
║  ┌─────────────────────────┐    ┌──────────────────────────────────┐    ║
║  │ ID: 001                 │    │  ████████████████░░░░ 85%        │    ║
║  │ Tipo: Casa Residencial  │    │                                  │    ║
║  │ Cliente: Familia López  │    │  Presupuesto: $500,000           │    ║
║  │ Ubicación: Av. Norte #123│   │  Gastado:     $425,000           │    ║
║  │ Estado: ✅ ACTIVO        │    │  Restante:    $75,000            │    ║
║  │ Inicio: 01/03/2025      │    │                                  │    ║
║  │ Fin Est: 01/09/2025     │    │  ⚠️ ALERTA: 85% presupuesto      │    ║
║  └─────────────────────────┘    └──────────────────────────────────┘    ║
║                                                                           ║
║  👷 TRABAJADORES ASIGNADOS (8)                                            ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Nombre          │ Especialidad    │ Días Trabajados │ Salario Diario│ │
║  ├─────────────────┼─────────────────┼─────────────────┼───────────────┤ │
║  │ Juan Pérez      │ Albañil         │ 45              │ $350          │ │
║  │ María García    │ Electricista    │ 30              │ $450          │ │
║  │ Carlos Ruiz     │ Plomero         │ 25              │ $420          │ │
║  │ ...             │ ...             │ ...             │ ...           │ │
║  └─────────────────────────────────────────────────────────────────────┘ │
║                                                                           ║
║  🔧 HERRAMIENTAS ASIGNADAS (15)                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Herramienta     │ Cantidad  │ Asignado el    │ Estado              │ │
║  ├─────────────────┼───────────┼────────────────┼─────────────────────┤ │
║  │ Mezcladora      │ 1         │ 01/03/2025     │ ✅ En uso           │ │
║  │ Taladros        │ 3         │ 05/03/2025     │ ✅ En uso           │ │
║  │ Carretillas     │ 5         │ 01/03/2025     │ ✅ En uso           │ │
║  │ ...             │ ...       │ ...            │ ...                 │ │
║  └─────────────────────────────────────────────────────────────────────┘ │
║                                                                           ║
║  🚜 MAQUINARIA ASIGNADA (2)                                               ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ Máquina         │ Horas Uso │ Costo/Hora │ Total              │     │ │
║  ├─────────────────┼───────────┼────────────┼────────────────────┤     │ │
║  │ Mezcladora      │ 120 hrs   │ $80        │ $9,600             │     │ │
║  │ Grúa            │ 45 hrs    │ $250       │ $11,250            │     │ │
║  └─────────────────────────────────────────────────────────────────────┘ │
║                                                                           ║
║  ┌─────────────────┐ ┌─────────────────┐ ┌──────────────────────────┐  ║
║  │ ✏️ EDITAR       │ │ 📊 GENERAR PDF  │ │ 📈 VER GRÁFICOS          │  ║
║  └─────────────────┘ └─────────────────┘ └──────────────────────────┘  ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 5. Dashboard Principal

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  📈 DASHBOARD - PANEL DE CONTROL                        🔄 Actualizar    ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  📊 RESUMEN GENERAL                                                       ║
║  ┌────────────────┐ ┌────────────────┐ ┌────────────────┐ ┌───────────┐ ║
║  │ 🏗️ PROYECTOS   │ │ 👷 TRABAJADORES│ │ 🔧 HERRAMIENTAS│ │ 🚜 MÁQUINAS│ ║
║  │                │ │                │ │                │ │           │ ║
║  │   Activos: 4   │ │   Activos: 25  │ │  Disponibles:45│ │ Operativas│ ║
║  │   Pausados: 1  │ │   Inactivos: 3 │ │  En Uso: 18    │ │  8 de 10  │ ║
║  │   Completos: 2 │ │                │ │  Dañadas: 2    │ │           │ ║
║  └────────────────┘ └────────────────┘ └────────────────┘ └───────────┘ ║
║                                                                           ║
║  ⚠️  ALERTAS Y NOTIFICACIONES                                             ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ 🔴 URGENTE: Edificio Central excede presupuesto en 5%               │ ║
║  │ 🟡 ATENCIÓN: Mezcladora #3 requiere mantenimiento (vence 5 días)    │ ║
║  │ 🟡 RECORDATORIO: 3 herramientas no devueltas del proyecto Plaza     │ ║
║  │ 🔵 INFO: Proyecto Casa López al 85% de completado                   │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  💰 ANÁLISIS FINANCIERO                                                   ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │                                                                       │ ║
║  │  Presupuesto Total Activo: $9,500,000                                │ ║
║  │  Gastado hasta hoy:        $5,200,000  (54.7%)                       │ ║
║  │  Proyección:               $8,900,000                                │ ║
║  │                                                                       │ ║
║  │  Gráfica:  ████████████████████████░░░░░░░░░░░░░░░░░░░ 54.7%        │ ║
║  │                                                                       │ ║
║  │  Estado: ✅ DENTRO DEL PRESUPUESTO                                   │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  📊 GRÁFICO: CONSTRUCCIONES POR ESTADO                                    ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │                                                                       │ ║
║  │      ██████                                                           │ ║
║  │      ██████  ████                                                     │ ║
║  │      ██████  ████  ██                                                 │ ║
║  │      Activo  Pausa Completo                                           │ ║
║  │        4       1      2                                               │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  🔧 PRÓXIMOS MANTENIMIENTOS                                               ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ • Mezcladora #3 - Vence en 5 días                                    │ ║
║  │ • Grúa #1 - Vence en 12 días                                         │ ║
║  │ • Excavadora #2 - Vence en 20 días                                   │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 6. Gestión de Herramientas

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  🔧 GESTIÓN DE HERRAMIENTAS                             🔙 Volver         ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  🔍 Buscar: [____________________]  Estado: [Todas ▾]  🔄 Actualizar     ║
║                                                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │ ID │ Nombre        │ Tipo      │ Cant │ Estado      │ Ubicación    │ │
║  ├────┼───────────────┼───────────┼──────┼─────────────┼──────────────┤ │
║  │ 1  │ Mezcladora    │ Eléctrica │ 2    │ ✅ Disponible│ Bodega A    │ │
║  │ 2  │ Taladros      │ Manual    │ 10   │ 🔨 En Uso    │ Casa López  │ │
║  │ 3  │ Carretillas   │ Manual    │ 15   │ ✅ Disponible│ Bodega B    │ │
║  │ 4  │ Niveles       │ Manual    │ 8    │ 🔨 En Uso    │ Edificio    │ │
║  │ 5  │ Sierra Circ.  │ Eléctrica │ 3    │ 🔧 Mantenimiento│ Taller   │ │
║  │ 6  │ Martillos     │ Manual    │ 20   │ ✅ Disponible│ Bodega A    │ │
║  │ 7  │ Escaleras     │ Manual    │ 12   │ 🔨 En Uso    │ Plaza Com.  │ │
║  └─────────────────────────────────────────────────────────────────────┘ │
║                                                                           ║
║  ┌────────────┐ ┌────────────┐ ┌────────────┐ ┌─────────────────────┐  ║
║  │ ➕ NUEVA   │ │ ✏️ EDITAR  │ │ 📦 ASIGNAR │ │ 🔄 DEVOLVER         │  ║
║  └────────────┘ └────────────┘ └────────────┘ └─────────────────────┘  ║
║                                                                           ║
║  📊 Estadísticas:  Total: 70  |  Disponibles: 45  |  En Uso: 18         ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 7. Módulo de Reportes

```
╔═══════════════════════════════════════════════════════════════════════════╗
║  📊 GENERADOR DE REPORTES                               🔙 Volver         ║
╠═══════════════════════════════════════════════════════════════════════════╣
║                                                                           ║
║  📋 TIPOS DE REPORTES DISPONIBLES                                         ║
║                                                                           ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │                                                                       │ ║
║  │  🏗️  1. REPORTE DE CONSTRUCCIONES                                    │ ║
║  │      • Estado de todos los proyectos                                 │ ║
║  │      • Análisis de presupuesto vs gastado                            │ ║
║  │      • Proyectos con alertas                                         │ ║
║  │                                                                       │ ║
║  │  💰  2. REPORTE FINANCIERO                                           │ ║
║  │      • Costos totales por proyecto                                   │ ║
║  │      • Desglose de gastos (personal, maquinaria, materiales)         │ ║
║  │      • Proyecciones y tendencias                                     │ ║
║  │                                                                       │ ║
║  │  👷  3. REPORTE DE RECURSOS HUMANOS                                  │ ║
║  │      • Trabajadores por proyecto                                     │ ║
║  │      • Nómina y pagos pendientes                                     │ ║
║  │      • Estadísticas de productividad                                 │ ║
║  │                                                                       │ ║
║  │  🔧  4. REPORTE DE RECURSOS MATERIALES                               │ ║
║  │      • Inventario de herramientas                                    │ ║
║  │      • Estado de maquinaria                                          │ ║
║  │      • Próximos mantenimientos                                       │ ║
║  │                                                                       │ ║
║  │  📈  5. DASHBOARD EJECUTIVO                                          │ ║
║  │      • Visión general del negocio                                    │ ║
║  │      • KPIs y métricas clave                                         │ ║
║  │      • Gráficos y tendencias                                         │ ║
║  │                                                                       │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  📅 PERÍODO                                                               ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │  Desde: [📅 01/01/2025]    Hasta: [📅 31/12/2025]                   │ ║
║  │                                                                       │ ║
║  │  ⚡ Rápido: [Este Mes] [Este Trimestre] [Este Año] [Todo]           │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║  📥 FORMATO DE EXPORTACIÓN                                                ║
║  ┌─────────────────────────────────────────────────────────────────────┐ ║
║  │  [ ] PDF  [ ] Excel  [ ] Vista Previa                               │ ║
║  └─────────────────────────────────────────────────────────────────────┘ ║
║                                                                           ║
║            ┌──────────────────┐                                          ║
║            │ 📊 GENERAR REPORTE│                                          ║
║            └──────────────────┘                                          ║
║                                                                           ║
╚═══════════════════════════════════════════════════════════════════════════╝
```

## 8. Paleta de Colores

```
┌──────────────────────────────────────────────────────────┐
│  COLORES DEL SISTEMA                                     │
├──────────────────────────────────────────────────────────┤
│                                                          │
│  🟦 Primario (Azul Construcción)    #2C3E50             │
│     ████████  Menús, encabezados, botones principales    │
│                                                          │
│  🟧 Secundario (Naranja Seguridad)  #E67E22             │
│     ████████  Botones de acción, alertas de atención    │
│                                                          │
│  🟩 Éxito (Verde)                   #27AE60             │
│     ████████  Estados positivos, confirmaciones         │
│                                                          │
│  🟨 Alerta (Amarillo)               #F39C12             │
│     ████████  Advertencias, precauciones                │
│                                                          │
│  🟥 Error/Urgente (Rojo)            #C0392B             │
│     ████████  Errores, problemas críticos               │
│                                                          │
│  ⬜ Fondo (Blanco/Gris Claro)      #FFFFFF / #F5F5F5    │
│     ████████  Fondos, áreas de contenido                │
│                                                          │
│  ⬛ Texto (Gris Oscuro)             #2C3E50             │
│     ████████  Texto principal, labels                   │
│                                                          │
└──────────────────────────────────────────────────────────┘
```

## 9. Iconografía

```
🏗️  Construcciones / Proyectos
📋  Listados / Formularios
👷  Trabajadores / Personal
🔧  Herramientas
🚜  Maquinaria / Equipo Pesado
📊  Reportes / Análisis
📈  Dashboard / Métricas
💰  Presupuesto / Finanzas
📅  Fechas / Calendario
🔍  Búsqueda
➕  Agregar / Nuevo
✏️  Editar
🗑️  Eliminar
👁️  Ver Detalles
📥  Descargar / Exportar
🔄  Actualizar / Refrescar
⚠️  Alerta / Advertencia
✅  Confirmación / OK
❌  Cancelar / Error
🔙  Regresar / Volver
⚡  Acceso rápido
```

## 10. Flujo de Navegación

```
                    MENÚ PRINCIPAL
                         |
        ┌────────────────┼────────────────┐
        |                |                |
   CONSTRUCCIONES   TRABAJADORES    HERRAMIENTAS
        |                |                |
   ┌────┴────┐      ┌────┴────┐      ┌────┴────┐
   |         |      |         |      |         |
 Nuevo    Editar  Nuevo   Asignar  Nuevo   Asignar
   |         |      |         |      |         |
Detalles  Lista  Lista   Nómina  Lista  Devolución
   |                                   
Reportes ──────────────┐
                       |
              ┌────────┴────────┐
              |                 |
          DASHBOARD         REPORTES
              |                 |
          Gráficos          PDF/Excel
```

---

## Notas Técnicas

### Responsividad
- Ventanas con tamaño mínimo definido
- Componentes que se adaptan al tamaño de la ventana
- Tablas con scroll automático

### Accesibilidad
- Atajos de teclado (Alt+N para Nuevo, Alt+E para Editar, etc.)
- Navegación con Tab entre campos
- Enter para confirmar, Escape para cancelar
- Tooltips informativos

### Validaciones
- Campos obligatorios marcados con *
- Validación en tiempo real
- Mensajes de error descriptivos
- Confirmaciones antes de eliminar

### Rendimiento
- Carga de datos en segundo plano (SwingWorker)
- Paginación en tablas grandes
- Cache de imágenes y datos frecuentes
- Actualización incremental

---

**¿Te gusta el diseño propuesto? ¿Algún cambio o sugerencia?**
