package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer; // Este es el import CORRECTO para Swing
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.FillPatternType;
//Para Excel
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.Style;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
//Para PDF
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;

import controlador.ExcelControlador;
import modelo.Producto;

public class ReportesVista extends JFrame {
    private JTabbedPane tabbedPane;
    private javax.swing.Timer timerActualizacion; // Usar javax.swing.Timer en lugar de java.util.Timer
    private ChartPanel chartPanel;


    public ReportesVista() {
        setTitle("Reportes de Ventas");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        // Inicializar el ChartPanel primero
        chartPanel = new ChartPanel(crearGraficaBarrasMejorada());
        chartPanel.setPreferredSize(new Dimension(800, 400));

        initUI();
        iniciarActualizacionAutomatica();

        // Listener para cerrar el timer al cerrar la ventana
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                detenerActualizacion();
            }
        });
    }

    private void detenerActualizacion() {
        if (timerActualizacion != null && timerActualizacion.isRunning()) {
            timerActualizacion.stop();
        }
    }




    @Override
    public void dispose() {
        timerActualizacion.stop();
        super.dispose();
    }

    private void initUI() {
        tabbedPane = new JTabbedPane();

        // Pestaña 1: Gráficos
        JPanel panelGraficos = new JPanel(new BorderLayout());
        tabbedPane.addTab("Gráficos", panelGraficos);
        crearPanelGraficos(panelGraficos);

        // Pestaña 2: Datos
        JPanel panelDatos = new JPanel(new BorderLayout());
        tabbedPane.addTab("Datos", panelDatos);
        crearTablaDatos(panelDatos);

        // Pestaña 3: Exportar
        JPanel panelExportar = new JPanel(new BorderLayout());
        tabbedPane.addTab("Exportar", panelExportar);
        crearPanelExportar(panelExportar);

        add(tabbedPane, BorderLayout.CENTER);
    }





    private JFreeChart crearGraficaBarrasMejorada() {
        try {
            // Configurar paleta de colores profesional
            Color[] colors = generarPaletaColores(20);

            // Obtener datos
            List<Producto> top20 = obtenerTop20Productos(); // Cambiado de Product a Producto

            // Crear dataset
            DefaultCategoryDataset dataset = crearDataset(top20); // Corregido "creanDataset"

            // Crear gráfico
            JFreeChart chart = ChartFactory.createBarChart(
                "TOP 20 - Productos Más Vendidos (" + LocalDate.now().getYear() + ")", // Completado título
                "Productos",
                "Unidades Vendidas",
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false
            );

            // Personalización avanzada
            personalizarGrafico(chart, colors);

            return chart;

        } catch (Exception e) {
            e.printStackTrace(); // Agregado para depuración
            return crearGraficoVacio("Datos no disponibles"); // Corregido "creanGraficoVacio"
        }
    }

    private List<Producto> obtenerTop20Productos() throws Exception {
        return ExcelControlador.leerProductosDesdeExcel().stream()
            .filter(p -> p.getVentas() > 0)
            .sorted(Comparator.comparingInt(Producto::getVentas).reversed())
            .limit(20)
            .collect(Collectors.toList());
    }

    private JFreeChart crearGraficoVacio(String mensaje) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Error", "Datos");

        JFreeChart chart = ChartFactory.createBarChart(
            mensaje, "", "", dataset,
            PlotOrientation.VERTICAL, false, false, false
        );

        CategoryPlot plot = chart.getCategoryPlot();
        plot.getRenderer().setSeriesPaint(0, Color.RED);
        plot.setNoDataMessage("No hay datos disponibles");

        return chart;
    }

    private Color[] generarPaletaColores(int cantidad) {
        Color[] colors = new Color[cantidad];
        float hueStep = 1.0f / cantidad;

        for (int i = 0; i < cantidad; i++) {
            colors[i] = Color.getHSBColor(i * hueStep, 0.9f, 0.9f);
        }

        return colors;
    }


    private DefaultCategoryDataset crearDataset(List<Producto> productos) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        productos.forEach(p ->
            dataset.addValue(p.getVentas(), "Ventas", p.getNombre())
        );
        return dataset;
    }

    private void personalizarGrafico(JFreeChart chart, Color[] colors) {
        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        // Aplicar colores
        for (int i = 0; i < colors.length; i++) {
            renderer.setSeriesPaint(i, colors[i]);
        }

        // Configurar tooltips
        renderer.setDefaultToolTipGenerator(new StandardCategoryToolTipGenerator(
            "<html><b>{1}</b><br>Ventas: <b>{2}</b> unidades</html>",
            new DecimalFormat("#,###")
        ));

        // Otras configuraciones
        plot.setBackgroundPaint(Color.WHITE);
        plot.setRangeGridlinePaint(new Color(220, 220, 220));
        plot.getDomainAxis().setCategoryMargin(0.1);
        plot.getRangeAxis().setUpperMargin(0.1);

        // Mejorar leyenda
        chart.getLegend().setItemFont(new Font("SansSerif", Font.PLAIN, 10));
    }



    private void iniciarActualizacionAutomatica() {
        // Detener timer anterior si existe
        if (timerActualizacion != null && timerActualizacion.isRunning()) {
            timerActualizacion.stop();
        }

        // Crear nuevo timer con actualización más eficiente
        timerActualizacion = new Timer(3000, e -> {
            if (this.isVisible()) { // Solo actualizar si la ventana está visible
                SwingUtilities.invokeLater(() -> {
                    chartPanel.setChart(crearGraficaBarrasMejorada());
                    chartPanel.repaint();
                });
            }
        });
        timerActualizacion.start();
    }


    private void crearPanelGraficos(JPanel panel) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // Obtener datos reales
        Map<String, Integer> ventasProductos = obtenerDatosVentasReales();

        // Llenar el dataset CORRECTAMENTE (nota el uso de "Ventas" como serie)
        ventasProductos.forEach((producto, ventas) ->
            dataset.addValue(ventas, "Ventas", producto)); // "Ventas" es el nombre de la serie

        JFreeChart chart = ChartFactory.createBarChart(
            "Productos Más Vendidos",
            "Producto",
            "Cantidad Vendida",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false
        );

        // Configurar tooltips
        chart.getCategoryPlot().getRenderer().setDefaultToolTipGenerator(
            new StandardCategoryToolTipGenerator(
                "{1}: {2} unidades vendidas",
                new DecimalFormat("0")
            )
        );

        ChartPanel chartPanel = new ChartPanel(chart) {
            @Override
            public void mouseClicked(MouseEvent e) {
                ChartEntity entity = getEntityForPoint(e.getX(), e.getY());
                if (entity instanceof CategoryItemEntity) {
                    CategoryItemEntity item = (CategoryItemEntity) entity;
                    String producto = (String) item.getColumnKey();
                    // Usar la MISMA clave de serie ("Ventas") que usamos al agregar datos
                    Number ventas = dataset.getValue("Ventas", producto); // Cambio clave aquí
                    JOptionPane.showMessageDialog(
                        this,
                        "Producto: " + producto + "\nVentas: " + ventas,
                        "Detalles",
                        JOptionPane.INFORMATION_MESSAGE
                    );
                }
            }
        };

        chartPanel.setPreferredSize(new Dimension(800, 400));
        panel.add(chartPanel, BorderLayout.CENTER);
    }

    private void crearTablaDatos(JPanel panel) {
        DefaultTableModel model = new DefaultTableModel() {
            @Override
            public Class<?> getColumnClass(int column) {
                return column == 0 ? String.class : Integer.class; // Tipo de datos por columna
            }
        };

        String[] columnas = {"Producto", "Ventas", "Stock Actual", "Stock Mínimo"};
        for (String col : columnas) {
            model.addColumn(col);
        }

        try {
            // Cargar datos en segundo plano
            new SwingWorker<Void, Void>() {
                @Override
                protected Void doInBackground() throws Exception {
                    List<Producto> productos = ExcelControlador.leerProductosDesdeExcel();

                    SwingUtilities.invokeLater(() -> {
                        productos.forEach(p -> {
                            model.addRow(new Object[]{
                                p.getNombre(),
                                p.getVentas(),
                                p.getStock(),
                                p.getStockMinimo()
                            });
                        });
                    });
                    return null;
                }

                @Override
                protected void done() {
                    try {
                        get(); // Para capturar excepciones
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(panel,
                            "Error al cargar datos: " + e.getMessage(),
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    }
                }
            }.execute();

            JTable tabla = new JTable(model);
            tabla.setAutoCreateRowSorter(true); // Permitir ordenar por columnas

         // Centrar todo el contenido de la tabla
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

            for (int i = 0; i < tabla.getColumnCount(); i++) {
                tabla.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }

            // Configurar renderer personalizado
            tabla.setDefaultRenderer(Object.class, new StockCellRenderer());

            // Configurar tamaño de columnas
            tabla.getColumnModel().getColumn(0).setPreferredWidth(150); // Producto
            tabla.getColumnModel().getColumn(1).setPreferredWidth(80);  // Ventas
            tabla.getColumnModel().getColumn(2).setPreferredWidth(100); // Stock Actual
            tabla.getColumnModel().getColumn(3).setPreferredWidth(100); // Stock Mínimo

            panel.add(new JScrollPane(tabla), BorderLayout.CENTER);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(panel,
                "Error al inicializar tabla: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }

    // Clase separada para el renderer de celdas
    class StockCellRenderer extends DefaultTableCellRenderer {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {

            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setHorizontalAlignment(SwingConstants.CENTER);

            if (column == 2 || column == 3) { // Columnas de stock
                try {
                    int stock = (Integer) table.getModel().getValueAt(row, 2);
                    int stockMin = (Integer) table.getModel().getValueAt(row, 3);

                    if (stock <= stockMin) {
                        setBackground(new Color(255, 200, 200)); // Rojo claro
                        setForeground(Color.BLACK);
                        setOpaque(true);
                    } else if (stock <= stockMin + 5) { // Stock cercano al mínimo
                        setBackground(new Color(255, 255, 150)); // Amarillo
                        setOpaque(true);
                    } else {
                        setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                        setOpaque(isSelected);
                    }
                } catch (Exception e) {
                    setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
                }
            }
            return this;
        }
    }


    private Map<String, Integer> obtenerDatosVentasReales() {
        try {
            // Validar ruta del archivo
            Path excelPath = Paths.get(ExcelControlador.RUTA_DEFAULT);
            if (!Files.exists(excelPath)) {
                throw new FileNotFoundException("Archivo Excel no encontrado en: " + excelPath);
            }

            // Obtener y validar productos
            List<Producto> productos = ExcelControlador.leerProductosDesdeExcel();
            if (productos == null || productos.isEmpty()) {
                return Collections.emptyMap();
            }

            // Procesar datos
            Map<String, Integer> ventasPorProducto = new LinkedHashMap<>();

            for (Producto p : productos) {
                if (p == null || p.getNombre() == null || p.getNombre().trim().isEmpty()) {
                    continue;
                }

                if (p.getVentas() < 0) {
                    System.err.println("Advertencia: Ventas negativas para " + p.getNombre());
                    continue;
                }

                // Manejo de duplicados
                if (ventasPorProducto.containsKey(p.getNombre())) {
                    System.out.println("Advertencia: Producto duplicado - " + p.getNombre());
                    continue;
                }

                ventasPorProducto.put(p.getNombre(), p.getVentas());
            }

            return ventasPorProducto;

        } catch (Exception e) {
            System.err.println("Error al obtener datos de ventas: " + e.getMessage());
            return Collections.emptyMap(); // Retornar mapa vacío en caso de error
        }
    }



    private void exportarAExcel(ActionEvent e) {
        try {
            // 1. Configurar directorio y nombre de archivo
            File carpetaExcel = new File("data/reportes/reporte_Excel");
            if (!carpetaExcel.exists()) {
                carpetaExcel.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String nombreArchivo = "reporte_ventas_" + timestamp + ".xlsx";
            File archivo = new File(carpetaExcel, nombreArchivo);

            // 2. Crear libro de Excel
            try (Workbook workbook = new XSSFWorkbook()) {
                // 3. Crear hoja para los datos
                Sheet sheetDatos = workbook.createSheet("Datos de Ventas");

                // 4. Obtener datos actualizados
                List<Producto> productos = ExcelControlador.leerProductosDesdeExcel();

                // 5. Agregar encabezados con estilo
                crearEncabezadosConEstilo(workbook, sheetDatos);

                // 6. Llenar con datos
                llenarDatosConEstilo(workbook, sheetDatos, productos);

                // 7. Autoajustar columnas
                autoajustarColumnas(sheetDatos);

                // 8. Agregar gráfica
                agregarGraficaAExcel(workbook, sheetDatos);

                // 9. Guardar archivo
                guardarArchivoExcel(workbook, archivo);

                // 10. Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(this,
                    "Reporte Excel generado exitosamente:\n" + archivo.getAbsolutePath(),
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                "Error al exportar a Excel: " + ex.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }

    // Métodos auxiliares:

    private void crearEncabezadosConEstilo(Workbook workbook, Sheet sheet) {
        // Estilo para encabezados
        CellStyle headerStyle = workbook.createCellStyle();
        org.apache.poi.ss.usermodel.Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerStyle.setFont(headerFont);
        headerStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
      //  headerStyle.setAlignment(HorizontalAlignment.CENTER);
        headerStyle.setBorderBottom(BorderStyle.MEDIUM);
        headerStyle.setBorderTop(BorderStyle.MEDIUM);
        headerStyle.setBorderLeft(BorderStyle.MEDIUM);
        headerStyle.setBorderRight(BorderStyle.MEDIUM);

        // Crear fila de encabezados
        Row headerRow = sheet.createRow(0);
        String[] headers = {"Producto", "Ventas", "Stock Actual", "Stock Mínimo"};

        for (int i = 0; i < headers.length; i++) {
            org.apache.poi.ss.usermodel.Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
            cell.setCellStyle(headerStyle);
        }
    }

    private void llenarDatosConEstilo(Workbook workbook, Sheet sheet, List<Producto> productos) {
        // Estilo para datos
        CellStyle dataStyle = workbook.createCellStyle();
  //      dataStyle.setAlignment(HorizontalAlignment.CENTER);
        dataStyle.setBorderBottom(BorderStyle.THIN);
        dataStyle.setBorderTop(BorderStyle.THIN);
        dataStyle.setBorderLeft(BorderStyle.THIN);
        dataStyle.setBorderRight(BorderStyle.THIN);

        // Estilo para stock bajo
        CellStyle warningStyle = workbook.createCellStyle();
        warningStyle.cloneStyleFrom(dataStyle);
        warningStyle.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
        warningStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 1;
        for (Producto p : productos) {
            Row row = sheet.createRow(rowNum++);

            // Producto
            org.apache.poi.ss.usermodel.Cell cellProducto = row.createCell(0);
            cellProducto.setCellValue(p.getNombre());
            cellProducto.setCellStyle(dataStyle);

            // Ventas
            org.apache.poi.ss.usermodel.Cell cellVentas = row.createCell(1);
            cellVentas.setCellValue(p.getVentas());
            cellVentas.setCellStyle(dataStyle);

            // Stock Actual
            org.apache.poi.ss.usermodel.Cell cellStock = row.createCell(2);
            cellStock.setCellValue(p.getStock());
            cellStock.setCellStyle(dataStyle);

            // Stock Mínimo
            org.apache.poi.ss.usermodel.Cell cellStockMin = row.createCell(3);
            cellStockMin.setCellValue(p.getStockMinimo());

            // Resaltar si stock bajo
            if (p.getStock() <= p.getStockMinimo()) {
                cellStock.setCellStyle(warningStyle);
                cellStockMin.setCellStyle(warningStyle);
            } else {
                cellStockMin.setCellStyle(dataStyle);
            }
        }
    }

    private void autoajustarColumnas(Sheet sheet) {
        for (int i = 0; i < 4; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private void agregarGraficaAExcel(Workbook workbook, Sheet sheet) throws IOException {
        // Crear gráfica actualizada
        JFreeChart chart = crearGraficaBarrasActualizada(ExcelControlador.leerProductosDesdeExcel());

        // Convertir gráfica a imagen
        ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
        ChartUtils.writeChartAsPNG(chartOutputStream, chart, 800, 500);
        byte[] chartImageBytes = chartOutputStream.toByteArray();

        // Agregar imagen al Excel
        int pictureIdx = workbook.addPicture(chartImageBytes, Workbook.PICTURE_TYPE_PNG);
        Drawing<?> drawing = sheet.createDrawingPatriarch();
        CreationHelper helper = workbook.getCreationHelper();
        ClientAnchor anchor = helper.createClientAnchor();

        // Posicionar gráfica debajo de los datos
        anchor.setCol1(0);
        anchor.setRow1(sheet.getLastRowNum() + 3); // 3 filas de espacio

        drawing.createPicture(anchor, pictureIdx);
    }

    private void guardarArchivoExcel(Workbook workbook, File archivo) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(archivo)) {
            workbook.write(fos);
        }
    }




private void crearPanelExportar(JPanel panel) {
        JPanel panelBotones = new JPanel(new GridLayout(3, 1, 10, 10));

        JButton btnExcel = new JButton("Exportar a Excel");
        btnExcel.addActionListener(this::exportarAExcel);

        JButton btnPDF = new JButton("Generar Reporte PDF");
        btnPDF.addActionListener(this::generarPDF);


        panelBotones.add(btnExcel);
        panelBotones.add(btnPDF);


        panel.add(panelBotones, BorderLayout.CENTER);
    }






private void generarPDF(ActionEvent e) {
    try {
        // Obtener datos actualizados
        List<Producto> productos = ExcelControlador.leerProductosDesdeExcel();

        // Mostrar vista previa
        SwingUtilities.invokeLater(() -> {
        	ReporteVistaDiaologo preview = new ReporteVistaDiaologo(this, productos);
            preview.setVisible(true);
        });

        // El resto del código para generar el PDF permanece igual
        File carpetaPDF = new File("data/reportes/reporte_PDF");
        if (!carpetaPDF.exists()) {
            carpetaPDF.mkdirs();
        }

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String nombreArchivo = "reporte_ventas_" + timestamp + ".pdf";
        File archivo = new File(carpetaPDF, nombreArchivo);

        PdfDocument pdfDoc = new PdfDocument(new PdfWriter(archivo));
        Document document = new Document(pdfDoc, PageSize.A4.rotate());

        // Agregar contenido al PDF (como antes)
        Paragraph titulo = new Paragraph("Reporte de Ventas - " + timestamp)
            .setFont(PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD))
            .setFontSize(16)
            .setTextAlignment(TextAlignment.CENTER);
        document.add(titulo);

        agregarGraficaAPDF(document, productos);
        document.add(new Paragraph("\n"));
        agregarTablaAPDF(document, productos);

        document.close();

        JOptionPane.showMessageDialog(this,
            "Reporte PDF generado exitosamente:\n" + archivo.getAbsolutePath(),
            "Éxito",
            JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this,
            "Error al generar PDF: " + ex.getMessage(),
            "Error",
            JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    }
}

	// Método para agregar la gráfica al PDF
	private void agregarGraficaAPDF(Document document, List<Producto> productos) throws IOException {
	    // Crear gráfica actualizada
	    JFreeChart chart = crearGraficaBarrasActualizada(productos);

	    // Convertir gráfica a imagen
	    ByteArrayOutputStream chartOutputStream = new ByteArrayOutputStream();
	    ChartUtils.writeChartAsPNG(chartOutputStream, chart, 800, 500);
	    byte[] chartImageBytes = chartOutputStream.toByteArray();

	    // Agregar imagen al PDF
	    ImageData imageData = ImageDataFactory.create(chartImageBytes);
	    Image chartImage = new Image(imageData)
	        .setAutoScale(true)
	        .setHorizontalAlignment(HorizontalAlignment.CENTER);
	    document.add(chartImage);
	}



	// Método para crear gráfica actualizada
	private JFreeChart crearGraficaBarrasActualizada(List<Producto> productos) {
	    DefaultCategoryDataset dataset = new DefaultCategoryDataset();

	    productos.stream()
	        .sorted(Comparator.comparingInt(Producto::getVentas).reversed())
	        .limit(20) // Mostrar top 20 productos
	        .forEach(p -> dataset.addValue(p.getVentas(), "Ventas", p.getNombre()));

	    JFreeChart chart = ChartFactory.createBarChart(
	        "TOP 20 Productos Más Vendidos",
	        "Productos",
	        "Unidades Vendidas",
	        dataset,
	        PlotOrientation.VERTICAL,
	        true, true, false
	    );

	    // Personalización de la gráfica
	    CategoryPlot plot = chart.getCategoryPlot();
	    plot.setBackgroundPaint(Color.WHITE);
	    plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

	    BarRenderer renderer = (BarRenderer) plot.getRenderer();
	    renderer.setSeriesPaint(0, new Color(79, 129, 189)); // Color azul

	    return chart;
	}

	// Método para agregar tabla al PDF
	private void agregarTablaAPDF(Document document, List<Producto> productos) throws IOException {
	    // Configurar anchos de columnas
	    float[] columnWidths = {3f, 1f, 1f, 1f}; // Producto más ancho que los números

	    Table table = new Table(columnWidths).useAllAvailableWidth();

	    // Fuentes para el documento
	    PdfFont fontNormal = PdfFontFactory.createFont(StandardFonts.HELVETICA);
	    PdfFont fontBold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);

	    // Estilo para celdas
	    Style cellStyle = new Style()
	        .setPadding(5)
	        .setTextAlignment(TextAlignment.CENTER)
	        .setFont(fontNormal);

	    // Estilo para encabezados
	    Style headerStyle = new Style()
	        .setBackgroundColor(new DeviceRgb(70, 130, 180)) // Azul
	        .setFontColor(DeviceRgb.WHITE)
	        .setFont(fontBold)
	        .setTextAlignment(TextAlignment.CENTER);

	    // Agregar encabezados
	    table.addHeaderCell(new Cell().add(new Paragraph("Producto").addStyle(headerStyle)));
	    table.addHeaderCell(new Cell().add(new Paragraph("Ventas").addStyle(headerStyle)));
	    table.addHeaderCell(new Cell().add(new Paragraph("Stock").addStyle(headerStyle)));
	    table.addHeaderCell(new Cell().add(new Paragraph("Stock Mín").addStyle(headerStyle)));

	    // Agregar datos
	    for (Producto p : productos) {
	        table.addCell(new Cell().add(new Paragraph(p.getNombre()).addStyle(cellStyle)));
	        table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getVentas())).addStyle(cellStyle)));
	        table.addCell(new Cell().add(new Paragraph(String.valueOf(p.getStock())).addStyle(cellStyle)));

	        // Resaltar stock mínimo
	        Cell stockMinCell = new Cell().add(new Paragraph(String.valueOf(p.getStockMinimo())).addStyle(cellStyle));
	        if (p.getStock() <= p.getStockMinimo()) {
	            stockMinCell.setBackgroundColor(new DeviceRgb(255, 200, 200)); // Rojo claro
	        }
	        table.addCell(stockMinCell);
	    }

	    document.add(table);
	}

  public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ReportesVista().setVisible(true));
    }
}