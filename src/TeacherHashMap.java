import util.DateTimeUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class TeacherHashMap {
    public static void main(String[] args) {
        List<Teacher> list;
        {
            list = new ArrayList<>();
            list.add(new Teacher("GV001","Nguyễn Tuân","06-05-2019",1));
            list.add(new Teacher("GV002","Ðặng Kim Thi","06-05-2019",2));
            list.add(new Teacher("GV001","Nguyễn Tuân","07-05-2019",2));
            list.add(new Teacher("GV003","Quang Hoà","07-05-2019",2));
            list.add(new Teacher("GV004","Văn Thuận","07-05-2019",1));
            list.add(new Teacher("GV005","Hồng Luyến","08-05-2019",5));
            list.add(new Teacher("GV002","Ðặng Kim Thi","08-05-2019",1));
            list.add(new Teacher("GV002","Ðặng Kim Thi","09-05-2019",1));
            list.add(new Teacher("GV005","Hồng Luyến","09-05-2019",5));
            list.add(new Teacher("GV001","Nguyễn Tuân","10-05-2019",1));
            list.add(new Teacher("GV003","Quang Hoà","10-05-2019",1));
            list.add(new Teacher("GV004","Văn Thuận","11-05-2019",1));
        }
        List<Teacher> listTop = new ArrayList<>();

        File f = new File("test.txt");
        System.out.println("Dữ liệu đầu vào");
        writeFile("Dữ liệu đầu vào \n",f);
        System.out.printf("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
                "","Mã giảng viên", "",
                "","Tên Giảng viên", "",
                "","Ngày", "",
                "","Số lượng bánh ngọt", "");
        writeFile(String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
                "","Mã giảng viên", "",
                "","Tên Giảng viên", "",
                "","Ngày", "",
                "","Số lượng bánh ngọt", ""),f);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
                    "",list.get(i).getRollNumber(), "",
                    "",list.get(i).getName(), "",
                    "", DateTimeUtil.formatDateToString(list.get(i).getDayEat()), "",
                    "",list.get(i).getNumber(), "");
            writeFile(String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
                    "",list.get(i).getRollNumber(), "",
                    "",list.get(i).getName(), "",
                    "", DateTimeUtil.formatDateToString(list.get(i).getDayEat()), "",
                    "",list.get(i).getNumber(), ""),f);
        }
        System.out.println("....................................... \n");
        writeFile("....................................... \n",f);

        checkDuplicate(list);
        checkQuantity(list);
        checkDayEat(list);

        System.out.println("Top giảng viên đang có nguy cơ béo");
        writeFile("Top giảng viên đang có nguy cơ béo \n",f);
        System.out.printf("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s \n",
                "","Mã giảng viên", "",
                "","Tên Giảng viên", "",
                "","Số lượng bánh ngọt", "");
        writeFile(String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s \n",
                "","Mã giảng viên", "",
                "","Tên Giảng viên", "",
                "","Số lượng bánh ngọt", ""),f);
        for (int i = 0; i < 3; i++) {
            listTop.add(list.get(i));
        }

        Map <Integer, Teacher> teacherMap = listConvertHashMap(listTop);

        for (Map.Entry<Integer, Teacher> entry:
                teacherMap.entrySet()){
            System.out.println(entry.getValue().toString());
            writeFile(entry.getValue().toString(),f);
            writeFile("\n",f);
        }
//////////////////////////////////
//        try {
//            FileWriter fileWriter = new FileWriter("test.txt",true);
//            fileWriter.write("Dữ liệu đầu vào \n");
//            fileWriter.write(String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
//                    "","Mã giảng viên", "",
//                    "","Tên Giảng viên", "",
//                    "","Ngày", "",
//                    "","Số lượng bánh ngọt", ""));
//
//            for (int i = 0; i < list.size(); i++) {
//                fileWriter.write(String.format("%5s%20s%5s | %1s%21s%14s | %8s%10s%8s | %8s%10s%8s \n",
//                        "",list.get(i).getRollNumber(), "",
//                        "",list.get(i).getName(), "",
//                        "", DateTimeUtil.formatDateToString(list.get(i).getDayEat()), "",
//                        "",list.get(i).getNumber(), ""));
//            }
//            fileWriter.write("....................................... \n");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        for (Teacher s : listSet){
//            System.out.println(s);
//        }

