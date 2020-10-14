package top.zhaogaoshang.store.common;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * 赵高尚
 * 2020/10/3 0003
 */
@Component
public class Utils {
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
