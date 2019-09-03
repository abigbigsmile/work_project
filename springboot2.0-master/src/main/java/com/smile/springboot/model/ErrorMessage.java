package com.smile.springboot.model;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

//@Data : 自动生成set/get方法，toString方法，equals方法，hashCode方法，不带参数的构造方法
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Slf4j
@Repository
public class ErrorMessage<T> {

    private static final Integer OK = 1;
    private static final Integer ERROR = 100;

    //lombok,底层使用字节码技术 ASM，修改字节码文件，生成get和set方法(编译时生成，线上环境不需要，因为线上是运行已编译文件)
    @Setter
    @Getter
    private Integer errCode;

    @Setter
    @Getter
    private String errMsg;

    @Setter
    @Getter
    private String url;

    @Setter
    @Getter
    private T data;

    public ErrorMessage(Integer errCode, String errMsg, String url) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.url = url;
    }

    public static void main(String[] args) {
        ErrorMessage<String> errorMessage = new ErrorMessage<String>(111,"Smile","http","hello");
        System.out.println(errorMessage);
        log.info("Springboot 使用lombok");
    }

}
