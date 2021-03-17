package utilities;

import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;

public class PdfGenerator {

//    public static void createTableWithPojo(String filePath, List<Users> allUserPojo) {
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            Image img = Image.getInstance("trycatch_banner.png");
//            img.setAlignment(1);
//            img.setWidthPercentage(100f);
//            document.add(img); // ust banner ekle resim
//
//            Font baslikFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Phrase baslik = new Phrase("TRYCATCH TEAM PDF DOCUMENT", baslikFont);
//            Paragraph para = new Paragraph(baslik);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            float[] cellWidth = {1f, 1f, 1f}; // cell width
//            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//            PdfPTable table1 = new PdfPTable(cellWidth);
//            table1.setWidthPercentage(100f); // table with percentage
//            table1.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase userName = new Phrase("FIRST NAME", boldFont);
//            Phrase userLastname = new Phrase("LAST NAME", boldFont);
//            Phrase userRole = new Phrase("USER ROLE", boldFont);
//
//            table1.addCell(userName);    // header 1
//            table1.addCell(userLastname); // header 2
//            table1.addCell(userRole); // header 3
//
//            for (int i = 0; i < allUserPojo.size(); i++) {
//
//                for (String w : allUserPojo.get(i).getAuthorities()) {
//                    table1.addCell(allUserPojo.get(i).getFirstName());
//                    table1.addCell(allUserPojo.get(i).getLastName());
//                    table1.addCell(w);
//                }
//
//            }
//            document.add(table1);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            document.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        System.out.println("Pdf file created");
//    }
//
//
//    public static void createPDFWithLists(String filePath,List<String> allFirstname ,List<String> allLastName,List<String> allRoles) {
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            Image img = Image.getInstance("trycatch_banner.png");
//            img.setAlignment(1);
//            img.setWidthPercentage(100f);
//            document.add(img); // ust banner ekle resim
//
//            Font baslikFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Phrase baslik = new Phrase("USER DATA PDF DOCUMENT", baslikFont);
//            Paragraph para = new Paragraph(baslik);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            float[] cellWidth = {1f, 1f, 1f}; // cell width
//            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//            PdfPTable table1 = new PdfPTable(cellWidth);
//            table1.setWidthPercentage(100f); // table with percentage
//            table1.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase userName = new Phrase("FIRST NAME", boldFont);
//            Phrase userLastname = new Phrase("LAST NAME", boldFont);
//            Phrase userRole = new Phrase("USER ROLE", boldFont);
//
//            table1.addCell(userName);    // header 1
//            table1.addCell(userLastname); // header 2
//            table1.addCell(userRole); // header 3
//
//            for (int i = 0; i < allRoles.size(); i++) {
//
//                table1.addCell(allFirstname.get(i));
//                table1.addCell(allLastName.get(i));
//                table1.addCell(allRoles.get(i));
//            }
//            document.add(table1);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            document.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        System.out.println("Pdf file created");
//    }
//
//
//    public static void createTableWithPojoApplicants(String filePath, List<Customer> allApplicantPojo) {
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            Image img = Image.getInstance("trycatch_banner.png");
//            img.setAlignment(1);
//            img.setWidthPercentage(100f);
//            document.add(img); // ust banner ekle resim
//
//            Font baslikFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Phrase baslik = new Phrase("TRYCATCH TEAM PDF DOCUMENT", baslikFont);
//            Paragraph para = new Paragraph(baslik);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            float[] cellWidthColumnsCount = {0.6f, 0.6f, 1f, 0.7f, 0.7f, 0.7f}; // cell width
//            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//            PdfPTable table1 = new PdfPTable(cellWidthColumnsCount);
//            table1.setWidthPercentage(100); // table with percentage
//            table1.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase userName = new Phrase("FIRST NAME", boldFont);
//            Phrase userLastname = new Phrase("LAST NAME", boldFont);
//            Phrase userEmail = new Phrase("EMAIL", boldFont);
//            Phrase userMobileNum = new Phrase("MOBILE NUMBER", boldFont);
//            Phrase userAdress = new Phrase("ADDRESS", boldFont);
//            Phrase userSSN = new Phrase("SSN", boldFont);
//
//            table1.addCell(userName);    // header 1
//            table1.addCell(userLastname); // header 2
//            table1.addCell(userEmail); // header 3
//            table1.addCell(userMobileNum);    // header 4
//            table1.addCell(userAdress); // header 5
//            table1.addCell(userSSN); // header 6
//
//            for (int i = 0; i < allApplicantPojo.size(); i++) {
//
//                table1.addCell(allApplicantPojo.get(i).getFirstName());
//                table1.addCell(allApplicantPojo.get(i).getLastName());
//                table1.addCell(allApplicantPojo.get(i).getEmail());
//                table1.addCell(allApplicantPojo.get(i).getMobilePhoneNumber());
//                table1.addCell(allApplicantPojo.get(i).getAddress());
//                table1.addCell(allApplicantPojo.get(i).getSsn());
//
//            }
//            document.add(table1);
//
////            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            document.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        System.out.println("Pdf file created");
//    }
//
//    public static void createTableWithListMap(String filePath, List<Map<String, String>> allQueryData) {
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            Image img = Image.getInstance("trycatch_banner.png");
//            img.setAlignment(1);
//            img.setWidthPercentage(100f);
//            document.add(img); // ust banner ekle resim
//
//            Font baslikFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Phrase baslik = new Phrase("TRYCATCH TEAM PDF DOCUMENT", baslikFont);
//            Paragraph para = new Paragraph(baslik);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            float[] cellWidth = {1f, 1f, 1f}; // cell width
//            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//            PdfPTable table1 = new PdfPTable(cellWidth);
//            table1.setWidthPercentage(100f); // table with percentage
//            table1.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase userName = new Phrase("FIRST NAME", boldFont);
//            Phrase userLastname = new Phrase("LAST NAME", boldFont);
//            Phrase userRole = new Phrase("USER ROLE", boldFont);
//
//            table1.addCell(userName);    // header 1
//            table1.addCell(userLastname); // header 2
//            table1.addCell(userRole); // header 3
//
//            for (int i = 0; i < allQueryData.size(); i++) {
//                table1.addCell(allQueryData.get(i).get("first_name"));
//                table1.addCell(allQueryData.get(i).get("last_name"));
//                table1.addCell(allQueryData.get(i).get("authority_name"));
//            }
//            document.add(table1);
//
////            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            document.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        System.out.println("Pdf file created");
//    }
//
//
//    public static void createTableWithListMapDB(String filePath, List<Map<String, String>> allQueryData, List<Map<String, String>> count) {
//
//        try {
//            Document document = new Document();
//            PdfWriter.getInstance(document, new FileOutputStream(filePath));
//            document.open();
//
//            Image img = Image.getInstance("trycatch_banner.png");
//            img.setAlignment(1);
//            img.setWidthPercentage(100f);
//            document.add(img); // ust banner ekle resim
//
//            Font baslikFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
//            Phrase baslik = new Phrase("TRYCATCH TEAM PDF DOCUMENT", baslikFont); // PDF header
//            Paragraph para = new Paragraph(baslik);
//            para.setAlignment(Element.ALIGN_CENTER);
//            document.add(para);
//
//            Phrase date = new Phrase(DateUtil.todaysDate()); // PDF Date
//            Paragraph datePara = new Paragraph(date);
//            datePara.setAlignment(Element.ALIGN_RIGHT);
//            datePara.setSpacingAfter(10); // Date bottom space
//            document.add(datePara);
//
////            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            float[] cellWidth = {0.5f, 0.5f, 1.05f, 0.7f, 0.75f}; // cell width
//            Font boldFont = new Font(Font.FontFamily.HELVETICA, 11, Font.BOLD);
//
//            PdfPTable tableCount = new PdfPTable(cellWidth);
//            tableCount.setWidthPercentage(100f); // table with percentage
//            tableCount.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase admin = new Phrase(" ADMIN", boldFont);
//            Phrase employee = new Phrase("EMPLOYEE", boldFont);
//            Phrase customer = new Phrase("CUSTOMER", boldFont);
//            Phrase user = new Phrase("USER", boldFont);
//            Phrase manager = new Phrase("MANAGER", boldFont);
//
//            tableCount.addCell(admin);    // header 1
//            tableCount.addCell(employee); // header 2
//            tableCount.addCell(customer); // header 3
//            tableCount.addCell(user); // header 4
//            tableCount.addCell(manager); // header 5
//
//            for (int i = 0; i <count.size() ; i++) {
//                tableCount.addCell(count.get(i).get("role_count"));
//            }
//
//            document.add(tableCount); // first table finished here
//
//            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            PdfPTable table1 = new PdfPTable(cellWidth);
//            table1.setWidthPercentage(100f); // table with percentage
//            table1.setHorizontalAlignment(Element.ALIGN_LEFT);// alignment
//
//            Phrase userName = new Phrase("FIRST NAME", boldFont);
//            Phrase userLastname = new Phrase("LAST NAME", boldFont);
//            Phrase email = new Phrase("EMAIL", boldFont);
//            Phrase loginName = new Phrase("USER NAME", boldFont);
//            Phrase userRole = new Phrase("USER ROLE", boldFont);
//
//            table1.addCell(userName);    // header 1
//            table1.addCell(userLastname); // header 2
//            table1.addCell(email); // header 2
//            table1.addCell(loginName); // header 3
//            table1.addCell(userRole); // header 3
//
//            for (int i = 0; i < allQueryData.size(); i++) {
//                table1.addCell(allQueryData.get(i).get("first_name"));
//                table1.addCell(allQueryData.get(i).get("last_name"));
//                table1.addCell(allQueryData.get(i).get("email"));
//                table1.addCell(allQueryData.get(i).get("login"));
//                table1.addCell(allQueryData.get(i).get("authority_name"));
//            }
//            document.add(table1);
//
////            document.add(new Paragraph(" ")); // bir satir bos birak
//
//            document.close();
//        } catch (Exception e) {
//            System.err.println(e);
//        }
//        System.out.println("Pdf file created");
//    }

}
