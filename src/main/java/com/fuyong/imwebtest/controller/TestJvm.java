package com.fuyong.imwebtest.controller;



public class TestJvm {
    public static void main(String[] args) throws Exception {
      //  byte[] array1=new byte [10*1024 *1024];
      /*  array1= new byte[1024*1024];
        array1 =new byte[1024*1024];
        array1=null;

        byte [] array2 =new byte[2*1024*1024];

        byte [] array3 =new byte[2*1024*1024];

        array3= new byte[1024*1024];
        array3 =new byte[1024*1024];
        array3 =new byte[1024*1024];
        array3=null;

        byte [] array4 =new byte[2*1024*1024];*/
        Thread.sleep(30000);
        while(true){
            loadData();
        }
    }
    private static void  loadData() throws  Exception{
        byte[] data = null;
        for (int i = 0; i < 4; i++) {
            data =new byte[10*1024*1024];
        }
        data=null;
        byte[] data1 =new byte[10*1024*1024];

        byte[] data2 =new byte[10*1024*1024];

        byte[] data3 =new byte[10*1024*1024];
        data3 =new byte[10*1024*1024];
        Thread.sleep(1000);
    }
}
