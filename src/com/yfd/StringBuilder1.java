package com.yfd;

import java.util.*;

public class StringBuilder1 {
    //超过maxLength抛异常
    int maxLength;
    char value[];

    /*
     * 默认初始化
     * */
    public StringBuilder1(){
        this.value="".toCharArray();
    }

    /*
     * 数组初始化
     * @param value
     * */
    public StringBuilder1(char[] value){
        this.value=value;
    }


    /*
     * 字符串初始化
     * @param source
     * */
    public StringBuilder1(String source){
        //防御编程
        if(source==null){
            source="";
        }
        //空指针异常
        this.value=source.toCharArray();
    }

    /*
     * 添加字符串进去
     * @return
     * */
    public synchronized StringBuilder1 append(String append){
        //给value数组扩容
        if(append==null){
            return this;
        }

        int newCapaticy=value.length+append.length();
        //校验最大容量
        if(newCapaticy>this.maxLength){
            return this;
        }

        ensureCapacity(append,newCapaticy);
        char[] newChars=Arrays.copyOf(value, newCapaticy);
        //传入的字符串写入新的数组
        char[] appendChars=append.toCharArray();
        //聚合两个数组
        int appendLength=appendChars.length;
        for(int i=0;i<appendLength;i++){
            newChars[newChars.length-appendLength+i]=newChars[i];
        }
        value=newChars;
        return this;
    }
    /*
     * 保证容量
     * @param append
     * @param newCapaticy
     * */
    private void ensureCapacity(String append, int newCapaticy) {
        // TODO Auto-generated method stub
        char[] chars=Arrays.copyOf(value, newCapaticy);
    }

    public String toString(){
        return String.valueOf(value);
    }
    public static void main(String[] args) {
        String s="Hello World";
        StringBuilder1 stringBuilder1=new StringBuilder1(s);
        StringBuilder1 hello=stringBuilder1.append("hello");
        System.out.println(stringBuilder1);
        System.out.println(hello);
    }
}
