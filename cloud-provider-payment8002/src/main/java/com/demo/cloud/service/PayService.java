package com.demo.cloud.service;

import com.demo.cloud.entities.Pay;

import java.util.List;

/**
 * @program: springcloud-demo
 * @description:
 * @author: David
 * @create: 2024-04-29 22:42
 **/
public interface PayService {
    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
