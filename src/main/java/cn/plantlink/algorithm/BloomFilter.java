package cn.plantlink.algorithm;

/**
 * 对bitmap进行改进，提升了空间利用率，布隆过滤器主要是用于大数据的查询
 * 布隆过滤器是通过k个hash函数散列出k个位矩阵上的点，如果这些点都是1则说明该数据存在，否则只要有一个不是1就不存在。
 * 布隆过滤器算出不存在的数肯定不存在，算出存在的数可能存在也可能不存在，它是牺牲正确率来换取空间，误判问题通过建立白名单进行补救
 */
public class BloomFilter {

}
