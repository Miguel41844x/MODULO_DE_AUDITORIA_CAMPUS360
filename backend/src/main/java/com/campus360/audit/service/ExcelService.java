package com.campus360.audit.service;

import com.campus360.audit.dto.EventoExportDTO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

@Service
public class ExcelService {
	
	private static ExcelService instancia;

    private ExcelService() {
    }

    public static ExcelService getInstancia() {
        if (instancia == null) {
            instancia = new ExcelService();
        }
        return instancia;
    }
	
	/*REFACTOROIZACIÓN - SEPARAR EN MÉTODOS*/
	
	public ByteArrayInputStream exportarBitacora(List<EventoExportDTO> eventos) throws IOException {

	    Workbook workbook = new XSSFWorkbook();
	    Sheet sheet = workbook.createSheet("Bitacora");

	    crearHeader(sheet);
	    llenarDatos(sheet, eventos);
	    ajustarColumnas(sheet);

	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    workbook.write(out);
	    workbook.close();

	    return new ByteArrayInputStream(out.toByteArray());
	}
	
	private void crearHeader(Sheet sheet) {

	    Row header = sheet.createRow(0);

	    header.createCell(0).setCellValue("ID Evento");
	    header.createCell(1).setCellValue("Usuario");
	    header.createCell(2).setCellValue("Rol");
	    header.createCell(3).setCellValue("Entidad");
	    header.createCell(4).setCellValue("Accion");
	    header.createCell(5).setCellValue("Fecha");
	    header.createCell(6).setCellValue("Descripcion");
	}
	
	private void llenarDatos(Sheet sheet, List<EventoExportDTO> eventos) {

	    int rowIdx = 1;

	    for (EventoExportDTO e : eventos) {

	        Row row = sheet.createRow(rowIdx++);

	        row.createCell(0).setCellValue(e.getIdEvento());
	        row.createCell(1).setCellValue(e.getUsuario());
	        row.createCell(2).setCellValue(e.getRol());
	        row.createCell(3).setCellValue(e.getEntidad());
	        row.createCell(4).setCellValue(e.getAccion());
	        row.createCell(5).setCellValue(
	                e.getFecha() != null ? e.getFecha().toString() : ""
	        );
	        row.createCell(6).setCellValue(e.getDescripcion());
	    }
	}
	
	private void ajustarColumnas(Sheet sheet) {

	    for (int i = 0; i < 7; i++) {
	        sheet.autoSizeColumn(i);
	    }
	}
	
}