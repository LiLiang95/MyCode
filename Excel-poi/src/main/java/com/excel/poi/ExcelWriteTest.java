package com.excel.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author TanFan
 * @date 2019/3/2 9:54
 */
public class ExcelWriteTest {

    /**
     * HSSFWorkbook:创建扩展名为 .xls的文件
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        //创建一个Excel工作簿
        HSSFWorkbook workbook = new HSSFWorkbook();

        //创建一个sheet：编号为0 sheet0
//        Sheet sheet = workbook.createSheet();
        Sheet sheet = workbook.createSheet("会员统计信息");
        //创建row

        Row row1 = sheet.createRow(0);

        //创建cell
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日登录人数");

        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(999);

        Cell cell21 = row1.createCell(0);
        cell21.setCellValue("统计日期");

        Cell cell22 = row1.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyy-MM-dd"));

        FileOutputStream outputStream;
         outputStream = new FileOutputStream("d:/excel-poi/test-write-03.xls");

        workbook.write(outputStream);

        outputStream.close();



    }


    /**
     * XSSFWorkbook:创建扩展名为 .xlsx的文件
     * @throws IOException
     */
    @Test
    public void test07() throws IOException {
        //创建一个Excel工作簿
        XSSFWorkbook workbook = new XSSFWorkbook();

        //创建一个sheet：编号为0 sheet0
//        Sheet sheet = workbook.createSheet();
        Sheet sheet = workbook.createSheet("会员统计信息");
        //创建row

        Row row1 = sheet.createRow(0);

        //创建cell
        Cell cell11 = row1.createCell(0);
        cell11.setCellValue("今日登录人数");

        Cell cell12 = row1.createCell(1);
        cell12.setCellValue(999);

        Cell cell21 = row1.createCell(0);
        cell21.setCellValue("统计日期");

        Cell cell22 = row1.createCell(1);
        cell22.setCellValue(new DateTime().toString("yyy-MM-dd"));

        FileOutputStream outputStream;
        outputStream = new FileOutputStream("d:/excel-poi/test-write-03.xlsx");

        workbook.write(outputStream);

        outputStream.close();
    }


    /**
     * HSSFWorkbook只能写65535行数据 多了就报OOM 异常
     *
     * @throws IOException
     */
    @Test
    public void testWrite03BigData() throws IOException {

        long begin = System.currentTimeMillis();
        Workbook workbook = new HSSFWorkbook();
      Sheet sheet = workbook.createSheet();


        for (int i = 0; i < 65536; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }

        System.out.println("循环结束。。");

        FileOutputStream outputStream;
        outputStream = new FileOutputStream("d:/excel-poi/test-write-03 BigData.xls");

        workbook.write(outputStream);

        outputStream.close();
        System.out.println("文件创建成功。。");
        long end = System.currentTimeMillis();

        System.out.println("耗时" + (end - begin) / 1000 +"秒");
    }


    /**
     * XSSFWorkbook 能写较大数据，效率低  但耗内存  太多会报OOM错误
     *
     * @throws IOException
     */
    @Test
    public void testWrite07BigData() throws IOException {

        long begin = System.currentTimeMillis();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();


        for (int i = 0; i <= 65536; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }

        System.out.println("循环结束。。");

        FileOutputStream outputStream;
        outputStream = new FileOutputStream("d:/excel-poi/test-write-07BigData.xlsx");

        workbook.write(outputStream);

        outputStream.close();
        System.out.println("文件创建成功。。");
        long end = System.currentTimeMillis();

        System.out.println("耗时" + (end - begin) / 1000 +"秒");
    }


    /**
     *
     * @throws IOException
     */
    @Test
    public void testWrite07BigDataFast() throws IOException {

        long begin = System.currentTimeMillis();
        Workbook workbook = new SXSSFWorkbook(100);
        Sheet sheet = workbook.createSheet();


        for (int i = 0; i <= 655360; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(j);
            }
        }

        System.out.println("循环结束。。");

        FileOutputStream outputStream;
        outputStream = new FileOutputStream("d:/excel-poi/test-write-07BigDataFast.xlsx");

        workbook.write(outputStream);

        outputStream.close();
        System.out.println("文件创建成功。。");
        long end = System.currentTimeMillis();

        //清除临时文件
        ((SXSSFWorkbook)workbook).dispose();

        System.out.println("耗时" + (end - begin) / 1000 +"秒");
    }
}
