package com.tf.vegout.sharding.dao.sqlProcessor;

import com.tf.vegout.sharding.annotation.Sharding;

public interface SqlProcessor {
    String process(String sql, Sharding sharding);
}
