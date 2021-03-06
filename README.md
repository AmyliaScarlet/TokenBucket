# TokenBucket
A Java Project for TokenBucket by custom annotation

令牌桶算法

令牌桶（token bucket）算法，指的是设计一个容器（即“桶”），由某个组件持续运行往该容器中添加令牌（token），令牌可以是简单的数字、字符或组合，也可以仅仅是一个计数，然后每个请求进入系统时，需要从桶中领取一个令牌，所有请求都必须有令牌才能进入后端系统。当令牌桶空时，拒绝请求；当令牌桶满时，不再往其中添加新的令牌。

令牌桶算法的实现逻辑如下：
首先会有一个定义的时间窗口的访问次数阈值，例如每天1000人，每秒5个请求之类，限流系统一般最小粒度是秒，再小就会因为实现和性能的原因而变得不准确或不稳定，假设是T秒内允许N个请求，那么令牌桶算法则会使令牌添加组件每T秒往令牌桶中添加N个令牌。

其次，令牌桶需要有一个最大值M，当令牌添加组件检测到令牌桶中已经有M个令牌时，剩余的令牌会被丢弃。反映到限流系统中，可以认为是当前系统允许的瞬时最大流量，但不是持续最大流量。例如令牌桶中的令牌最大数量是100个，每秒钟会往其中添加10个新令牌，当令牌满的时候，突然出现100 TPS的流量，这时候是可以承受的，但是假如连续两秒的100 TPS流量就不行，因为令牌添加速度是一秒10个，添加速度跟不上使用速度。
