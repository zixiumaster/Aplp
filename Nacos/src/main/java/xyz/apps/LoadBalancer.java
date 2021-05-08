package xyz.apps;

import com.alibaba.nacos.api.naming.pojo.Instance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: LoadBalancer
 * @Description:
 * @Author daiyating
 * @Date 2020/9/10 0010
 * @Version 1.0
 */
@Component
public class LoadBalancer {
    /**
     * 从0开始计数，应用重启后清0
     */
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 轮询获取服务实例
     * @param instanceList
     * @return
     */
    public Instance getSingleAddress(List<Instance> instanceList){
        //获取实例下标
        int index = atomicInteger.incrementAndGet() % instanceList.size();
        return instanceList.get(index);
    }
}
