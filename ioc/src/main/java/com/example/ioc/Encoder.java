package com.example.ioc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Encoder {
    private IEncoder iEncoder;

    // IEncoder가 두개이기 때문에 spring에서 어떤걸 매칭해줘야 하는지 몰라 에러가 남
    // 이를 해결하기 위해선 어떤 것을 매칭할지 @Qualifier를 통해 명시해 주면 됨
    public Encoder(IEncoder iEncoder) {
//    public Encoder(@Qualifier("urlEncoder") IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }

    public void setIEncoder(IEncoder iEncoder) {
        this.iEncoder = iEncoder;
    }
    public String encode(String message) {
        return iEncoder.encode(message);
    }
}
