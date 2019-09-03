package com.springcloud.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import com.springcloud.apigateway.exception.RateLimiteException;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/**
 * 使用Guava RateLimiter + Zuul的filter实现限流（令牌桶算法：拿到令牌请求才能继续）
 */
@Component
public class RateLimiteFilter extends ZuulFilter {

    private RateLimiter rateLimiter = RateLimiter.create(10);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    //限流的filter应该具有最高优先级
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER - 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 首先通过RateLimiter.create(1);创建一个限流器，参数代表每秒生成的令牌数，通过limiter.acquire(i);来以阻塞的方式获取令牌，当然也可以通过tryAcquire(int permits, long timeout, TimeUnit unit)来设置等待超时时间的方式获取令牌，如果超timeout为0，则代表非阻塞，获取不到立即返回。
     *
     * 作者：人在码途
     * 链接：https://www.jianshu.com/p/5d4fe4b2a726
     * 来源：简书
     * 简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
     * @return
     */
    @Override
    public Object run(){
        if(!rateLimiter.tryAcquire()){
            throw new RateLimiteException("The rate is limited to 10 times per second");
        }
        return null;
    }
}
