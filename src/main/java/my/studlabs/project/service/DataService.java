package my.studlabs.project.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataService
{
    public List<Double> getList(boolean isSorted)
    {
        List<Double> NumberList = new ArrayList<>();
        try
        {
            InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("input.txt");
            if (in != null)
            {
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = br.readLine();
                while (line != null)
                {
                    Double number = Double.valueOf(line);
                    NumberList.add(number);
                    line = br.readLine();
                }
            }
            else throw new FileNotFoundException("Файл с данными не найден.");
        } catch (IOException ex)
        {
            System.out.println("Ошибка при чтении данных.");
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        if (isSorted) { NumberList.sort((Double a, Double b) -> a.compareTo(b)); }
        return NumberList;
    }

    public DataService() { }
}
