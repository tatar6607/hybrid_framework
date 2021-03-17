package db_tests;

import org.junit.Test;
import utilities.DatabaseConnector;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Test01 {


    @Test
    public void test01() throws SQLException {

        // employees tablosundan `Nancy' hangi firmalarin urunlerini satmis?
        // ( kullanilacak tablolar: orders,employees,order_dateils,products,suppliers)
        // Nancy nin toplam 29 farkli firmaya satis dogrulayiniz.

        String query = "select distinct suppliers.company_name,first_name \n" +
                "from employees join (orders,order_details,products,suppliers)\n" +
                "on (orders.employee_id=employees.employee_id and orders.order_id=order_details.order_id\n" +
                "and order_details.product_id=products.product_id and products.supplier_id=suppliers.supplier_id)\n" +
                "where first_name='Nancy'";
        System.out.println(DatabaseConnector.getQueryResultWithAListMap(query));


    }
}
