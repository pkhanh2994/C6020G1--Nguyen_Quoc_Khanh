package service.impl;

import org.springframework.stereotype.Service;
import service.MoneyConvert;
@Service
public class MoneyConvertImpl implements MoneyConvert {
    @Override
    public float moneyConvert(float rate, float usd) {
        return rate*usd;
    }
}
