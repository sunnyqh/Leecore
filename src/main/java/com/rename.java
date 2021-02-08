package com;


import org.junit.jupiter.api.Test;

import java.io.*;


public class rename {
    @Test
    public String text(){
        //提取txt中的名称
        String path = "D:\\work\\Auto-Test\\Leecore\\src\\main\\java\\com\\picture";
        File file = new File(path);
        String result="";
        try{
            BufferedReader br=new BufferedReader(new FileReader(file));
            String s=null;
            //构造一个BufferedReader类来读取文件
            while ((s=br.readLine())!=null){
                result = result + "\n" +s;
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Test
    public  void rename(){
        String result = text();
        //根据\n分割提取值
        String[] splitresult = result.split("\n");
        String path = "C:\\Users\\Administrator\\Pictures\\face";
        File file = new File(path);
        File[] files = file.listFiles();
        int i = 0;
        //照片重新命名后保存
        for (File file1 : files) {
            if (!file1.isDirectory()){
                file1.renameTo(new File(splitresult[i+1]+".jpg"));
                i++;
            }
        }
        System.out.println("执行完成");
    }


}