//        for (int i = 0; i < listSet.size(); i++) {
//            Teacher teacherI = listSet.get(i);
//            for (int j = i+1; j < listSet.size(); j++) {
//                Teacher teacherJ = listSet.get(j);
//                if (teacherI.getRollNumber().equalsIgnoreCase(teacherJ.getRollNumber())){
//                    System.out.println(teacherJ.getRollNumber());
//                }
//            }
//            System.out.println(teacherI.getRollNumber());
//        }

//        Map <String, Teacher> teacherMap = new HashMap<>();
//        teacherMap.put("GV001", new Teacher("GV001","Nguyễn Tuân","06-05-2019",1));
//        teacherMap.put("GV002", new Teacher("GV002","Ðặng Kim Thi","06-05-2019",2));
//        teacherMap.put("GV001", new Teacher("GV001","Nguyễn Tuân","07-05-2019",2));
//        teacherMap.put("GV004", new Teacher("GV004","Văn Thuận","07-05-2019",1));
//        teacherMap.put("GV005", new Teacher("GV005","Hồng Luyến","08-05-2019",5));
//        teacherMap.put("GV002", new Teacher("GV002","Ðặng Kim Thi","08-05-2019",1));
//        for (Map.Entry<String, Teacher> entry:
//            teacherMap.entrySet()){
////            System.out.println(entry.getValue().getRollNumber());
////            System.out.println(entry.getValue().getNumber());
//            Teacher newTeacher = new Teacher();
//            if (teacherMap.containsKey(newTeacher.getRollNumber())) {
//                Teacher teacherDuplicate = teacherMap.get(newTeacher.getRollNumber());
//                teacherDuplicate.setNumber(teacherDuplicate.getNumber() + newTeacher.getNumber());
//            } else {
//                teacherMap.put(newTeacher.getRollNumber(), newTeacher);
//            }
//            System.out.println(entry.getValue().toString());
//        }


//        System.out.println("..................................");
//        System.out.println(teacherMap.containsKey(1));
//        teacherMap.getOrDefault(1,new Teacher());

    }

    private static void checkDayEat(List<Teacher> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).getNumber() == list.get(j).getNumber()){ // nếu trùng tổng số bánh thì người ăn gần đây nhất lên đầu
                    if (list.get(i).getDayEat().compareTo(list.get(j).getDayEat()) < 0){ // ngày i trước ngày j sơm nhất lên đầu
                        Teacher convertTeacher = new Teacher();
                        convertTeacher = list.get(j);
                        list.set(j,list.get(i));
                        list.set(i,convertTeacher);
                    }
                }
            }
        }
    }

    private static void checkQuantity(List<Teacher> list) {
        // ăn nhiều nhất lên đầu
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).getNumber() < list.get(j).getNumber()){
                    Teacher convertTeacher = new Teacher();
                    convertTeacher = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,convertTeacher);
                }
            }
        }
    }

    private static void checkDuplicate(List<Teacher> list) {
        // tổng số bánh được tính cho hết lên đầu, ngày ăn gần đây nhất cho lên đầu
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i).getNumber();
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).getRollNumber().equals(list.get(j).getRollNumber())){
                    if (list.get(i).getDayEat().compareTo(list.get(j).getDayEat()) < 0){ // nếu ngày i trước j
                        list.get(i).setDayEat(list.get(j).getDayEat()); // ngày i = ngày j
                    }
                    sum = sum +  list.get(j).getNumber();
                }
            }
            list.get(i).setNumber(sum);
        }
        // loại bỏ tất cả những mã giáo viên bị trùng ở còn lại, chỉ còn đúng mã giáo duy nhất ở đầu
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i).getRollNumber().equalsIgnoreCase(list.get(j).getRollNumber())){
                    list.remove(list.get(j));
                }
            }
        }
    }

    private static Map<Integer, Teacher> listConvertHashMap(List<Teacher> list){
        Map <Integer, Teacher> teacherMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            teacherMap.put(i,list.get(i));
        }
        return teacherMap;
    }

    private static void writeFile(String s, File f){
        try {
            FileWriter fileWriter = new FileWriter(f,true);
            fileWriter.write(s);
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
