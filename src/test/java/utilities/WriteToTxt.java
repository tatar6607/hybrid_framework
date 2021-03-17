package utilities;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;

public class WriteToTxt {

//    public static void saveDataInFileWithPojo(String fileName, List<Customer> customer) {
//        try {
//            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
//            for (int i = 0; i <customer.size() ; i++) {
//                writer.append(customer.get(i).getFirstName() + " , " + customer.get(i).getLastName() + " , " + customer.get(i).getSsn() + "\n");
//            }
//            writer.close();
//        } catch (Exception e) {
//
//        }
//    }

    public static void saveDataInFileWithJsonListString(String fileName, List<String> json) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            writer.append( json + "\n");

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithJsonListMap(String fileName, List<Map<String,Object>> json) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i <json.size() ; i++) {
                writer.append(json.get(i).get("firstName") + " , " + json.get(i).get("LastName") + " , " + json.get(i).get("email") + "\n");
            }

            writer.close();
        } catch (Exception e) {

        }
    }

    public static void saveDataInFileWithListMapForDB(String fileName, List<Map<String,String>> queryDataListMap) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));

            for (int i = 0; i <queryDataListMap.size() ; i++) {
                writer.append(queryDataListMap.get(i).get("first_name") + " , " + queryDataListMap.get(i).get("last_name") + " , " + queryDataListMap.get(i).get("login") + "\n");
            }

            writer.close();
        } catch (Exception e) {

        }
    }

}
