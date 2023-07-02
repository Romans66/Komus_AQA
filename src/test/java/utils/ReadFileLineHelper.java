package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class ReadFileLineHelper {

  public static ArrayList<String> ReadFileLineByLine(String fileName) {
    //Объявляем коллекцию
    ArrayList<String> specPwd = new ArrayList<>();
    try {
      //Читаем файл и помещаем его в буфер, далее помещаем в переменную
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      //Читаем файл построчно, пока не будет нулевая строка
      String line = reader.readLine();
      while (line != null) {
        line = reader.readLine();
        if (line != null)
        // обработка строки
        //Записываем все строки в коллекцию, проверяя на null
        specPwd.add(line);
      }
      //Закрываем поток чтения из файла, освобождаем ресурсы
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //Возвращаем коллекцию
    return specPwd;
  }
  public static LinkedHashMap<String, String> ReadFileLineByLineWithSplit(String fileName) {
    //Объявляем коллекцию
    LinkedHashMap <String, String> innAndKk = new LinkedHashMap<>();
    try {
      //Читаем файл и помещаем его в буфер, далее помещаем в переменную
      BufferedReader reader = new BufferedReader(new FileReader(fileName));
      String line = reader.readLine();
      while(line != null) {
        line = reader.readLine();
        if (line != null) {
          String[] compValues = line.split(",");
          String key = compValues[0];
          String value = compValues[1];
          innAndKk.put(key, value);
        }
      }
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return innAndKk;
  }
}

