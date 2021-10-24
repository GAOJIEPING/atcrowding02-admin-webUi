package com.atguigu.util;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity<T> {
    private  static  final String MY_SUCESS="success";
    private  static  final String MY_FAILD="faild";
//   成功或是失败
    private String result;
//    返回的信息
    private String message;
//   返回类型
    private  T data;

//    成功但不返回结果
    public  static <Type> ResultEntity<Type> successWithNoData(){
        return  new ResultEntity<Type>(MY_SUCESS,null,null);
    }
//    请求成功返回结果
    public  static <Type> ResultEntity<Type> successWithHaveData(Type data){
        return  new ResultEntity<Type>(MY_SUCESS,null,data);
    }
    //请求失败返回
    public  static <Type> ResultEntity<Type> errorWithHaveData(String message){
    return  new ResultEntity<Type>(MY_FAILD,message,null);
}


}
